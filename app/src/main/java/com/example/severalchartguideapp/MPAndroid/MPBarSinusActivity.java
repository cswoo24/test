package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BarChartActivitySinus.java
public class MPBarSinusActivity extends MPAndroidChartActivity implements OnSeekBarChangeListener{

     // data empty //
    private BarChart chart;

    private List<BarEntry> data;
    private SeekBar seekBarX;
    private TextView tvX;

    protected Typeface tfLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpbarsinus);

        chart = findViewById(R.id.bar_sinus_chart);

        data = FileUtils.loadBarEntriesFromAssets(getAssets(), "othersine.txt");

        tvX = findViewById(R.id.tvValueCount);

        seekBarX = findViewById(R.id.seekbarValues);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.getDescription().setEnabled(false);
        chart.setDragEnabled(true);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(120);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(true);

        // draw shadows for each bar that show the maximum value
        // chart.setDrawBarShadow(true);

        // chart.setDrawXLabels(false);

        chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        setData(10);

        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(true);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        leftAxis.setTypeface(tfLight);
        leftAxis.setAxisMinimum(-2.5f);
        leftAxis.setAxisMaximum(2.5f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(0.1f);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTypeface(tfLight);
        rightAxis.setLabelCount(6, false);
        rightAxis.setAxisMinimum(-2.5f);
        rightAxis.setAxisMaximum(2.5f);
        rightAxis.setGranularity(0.1f);

        seekBarX.setOnSeekBarChangeListener(this);
        seekBarX.setProgress(150);  // 초기 시작값

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        chart.animateXY(1500, 1500);
    }

    private void setData(int count) {

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            entries.add(data.get(i));
        }

        BarDataSet set;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) { // chart에 Data가 없으면
            set = (BarDataSet) chart.getData().getDataSetByIndex(0); // index0 = set1
            set.setValues(entries); // sine data insert
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set = new BarDataSet(entries, "Sine Function");
            set.setColor(Color.rgb(240, 120, 124));
        }

        BarData data = new BarData(set);
        data.setValueTextSize(10f);
        data.setDrawValues(false);
        data.setBarWidth(0.8f);

        chart.setData(data);
        chart.invalidate();
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText(String.valueOf(seekBarX.getProgress()));

        setData(seekBarX.getProgress());
        chart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
