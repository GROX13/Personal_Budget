package org.giorgi.personalbudget.model;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/16/2015.
 */
public class Transaction {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private float amount;
    private boolean income;
    private String time;

    public Transaction(float amount, boolean income, String time) {
        this.amount = amount;
        this.income = income;
        this.time = time;
    }

    public float getAmount() {
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
