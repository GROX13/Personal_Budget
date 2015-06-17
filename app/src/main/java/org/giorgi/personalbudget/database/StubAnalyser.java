package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

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
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        categories.add(category);
        category = new Category(ENTERTAINMENT);
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        categories.add(category);
        category = new Category(EAT_AND_DRINKS);
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        categories.add(category);
        category = new Category(PETROL);
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(70.73, false, "05/11/2013 13:58:38"));
        categories.add(category);
        category = new Category(PHONE);
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(70.73, false, "05/11/2013 13:58:38"));
        categories.add(category);
        category = new Category(OTHERS);
        category.addTransaction(new Transaction(30.70, false, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, false, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(30.70, true, "02/11/2013 17:58:38"));
        category.addTransaction(new Transaction(10.73, true, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(10.73, true, "05/11/2013 13:58:38"));
        category.addTransaction(new Transaction(70.73, true, "05/11/2013 13:58:38"));
        categories.add(category);
        return categories;
    }

}
