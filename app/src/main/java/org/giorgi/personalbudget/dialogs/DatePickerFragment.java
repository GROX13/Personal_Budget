package org.giorgi.personalbudget.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import org.giorgi.personalbudget.activity.CategoryActivity;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private static Intent intent;

    public static void setIntent(Intent intent) {
        DatePickerFragment.intent = intent;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        if (view.isShown()) {
            String monthString = "";
            if (month < 9)
                monthString = "0" + (month + 1);
            else
                monthString = "" + (month + 1);
            if (CategoryActivity.start == null) {
                CategoryActivity.start = "" + day + "/" + monthString + "/" + year;
            } else if (CategoryActivity.end == null) {
                CategoryActivity.end = "" + day + "/" + monthString + "/" + year;
                this.startActivity(intent);
            }
        }
    }
}