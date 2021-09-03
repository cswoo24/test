package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
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

// 기존 라이브러리 참고하여 새로 만듬
//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BarChartActivitySinus.java
//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/LineChartActivity2.java
public class MPBarSineCosineActivity extends MPAndroidChartActivity implements OnSeekBarChangeListener {

    private BarChart chart;
    private List<BarEntry> sindata;
    private List<BarEntry> cosdata;
    private SeekBar seekBarX;
    private TextView tvX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpbarsinecosine);

        chart = (BarChart)findViewById(R.id.bar_sin_cos_chart);

        sindata = FileUtils.loadBarEntriesFromAssets(getAssets(), "sine.txt");
        cosdata = FileUtils.loadBarEntriesFromAssets(getAssets(), "cosine.txt");
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
        leftAxis.setAxisMinimum(-2.5f);
        leftAxis.setAxisMaximum(2.5f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(0.1f);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(6, false);
        rightAxis.setAxisMinimum(-2.5f);
        rightAxis.setAxisMaximum(2.5f);
        rightAxis.setGranularity(0.1f);

        seekBarX.setOnSeekBarChangeListener(this);
        seekBarX.setProgress(150); // 초기 시작값

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false); // 범례를 차트 안 쪽에 사용할건지
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        chart.animateXY(1500, 1500);
    }

    private void setData(int count) {

        ArrayList<BarEntry> entries1 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            entries1.add(sindata.get(i));
        }

        ArrayList<BarEntry> entries2 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            entries2.add(cosdata.get(i));
        }

        BarDataSet set1, set2;


        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) { // chart에 Data가 없으면
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0); // index0 = set1
            set2 = (BarDataSet) chart.getData().getDataSetByIndex(1); // index1 = set2
            set1.setValues(entries1); // sine data insert
            set2.setValues(entries2); // cosine data insert
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(entries1, "Sine Function");
            set2 = new BarDataSet(entries2, "Cosine Function");
            set1.setColor(Color.rgb(240, 120, 124));
            set2.setColor(Color.YELLOW);
        }

        BarData data = new BarData(set1,set2);
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
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}
