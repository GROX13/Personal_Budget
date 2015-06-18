package org.giorgi.personalbudget.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.giorgi.personalbudget.R;
import org.giorgi.personalbudget.application.PersonalBudget;
import org.giorgi.personalbudget.model.Category;
import org.giorgi.personalbudget.model.Transaction;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MonthlyChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_chart);

        LineChart mChart = (LineChart) findViewById(R.id.line_chart);
        mChart.setDrawGridBackground(false);
        mChart.setDescription("Chart displays income and expenses of different categories.");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");
        mChart.setHighlightEnabled(true);
        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setAxisMaxValue(200f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setStartAtZero(false);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);
        mChart.getAxisRight().setEnabled(false);

        List<Category> categories = PersonalBudget.getCategoryList();
        List<String> xValues = Arrays.asList(new DateFormatSymbols().getMonths());

        ArrayList<Entry> income = displayIncome(categories, xValues);
        ArrayList<Entry> expenses = displayExpenses(categories, xValues);

        // create a data set and give it a type
        LineDataSet set1 = new LineDataSet(income, "Income");
        LineDataSet set2 = new LineDataSet(expenses, "Expenses");

        // set the line to be drawn like this "- - - - - -"
        set1.enableDashedLine(10f, 5f, 0f);
        set1.setColor(Color.GREEN);
        set1.setCircleColor(Color.GREEN);
        set1.setLineWidth(1f);
        set1.setCircleSize(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setFillAlpha(65);
        set1.setFillColor(Color.GREEN);
        set1.setDrawFilled(true);

        set2.enableDashedLine(10f, 5f, 0f);
        set2.setColor(Color.RED);
        set2.setCircleColor(Color.RED);
        set2.setLineWidth(1f);
        set2.setCircleSize(3f);
        set2.setDrawCircleHole(false);
        set2.setValueTextSize(9f);
        set2.setFillAlpha(65);
        set2.setFillColor(Color.RED);
        set2.setDrawFilled(true);

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);

        LineData data = new LineData(xValues, dataSets);
        mChart.setData(data);
    }

    private ArrayList<Entry> displayExpenses(List<Category> categories, List<String> xValues) {
        ArrayList<Entry> yValues = new ArrayList<>();
        //Float[] expenses = new Float[12];

        SimpleDateFormat sdf = new SimpleDateFormat(Transaction.DATE_FORMAT, Locale.US);
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < categories.size(); i++) {
            List<Transaction> transactions = categories.get(i).getTransactions();
            for (int j = 0; j < transactions.size(); j++) {
                Transaction transaction = transactions.get(j);
                if (transaction.isExpense()) {
                    Date parse = null;
                    try {
                        parse = sdf.parse(transaction.getDateTime());
                        calendar.setTime(parse);
                        //expenses[calendar.get(Calendar.MONTH)] += transaction.getAmount();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return yValues;
    }

    private ArrayList<Entry> displayIncome(List<Category> categories, List<String> xValues) {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monthly_chart, menu);
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
