package org.giorgi.personalbudget.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Category;

public class ChangeRuleDialogFragment extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final Category c = PersonalBudget.getSelectedCategory();
        View view = inflater.inflate(R.layout.dialog_change_rule, null);
        EditText editText = (EditText) view.findViewById(R.id.category_rules);
        editText.setText(c.getRuleString());
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText rules = (EditText)
                                ((AlertDialog) dialog).findViewById(R.id.category_rules);
                        c.setRule(rules.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ChangeRuleDialogFragment.this.getDialog().cancel();
                    }
                });

        builder.setTitle("Change rule");
        return builder.create();
    }


}
