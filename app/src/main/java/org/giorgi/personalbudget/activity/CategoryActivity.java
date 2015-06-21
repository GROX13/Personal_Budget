package org.giorgi.personalbudget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.adapter.TransactionAdapter;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.dialogs.ChangeRuleDialogFragment;
import org.giorgi.personalbudget.dialogs.DatePickerFragment;
import org.giorgi.personalbudget.dialogs.MoveCategoryDialogFragment;
import org.giorgi.personalbudget.model.Category;

public class CategoryActivity extends AppCompatActivity {

    public static String start = null;
    public static String end = null;
    private int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        selected = -1;
        Category category = PersonalBudget.getSelectedCategory();
        setTitle(category.getCategoryName());

        ListView listView = (ListView) findViewById(R.id.activity_list);
        listView.setAdapter(new TransactionAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        DialogFragment newFragment;
        switch (id) {
            case R.id.action_move:
                if (selected != -1) {
                    MoveCategoryDialogFragment newDialogFragment = new MoveCategoryDialogFragment();
                    newDialogFragment.setSelected(selected);
                    newDialogFragment.show(getSupportFragmentManager(), "Move category");
                } else {
                    CharSequence text = "Please first select transaction!";
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                    toast.show();
                }
                return true;
            case R.id.action_change_rules:
                newFragment = new ChangeRuleDialogFragment();
                newFragment.show(getSupportFragmentManager(), "Change category rule");
                return true;
            case R.id.action_filter:
                start = null;
                end = null;
                Intent intent = new Intent(this, FilterActivity.class);
                DatePickerFragment.setIntent(intent);
                newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
                newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
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
