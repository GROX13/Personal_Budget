package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.model.Category;

import java.util.List;

public interface DataBaseAdapter {
    boolean existsDataBase();

    void createDatabase();

    void dropDataBase();

    List<Category> readFromDataBase();

    void saveToDataBase(List<Category> data);
}
