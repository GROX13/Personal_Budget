package org.giorgi.personalbudget.model;

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
        this.rule = new String[] {};
        this.transactions = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
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

    public float getIncomeInPeriod(String startDate, String endDate) {
        float income = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isIncome())
                if (isInPeriod(transaction, startDate, endDate))
                    income += transaction.getAmount();
        }
        return income;
    }

    public float getExpensesInPeriod(String startDate, String endDate) {
        float expenses = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isExpense())
                if (isInPeriod(transaction, startDate, endDate))
                    expenses += transaction.getAmount();
        }
        return expenses;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private boolean isInPeriod(Transaction transaction, String startDate, String endDate) {
        // TODO: Needs to be implemented!
        if (transaction.getDateTime() == "")
            return false;
        return true;
    }


    public void setRule(String rule) {
        this.rule = rule.split(";");
    }


    public int getPrediction(String message) {
        // TODO: Implement!
        return 0;
    }
}
