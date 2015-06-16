package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Implement!
 * Created by Giorgi on 6/15/2015.
 */
public class StubAnalyser implements DataBaseAnalyser {
    public static final String UTILITY_COSTS = "Utility Costs";
    public static final String ENTERTAINMENT = "Entertainment";
    public static final String EAT_AND_DRINKS = "Eat & Drinks";
    public static final String PETROL = "Petrol";
    public static final String PHONE = "Phone";
    public static final String OTHERS = "Others";

    @Override
    public List<Category> getCategoryList() {
        List<Category> categories = new ArrayList<>();
        Category category;
        category = new Category(UTILITY_COSTS);
        categories.add(category);
        category = new Category(ENTERTAINMENT);
        categories.add(category);
        category = new Category(EAT_AND_DRINKS);
        categories.add(category);
        category = new Category(PETROL);
        categories.add(category);
        category = new Category(PHONE);
        categories.add(category);
        category = new Category(OTHERS);
        categories.add(category);
        return categories;
    }

}
