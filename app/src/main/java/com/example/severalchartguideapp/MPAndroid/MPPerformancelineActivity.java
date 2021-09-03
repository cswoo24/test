package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/PerformanceLineChart.java
public class MPPerformancelineActivity extends MPAndroidChartActivity implements OnSeekBarChangeListener{

    private LineChart mpperformancelinechart;

    private SeekBar seekBarValues;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpperformanceline);

        tvCount = findViewById(R.id.tvValueCount);
        seekBarValues = findViewById(R.id.seekbarValues);
        seekBarValues.setOnSeekBarChangeListener(this);

        mpperformancelinechart = findViewById(R.id.performance_line_chart);

        mpperformancelinechart.setDrawGridBackground(false);

        // no description text
        mpperformancelinechart.getDescription().setEnabled(false);

        // enable touch gestures
        mpperformancelinechart.setTouchEnabled(true);

        // enable scaling and dragging
        mpperformancelinechart.setDragEnabled(true);
        mpperformancelinechart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mpperformancelinechart.setPinchZoom(false);

        mpperformancelinechart.getAxisLeft().setDrawGridLines(false);
        mpperformancelinechart.getAxisRight().setEnabled(false);
        mpperformancelinechart.getXAxis().setDrawGridLines(true);
        mpperformancelinechart.getXAxis().setDrawAxisLine(false);

        seekBarValues.setProgress(3000);


        // don't forget to refresh the drawing
        mpperformancelinechart.invalidate();
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * (range + 1)) + 3;
            values.add(new Entry(i * 0.001f, val));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "DataSet 1");

        set1.setColor(Color.BLACK);
        set1.setLineWidth(0.5f);
        set1.setDrawValues(false);
        set1.setDrawCircles(false);
        set1.setMode(LineDataSet.Mode.LINEAR);
        set1.setDrawFilled(false);
/*
        set1.setColor(Color.BLACK); // 라인색
        set1.setLineWidth(3f); // 라인 너비
        set1.setDrawValues(true); // value값 표시
        set1.setValueTextColor(Color.RED); // value 글자색
        set1.setValueTextSize(12f); // value 글자 크기
        set1.setDrawCircles(false); // 데이터 위치에 원 표시
        set1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER); // 라인 형태
        set1.setDrawFilled(true); // 채우기 여뷰
        set1.setFillColor(Color.BLUE); // 채우기색*/

        // create a data object with the data sets
        LineData data = new LineData(set1);

        // set data
        mpperformancelinechart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = mpperformancelinechart.getLegend(); // 범례
        l.setEnabled(false);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int count = seekBarValues.getProgress()+2;// + 100;
        tvCount.setText(String.valueOf(count));

        mpperformancelinechart.resetTracking();

        setData(count, 500f);

        // redraw
        mpperformancelinechart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
