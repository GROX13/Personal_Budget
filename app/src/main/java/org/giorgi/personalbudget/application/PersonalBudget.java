package org.giorgi.personalbudget.application;

import android.app.Application;

import org.giorgi.personalbudget.database.StubAnalyser;
import org.giorgi.personalbudget.model.Category;

import java.util.List;

public class PersonalBudget extends Application {
    private static List<Category> categoryList;
    private static int selected = -1;

    public static List<Category> getCategoryList() {
        return categoryList;
    }

    public static void setSelected(int selected) {
        PersonalBudget.selected = selected;
    }

    public static Category getSelectedCategory() {
        return categoryList.get(selected);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: This line of code should be changed to real analyser!
        StubAnalyser analyser = new StubAnalyser();
        categoryList = analyser.getCategoryList();
    }
}
