package org.giorgi.personalbudget.api;

import java.util.ArrayList;
import java.util.Iterator;

public class Category {

    private String name;
    private ArrayList<Transaction> transactions;

    public Category(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double getIncomingAmount() {
        double amount = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction tr = transactions.get(i);
            if (tr.isIncoming())
                amount += tr.getAmount();
        }
        return amount;
    }

    public double getOutgoingAmount() {
        double amount = 0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction tr = transactions.get(i);
            if (!tr.isIncoming())
                amount += tr.getAmount();
        }
        return amount;
    }

    public Iterator getIterator() {
        return transactions.iterator();
    }

}
