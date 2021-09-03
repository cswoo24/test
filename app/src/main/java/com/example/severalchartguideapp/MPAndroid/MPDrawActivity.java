package com.example.severalchartguideapp.MPAndroid;

import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class MPDrawActivity extends MPAndroidChartActivity {

    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpdraw);

        chart = findViewById(R.id.draw_chart);

        chart.setDrawGridBackground(true);


        // add dummy-data to the chart
        initWithDummyData();

        XAxis xl = chart.getXAxis();

        xl.setAvoidFirstLastClipping(true);

        YAxis yl = chart.getAxisLeft();


        chart.getLegend().setEnabled(false);

         //chart.setYRange(-40f, 40f, true);
         //call this to reset the changed y-range
         //chart.resetYRange(true);
        chart.invalidate();
    }

    private void initWithDummyData() {

        ArrayList<Entry> values = new ArrayList<>();

        // create a dataset and give it a type (0)
        LineDataSet set1 = new LineDataSet(values, "DataSet");
        set1.setLineWidth(3f);
        set1.setCircleRadius(5f);

        // create a data object with the data sets
        LineData data = new LineData(set1);

        chart.setData(data);
        //chart.invalidate();
    }
}
