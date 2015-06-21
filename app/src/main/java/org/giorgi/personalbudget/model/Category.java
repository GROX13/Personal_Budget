package org.giorgi.personalbudget.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/15/2015.
 */
public class Category {
    private String categoryName;
    private ArrayList<Transaction> transactions;
    private String[] rule;

    public Category(String category) {
        this.categoryName = category;
        this.rule = new String[]{};
        this.transactions = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public Transaction removeTransaction(int index) {
        Transaction t = this.transactions.get(index);
        this.transactions.remove(index);
        return t;
    }

    public float getIncome() {
        float income = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isIncome())
                income += transaction.getAmount();
        }
        return income;
    }

    public float getExpenses() {
        float expenses = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isExpense())
                expenses += transaction.getAmount();
        }
        return expenses;
    }

    public List<Transaction> getIncomeInPeriod(String startDate, String endDate) {
        List<Transaction> t = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isIncome())
                if (isInPeriod(transaction, startDate, endDate))
                    t.add(transaction);
        }
        return t;
    }

    public List<Transaction> getExpensesInPeriod(String startDate, String endDate) {
        List<Transaction> t = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isExpense())
                if (isInPeriod(transaction, startDate, endDate))
                    t.add(transaction);
        }
        return t;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private boolean isInPeriod(Transaction transaction, String startDate, String endDate) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(Transaction.DATE_FORMAT);
        try {
            return sdf.parse(startDate).before(sdf.parse(transaction.getDateTime()))
                    && sdf.parse(transaction.getDateTime()).before(sdf.parse(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setRule(String rule) {
        this.rule = rule.split(";");
    }

    public int getPrediction(String message) {
        int prediction = 0;
        for (String aRule : rule) {
            if (message.contains(aRule))
                prediction++;
        }
        return prediction * 2;
    }

    public String getRuleString() {
        return TextUtils.join(";", rule);
    }
}
