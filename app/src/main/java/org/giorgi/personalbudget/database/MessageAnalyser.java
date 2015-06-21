package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/16/2015.
 */
public class MessageAnalyser implements DataBaseAnalyser {
    public static final String[] defaultCategories = new String[]{
            "Utility Costs", "Entertainment", "Eat & Drinks",
            "Petrol", "Phone", "Others",
    };

    public static final String[] defaultCategoriesRules = new String[]{
            "Telasi;UnitedWater;Akhteli;Komunaluri", "",
            "LTD FRESCO SHOPING;JSC SMART RETAIL;CARREFOUR;LTD NIKORA TRADE",
            "", "Mobiluri balansis shevseba;Lai-Lai", "",
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
        Integer[] myPrediction = new Integer[categoryList.size()];
        // TODO:
    }

}
