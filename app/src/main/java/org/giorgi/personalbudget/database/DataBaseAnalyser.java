package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;

import java.util.List;

public interface DataBaseAnalyser {
    List<Category> getCategoryList();
}
