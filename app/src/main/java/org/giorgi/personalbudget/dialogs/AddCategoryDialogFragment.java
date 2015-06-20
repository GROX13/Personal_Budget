package org.giorgi.personalbudget.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Category;

public class AddCategoryDialogFragment extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_add_category, null))
                // Add action buttons
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText name = (EditText)
                                ((AlertDialog) dialog).findViewById(R.id.category_name);
                        EditText rules = (EditText)
                                ((AlertDialog) dialog).findViewById(R.id.category_rules);
                        Category c = new Category(name.getText().toString());
                        c.setRule(rules.getText().toString());
                        PersonalBudget.addCategory(c);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddCategoryDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }


}
