package org.giorgi.personalbudget.model;

import java.util.ArrayList;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/15/2015.
 */
public class Category {
    private String categoryName;
    private ArrayList<Transaction> transactions;

    public Category(String category) {
        this.categoryName = category;
        this.transactions = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double getIncome() {
        double income = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isIncome())
                income += transaction.getAmount();
        }
        return income;
    }

    public double getExpenses() {
        double expenses = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isExpense())
                expenses += transaction.getAmount();
        }
        return expenses;
    }

    public double getIncomeInPeriod(String startDate, String endDate) {
        double income = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isIncome())
                if (isInPeriod(transaction, startDate, endDate))
                    income += transaction.getAmount();
        }
        return income;
    }

    public double getExpensesInPeriod(String startDate, String endDate) {
        double expenses = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction.isExpense())
                if (isInPeriod(transaction, startDate, endDate))
                    expenses += transaction.getAmount();
        }
        return expenses;
    }

    private boolean isInPeriod(Transaction transaction, String startDate, String endDate) {
        // TODO: Needs to be implemented!
        if (transaction.getDateTime() == "")
            return false;
        return true;
    }


}
