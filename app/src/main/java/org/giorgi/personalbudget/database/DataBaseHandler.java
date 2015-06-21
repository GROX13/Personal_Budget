package org.giorgi.personalbudget.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    /* All Static variables */

    // Data Base Version
    private static final int DATABASE_VERSION = 1;

    // Data Base Name
    private static final String DATABASE_NAME = "personal_budget";

    // Category table name
    private static final String TABLE_CATEGORY = "categories";
    // Transaction table name
    private static final String TABLE_TRANSACTION = "transactions";

    // Category table columns names
    private static final String KEY_CATEGORY_ID = "id";
    private static final String KEY_CATEGORY_NAME = "name";
    private static final String KEY_CATEGORY_RULES = "rules";

    // Transaction table columns names
    private static final String KEY_TRANSACTION_ID = "id";
    private static final String KEY_TRANSACTION_CATEGORY = "category_id";
    private static final String KEY_TRANSACTION_INCOME = "income";
    private static final String KEY_TRANSACTION_MESSAGE = "message";
    private static final String KEY_TRANSACTION_AMOUNT = "amount";
    private static final String KEY_TRANSACTION_DATE = "transaction_date";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void createCategoryTable(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_CATEGORY + " " +
                "(" + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY, " +
                KEY_CATEGORY_NAME + " TEXT, " + KEY_CATEGORY_RULES + " TEXT)";
        db.execSQL(query);
    }

    private void dropCategoryTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
    }

    private void createTransactionTable(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TRANSACTION +
                " (" + KEY_TRANSACTION_ID + " INTEGER PRIMARY KEY, " +
                KEY_TRANSACTION_CATEGORY + " INTEGER, " + KEY_TRANSACTION_MESSAGE + " TEXT, " +
                KEY_TRANSACTION_AMOUNT + " REAL, " + KEY_TRANSACTION_DATE + " TEXT, " +
                KEY_TRANSACTION_INCOME + " INTEGER)";
        db.execSQL(query);
    }

    private void dropTransactionTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createCategoryTable(db);
        createTransactionTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropCategoryTable(db);
        dropTransactionTable(db);
        onCreate(db);
    }

    public void emptyDataBase() {
        onUpgrade(this.getWritableDatabase(), DATABASE_VERSION, DATABASE_VERSION);
    }

    public void addCategory(int index, Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_ID, index);
        values.put(KEY_CATEGORY_NAME, category.getCategoryName());
        values.put(KEY_CATEGORY_RULES, category.getRuleString());

        db.insert(TABLE_CATEGORY, null, values);
        db.close();
    }

    public void addTransaction(int categoryId, Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TRANSACTION_CATEGORY, categoryId);
        values.put(KEY_TRANSACTION_MESSAGE, transaction.getMessage());
        values.put(KEY_TRANSACTION_AMOUNT, transaction.getAmount());
        values.put(KEY_TRANSACTION_DATE, transaction.getDateTime());
        values.put(KEY_TRANSACTION_INCOME, transaction.isIncome());

        db.insert(TABLE_TRANSACTION, null, values);
        db.close();
    }

    public List<Category> getCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Category> categories = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category(cursor.getString(1));
                category.setRule(cursor.getString(2));
                categories.add(Integer.parseInt(cursor.getString(0)), category);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return categories;
    }

    public List<Transaction> getCategoryTransactions(int categoryId) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Transaction> transactions = new ArrayList<>();

        Cursor cursor = db.query(TABLE_TRANSACTION,
                new String[]{
                        KEY_TRANSACTION_MESSAGE,
                        KEY_TRANSACTION_AMOUNT,
                        KEY_TRANSACTION_DATE,
                        KEY_TRANSACTION_INCOME
                },
                KEY_TRANSACTION_ID + "=?",
                new String[]{String.valueOf(categoryId)}, null, null, null, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                transactions.add(new Transaction(
                        cursor.getFloat(1),
                        (cursor.getInt(3) > 0),
                        cursor.getString(2),
                        cursor.getString(0)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return transactions;
    }

    public boolean exists() {
        String countQuery = "SELECT  * FROM " + TABLE_CATEGORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        boolean b = (cursor.getCount() > 0);
        cursor.close();
        return b;
    }

}
