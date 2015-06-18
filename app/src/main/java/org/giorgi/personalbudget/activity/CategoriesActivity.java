package org.giorgi.personalbudget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.adapter.CategoryAdapter;
import org.giorgi.personalbudget.application.PersonalBudget;


public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(new CategoryAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PersonalBudget.setSelected(position);
                Intent intent = new Intent(view.getContext(), CategoryActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        switch (id) {
            case R.id.action_chart_categories:
                intent = new Intent(this, CategoriesChartActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.action_chart_monthly:
                intent = new Intent(this, MonthlyChartActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.action_add_category:
                // TODO:
                return true;
            case R.id.action_delete_category:
                // TODO:
                return true;
            case R.id.action_settings:
                // TODO:
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
