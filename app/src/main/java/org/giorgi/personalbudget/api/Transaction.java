package org.giorgi.personalbudget.api;

public class Transaction {
    private double amount;
    private boolean incoming;
    private String date;

    public Transaction(double amount, boolean incoming, String date) {

        this.amount = amount;
        this.incoming = incoming;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isIncoming() {
        return incoming;
    }

    public String getDate() {
        return date;
    }
}
