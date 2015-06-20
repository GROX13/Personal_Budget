package org.giorgi.personalbudget.application;

import android.app.Application;
import android.widget.BaseAdapter;

import org.giorgi.personalbudget.database.StubAnalyser;
import org.giorgi.personalbudget.model.Category;

import java.util.ArrayList;
import java.util.List;

public class PersonalBudget extends Application {
    private static int selected = -1;
    private static List<Category> categoryList;
    private static ArrayList<BaseAdapter> adapters = new ArrayList<>();

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

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: This line of code should be changed to real analyser!
        StubAnalyser analyser = new StubAnalyser();
        categoryList = analyser.getCategoryList();
    }
}
