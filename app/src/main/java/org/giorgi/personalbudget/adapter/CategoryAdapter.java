package org.giorgi.personalbudget.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.application.PersonalBudget;


/**
 * Represents a CategoryAdapter which is used for displaying
 * categories as list view.
 * <p/>
 * Created by Giorgi on 6/16/2015.
 */
public class CategoryAdapter extends BaseAdapter {
    private Activity activity;

    public CategoryAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return PersonalBudget.getCategoryList().size();
    }

    @Override
    public Object getItem(int position) {
        return PersonalBudget.getCategoryList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View row;
        row = inflater.inflate(R.layout.element_category, parent, false);
        TextView name = (TextView) row.findViewById(R.id.element_label);
        name.setText(PersonalBudget.getCategoryList().get(position).getCategoryName());
        return row;
    }
}