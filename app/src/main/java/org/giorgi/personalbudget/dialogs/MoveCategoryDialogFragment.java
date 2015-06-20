package org.giorgi.personalbudget.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Category;

import java.util.List;

public class MoveCategoryDialogFragment extends DialogFragment {

    private int selected;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        List<Category> c = PersonalBudget.getCategoryList();
        String[] categoryNames = new String[c.size()];
        for (int i = 0; i < c.size(); i++)
            categoryNames[i] = c.get(i).getCategoryName();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Move to new category")
                .setItems(categoryNames, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        PersonalBudget.move(selected, which);
                    }
                });
        return builder.create();
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
