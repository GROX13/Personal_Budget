package org.giorgi.personalbudget.application;

import android.app.Application;

import org.giorgi.personalbudget.database.StubAnalyser;
import org.giorgi.personalbudget.model.Category;

import java.util.List;

public class PersonalBudget extends Application {
    private static List<Category> categoryList;
    private static int selected = -1;

    public static void addCategory(String category) {
        // TODO: Implement!
        categoryList.add(new Category(category));
    }

    public static void removeCategory(int index) {
        // TODO: Implement!
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

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: This line of code should be changed to real analyser!
        StubAnalyser analyser = new StubAnalyser();
        categoryList = analyser.getCategoryList();
    }
}
