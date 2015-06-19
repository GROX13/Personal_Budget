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
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Transaction;

public class TransactionAdapter extends BaseAdapter {
    private Activity activity;

    public TransactionAdapter(Activity categoryActivity) {
        this.activity = categoryActivity;
        PersonalBudget.registerAdapter(this);
    }

    @Override
    public int getCount() {
        return PersonalBudget.getSelectedCategory().getTransactions().size();
    }

    @Override
    public Object getItem(int position) {
        return PersonalBudget.getSelectedCategory().getTransactions().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.element_transaction, parent, false);

        ImageView image = (ImageView) row.findViewById(R.id.image);
        TextView amount = (TextView) row.findViewById(R.id.amount);
        TextView date = (TextView) row.findViewById(R.id.date);

        Transaction transaction = PersonalBudget
                .getSelectedCategory().getTransactions().get(position);

        if (transaction.isExpense())
            image.setImageResource(R.drawable.expence);
        else
            image.setImageResource(R.drawable.income);

        amount.setText(String.valueOf(transaction.getAmount()));
        date.setText(String.valueOf(transaction.getDateTime()));

        return row;
    }

}
