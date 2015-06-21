package org.giorgi.personalbudget.application;

import android.app.Application;
import android.widget.BaseAdapter;

import org.giorgi.personalbudget.database.DataBase;
import org.giorgi.personalbudget.database.DataBaseAdapter;
import org.giorgi.personalbudget.database.DataBaseAnalyser;
import org.giorgi.personalbudget.database.MessageAnalyser;
import org.giorgi.personalbudget.database.MessageBaseAdapter;
import org.giorgi.personalbudget.database.StubMessageBase;
import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PersonalBudget extends Application {
    private static int selected = -1;
    private static List<Category> categoryList;
    private static ArrayList<BaseAdapter> adapters = new ArrayList<>();
    private static DataBaseAdapter dataBaseAdapter;

    public static void addCategory(Category category) {
        categoryList.add(category);
        notifyAdapters();
    }

    public static void removeCategory(int index) {
        categoryList.remove(index);
        PersonalBudget.selected = -1;
        notifyAdapters();
    }

    public static int getSelected() {
        return selected;
    }

    public static void setSelected(int selected) {
        PersonalBudget.selected = selected;
    }

    public static Category getSelectedCategory() {
        return selected < 0 ? null : categoryList.get(selected);
    }

    public static List<Category> getCategoryList() {
        return categoryList;
    }

    public static void registerAdapter(BaseAdapter adapter) {
        adapters.add(adapter);
    }

    public static void notifyAdapters() {
        for (int i = 0; i < adapters.size(); i++) {
            adapters.get(i).notifyDataSetChanged();
        }
    }

    public static void move(int selected, int which) {
        Transaction t = PersonalBudget.getSelectedCategory().removeTransaction(selected);
        PersonalBudget.categoryList.get(which).addTransaction(t);
        notifyAdapters();
    }

    public static void saveToDataBase() {
        if (dataBaseAdapter.existsDataBase())
            dataBaseAdapter.dropDataBase();
        else
            dataBaseAdapter.createDatabase();
        dataBaseAdapter.saveToDataBase(categoryList);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /* This line of code should be changed to real analyser! */
        // DataBaseAnalyser analyser = new StubAnalyser();

        /* Line below is used in case you don't want to use anything from db */
        // dataBaseAdapter = new StubDataBase();

        /* Line below is used in case you want to use information from real db */
        dataBaseAdapter = new DataBase(this);

        MessageBaseAdapter messageBaseAdapter = new StubMessageBase();
        DataBaseAnalyser analyser = new MessageAnalyser(dataBaseAdapter, messageBaseAdapter);
        categoryList = analyser.getCategoryList();
    }
}
