package org.giorgi.personalbudget.database;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MessageAnalyser extends BroadcastReceiver implements DataBaseAnalyser {
    public static final String[] defaultCategories = new String[]{
            "Utility Costs", "Entertainment", "Eat & Drinks",
            "Petrol", "Phone", "Others",
    };

    public static final String[] defaultCategoriesRules = new String[]{
            "Telasi;UnitedWater;Akhteli;Komunaluri", "",
            "FRESCO;SHOPING;SMART;RETAIL;CARREFOUR;NIKORA;TRADE",
            "", "Mobiluri;balansis shevseba;Lai-Lai", "",
    };

    public static final String incomeKey = "charicxva";
    public static final String expenseKey = "gatana;gasavlis;ganagdeba;gadaxda";

    private List<Category> categoryList;
    private DataBaseAdapter dataBaseAdapter;
    private MessageBaseAdapter messageBaseAdapter;

    public MessageAnalyser
            (DataBaseAdapter dataBaseAdapter, MessageBaseAdapter messageBaseAdapter) {
        this.dataBaseAdapter = dataBaseAdapter;
        this.messageBaseAdapter = messageBaseAdapter;
    }

    @Override
    public List<Category> getCategoryList() {
        if (dataBaseAdapter.existsDataBase())
            categoryList = dataBaseAdapter.readFromDataBase();
        else {
            categoryList = new ArrayList<>();
            for (int i = 0; i < defaultCategories.length; i++) {
                String defaultCategory = defaultCategories[i];
                String defaultRule = defaultCategoriesRules[i];
                Category c = new Category(defaultCategory);
                c.setRule(defaultRule);
                categoryList.add(c);
            }
        }
        analyseMessages(messageBaseAdapter.readUnreadMessages());
        return categoryList;
    }

    private void analyseMessages(List<String> strings) {
        for (int j = 0; j < strings.size(); j++) {
            String messageBody = strings.get(j);
            Transaction t = analyseMessage(messageBody);
            if (t != null) {
                List<Integer> prd = new ArrayList<>();
                for (int i = 0; i < categoryList.size(); i++) {
                    int prediction = 0;
                    Category c = categoryList.get(i);
                    prediction = c.getPrediction(messageBody);
                    if (c.getCategoryName()
                            .equals(defaultCategories[defaultCategories.length - 1])) {
                        prediction += 1;
                    }
                    prd.add(prediction);
                }
                addTransaction(t, prd, categoryList);
            }
        }
    }

    private Transaction analyseMessage(String message) {
        String date = "";
        String amount = "";
        String BOGAmount = "tanxa:";
        String TBCAmount = "Tanxa:";
        String BOGDate = "tarigi:";
        String[] TBCDates = new String[]{
                "Sabarate operacia", "Mobiluri balansis shevseba:", "Tanxis charicxva"};
        String TBCDate = "Komunaluri gadaxda:";

        if (message.contains(BOGAmount)) {
            int index = message.indexOf("GEL");
            int i = index + 3;
            while (message.charAt(i) == ' ')
                i++;
            for (; i < message.length(); i++) {
                if (message.charAt(i) == '.') {
                    amount += message.charAt(i);
                    amount += message.charAt(i + 1);
                    amount += message.charAt(i + 2);
                    break;
                } else {
                    amount += message.charAt(i);
                }
            }
            index = message.indexOf(BOGDate);
            i = index + BOGDate.length();
            while (message.charAt(i) == ' ')
                i++;
            int j = 0;
            for (; i < message.length() && j <= 10; i++, j++) {
                date += message.charAt(i);
            }

            return new Transaction(Float.valueOf(amount), (message.contains(incomeKey)), date);
        } else if (message.contains(TBCAmount)) {
            int index = message.indexOf(TBCAmount);
            int i = index + TBCAmount.length();
            while (message.charAt(i) == ' ')
                i++;
            for (; i < message.length(); i++) {
                if (message.charAt(i) == '.') {
                    amount += message.charAt(i);
                    amount += message.charAt(i + 1);
                    amount += message.charAt(i + 2);
                    break;
                } else {
                    amount += message.charAt(i);
                }
            }

            i = 0;
            index = message.indexOf(TBCDate);
            while (index < 0 && i < TBCDates.length) {
                TBCDate = TBCDates[i++];
                index = message.indexOf(TBCDate);
            }

            i = index + TBCDate.length();
            while (message.charAt(i) == ' ')
                i++;
            int j = 0;
            for (; i < message.length() && j <= 10; i++, j++) {
                date += message.charAt(i);
            }

            return new Transaction(Float.valueOf(amount), (message.contains(incomeKey)), date);
        } else
            return null;
    }

    @SuppressLint("NewApi")
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            List<Category> cl = PersonalBudget.getCategoryList();
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = smsMessage.getMessageBody();
                Transaction t = analyseMessage(messageBody);
                if (t != null) {
                    List<Integer> prd = new ArrayList<>();
                    for (int i = 0; i < cl.size(); i++) {
                        int prediction = 0;
                        Category c = cl.get(i);
                        prediction = c.getPrediction(messageBody);
                        if (c.getCategoryName()
                                .equals(defaultCategories[defaultCategories.length - 1])) {
                            prediction += 1;
                        }
                        prd.add(prediction);
                    }
                    addTransaction(t, prd, cl);
                    // This message was received in runtime so adapters need notification
                    PersonalBudget.notifyAdapters();
                }
            }
        }
    }

    private void addTransaction(Transaction t, List<Integer> prd, List<Category> cl) {
        int maxIndex = 0;
        for (int i = 0; i < prd.size(); i++)
            if (prd.get(maxIndex) < prd.get(i))
                maxIndex = i;
        cl.get(maxIndex).addTransaction(t);
    }
}
