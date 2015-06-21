package org.giorgi.personalbudget.database;

import android.content.Context;

import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.util.List;

public class DataBase implements DataBaseAdapter {

    private final DataBaseHandler handler;

    public DataBase(Context context) {
        this.handler = new DataBaseHandler(context);
    }

    @Override
    public boolean existsDataBase() {
        return handler.exists();
    }

    @Override
    public void createDatabase() {

    }

    @Override
    public void dropDataBase() {
        handler.emptyDataBase();
    }

    @Override
    public List<Category> readFromDataBase() {
        List<Category> categories = handler.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            List<Transaction> t = handler.getCategoryTransactions(i);
            for (int j = 0; j < t.size(); j++) {
                categories.get(i).addTransaction(t.get(j));
            }
        }
        return categories;
    }

    @Override
    public void saveToDataBase(List<Category> data) {
        for (int i = 0; i < data.size(); i++) {
            handler.addCategory(i, data.get(i));
            List<Transaction> t = data.get(i).getTransactions();
            for (int j = 0; j < t.size(); j++) {
                handler.addTransaction(i, t.get(j));
            }
        }
    }

}
