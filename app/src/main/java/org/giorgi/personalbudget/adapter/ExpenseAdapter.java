package org.giorgi.personalbudget.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.activity.CategoryActivity;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Transaction;

import java.util.List;

public class ExpenseAdapter extends BaseAdapter {
    private static List<Transaction> transactionList;
    private final Activity activity;

    public ExpenseAdapter(Activity activity) {
        transactionList = null;
        this.activity = activity;
        PersonalBudget.registerAdapter(this);
    }

    @Override
    public int getCount() {
        transactionList = PersonalBudget.getSelectedCategory()
                .getExpensesInPeriod(CategoryActivity.start, CategoryActivity.end);
        return transactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return transactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        @SuppressLint("ViewHolder")
        View row = inflater.inflate(R.layout.element_transaction, parent, false);

        ImageView image = (ImageView) row.findViewById(R.id.image);
        TextView amount = (TextView) row.findViewById(R.id.amount);
        TextView date = (TextView) row.findViewById(R.id.date);

        Transaction transaction = transactionList.get(position);

        image.setImageResource(R.drawable.expence);

        amount.setText(String.valueOf(transaction.getAmount()));
        date.setText(String.valueOf(transaction.getDateTime()));
        return row;
    }
}
