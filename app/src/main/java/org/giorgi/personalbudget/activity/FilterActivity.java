package org.giorgi.personalbudget.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.activity.CategoryActivity;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Transaction;

import java.util.List;


public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

//        List<Transaction> filtered =
//                PersonalBudget.getSelectedCategory().getExpensesInPeriod(CategoryActivity.start, CategoryActivity.end);
        Log.d("Start", CategoryActivity.start);
        Log.d("End", CategoryActivity.end);

        CategoryActivity.start = null;
        CategoryActivity.end = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
