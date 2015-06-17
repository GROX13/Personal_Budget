package org.giorgi.personalbudget.model;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/16/2015.
 */
public class Transaction {
    public static final String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";

    private double amount;
    private boolean income;
    private String time;

    public Transaction(double amount, boolean income, String time) {
        this.amount = amount;
        this.income = income;
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isIncome() {
        return income;
    }

    public boolean isExpense() {
        return !income;
    }

    public String getDateTime() {
        return time;
    }
}
