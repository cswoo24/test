package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.components.YAxis.AxisDependency;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/DynamicalAddingActivity.java
public class MPDynamicAddLineActivity extends MPAndroidChartActivity {

    private LineChart chart;
    private Button adddata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpdynamicadd);


        adddata = (Button) findViewById(R.id.adddata);
        adddata.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                addEntry();
            }
            });

        chart = (LineChart)findViewById(R.id.dynamic_add_line_chart);
        //chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.setNoDataText("No chart data available. Use the menu to add entries and data sets!");

        chart.invalidate();
    }

    private final int[] colors = ColorTemplate.VORDIPLOM_COLORS;

    private void addEntry() {

        LineData data = chart.getData();

        if (data == null) {
            data = new LineData();
            chart.setData(data);
        }

        ILineDataSet set = data.getDataSetByIndex(0);
        // set.addEntry(...); // can be called as well

        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }

        // choose a random dataSet
        int randomDataSetIndex = (int) (Math.random() * data.getDataSetCount());
        ILineDataSet randomSet = data.getDataSetByIndex(randomDataSetIndex);
        float value = (float) (Math.random() * 50) + 50f * (randomDataSetIndex + 1);

        data.addEntry(new Entry(randomSet.getEntryCount(), value), randomDataSetIndex);
        data.notifyDataChanged();

        // let the chart know it's data has changed
        chart.notifyDataSetChanged();

        chart.setVisibleXRangeMaximum(6);
        //chart.setVisibleYRangeMaximum(15, AxisDependency.LEFT);
//
//            // this automatically refreshes the chart (calls invalidate())
        chart.moveViewTo(data.getEntryCount() - 7, 50f, AxisDependency.LEFT);

    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "DataSet 1");
        set.setLineWidth(2.5f);
        set.setCircleRadius(4.5f);
        set.setColor(Color.rgb(240, 99, 99));
        set.setCircleColor(Color.rgb(240, 99, 99));
        set.setHighLightColor(Color.rgb(190, 190, 190));
        set.setAxisDependency(AxisDependency.LEFT);
        set.setValueTextSize(10f);

        return set;
    }
}
