package org.giorgi.personalbudget.application;

import android.app.Application;

import org.giorgi.personalbudget.database.StubAnalyser;
import org.giorgi.personalbudget.model.Category;

import java.util.List;

public class PersonalBudget extends Application {
    private static List<Category> categoryList;

    public static List<Category> getCategoryList() {
        return categoryList;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        StubAnalyser analyser = new StubAnalyser();
        categoryList = analyser.getCategoryList();
    }
}
