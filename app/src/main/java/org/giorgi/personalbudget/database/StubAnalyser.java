package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.util.ArrayList;
import java.util.List;

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
        category.addTransaction(new Transaction(30.70f, false, "02/11/2038", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2038", "Message"));
        categories.add(category);
        category = new Category(ENTERTAINMENT);
        category.addTransaction(new Transaction(30.70f, false, "02/11/2038", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2038", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2038", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2038", "Message"));
        categories.add(category);
        category = new Category(EAT_AND_DRINKS);
        category.addTransaction(new Transaction(30.70f, false, "02/11/2038", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2013", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2014", "Message"));
        categories.add(category);
        category = new Category(PETROL);
        category.addTransaction(new Transaction(30.70f, false, "02/11/2018", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2038", "Message"));
        category.addTransaction(new Transaction(70.73f, false, "05/11/2018", "Message"));
        categories.add(category);
        category = new Category(PHONE);
        category.addTransaction(new Transaction(30.70f, false, "02/11/2018", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2013", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(70.73f, false, "05/11/2018", "Message"));
        categories.add(category);
        category = new Category(OTHERS);
        category.addTransaction(new Transaction(30.70f, false, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(10.73f, false, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(30.70f, true, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(10.73f, true, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(10.73f, true, "05/11/2018", "Message"));
        category.addTransaction(new Transaction(70.73f, true, "05/11/2018", "Message"));
        categories.add(category);
        return categories;
    }

}
