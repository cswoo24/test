package com.example.severalchartguideapp.MPAndroid;

import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/InvertedLineChartActivity.java
public class MPInvertedLineActivity extends MPAndroidChartActivity {

    private LineChart mpinvertedlinechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpinvertedline);

        mpinvertedlinechart = findViewById(R.id.inverted_line_chart);
        mpinvertedlinechart.setDrawGridBackground(false);

        // no description text
        mpinvertedlinechart.getDescription().setEnabled(false);

        // enable touch gestures
        mpinvertedlinechart.setTouchEnabled(true);

        // enable scaling and dragging
        mpinvertedlinechart.setDragEnabled(true); // 손가락으로 차트 이동
        mpinvertedlinechart.setScaleEnabled(true); // 제스처로 확대 축소 활성화

        // if disabled, scaling can be done on x- and y-axis separately
        mpinvertedlinechart.setPinchZoom(true);

        // set an alternative background color
        // mpinvertedlinechart.setBackgroundColor(Color.GRAY);


        XAxis xl = mpinvertedlinechart.getXAxis();
        xl.setAvoidFirstLastClipping(true); // 차트의 첫 번째 및 마지막 레이블 항목이 차트 또는 화면의 가장자리에서 그리드 막히지 않음
        xl.setAxisMinimum(0f);

        YAxis leftAxis = mpinvertedlinechart.getAxisLeft();
        leftAxis.setInverted(true); // Y축 거꾸로(위 : 0, 아래쪽 : maximum)
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mpinvertedlinechart.getAxisRight();
        rightAxis.setEnabled(false); // 오른쪽 Y축 표시 여부



        // // restrain the maximum scale-out factor
        // mpinvertedlinechart.setScaleMinima(3f, 3f);
        //
        // // center the view to a specific position inside the chart
        // mpinvertedlinechart.centerViewPort(10, 50);

        // get the legend (only possible after setting data)
        Legend l = mpinvertedlinechart.getLegend(); // 범례

        // modify the legend ...
        l.setForm(Legend.LegendForm.CIRCLE); // 범례 모양

        setData(5,15); // dataset

        // don't forget to refresh the drawing
        mpinvertedlinechart.invalidate();
    }

    private void setData(int count, float range) {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float xVal = (float) (Math.random() * range);
            float yVal = (float) (Math.random() * range);
            entries.add(new Entry(xVal, yVal));
        }

        // sort by x-value
        Collections.sort(entries, new EntryXComparator());

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(entries, "DataSet 1");

        set1.setLineWidth(3f);
        set1.setCircleRadius(5f);

        // create a data object with the data sets
        LineData data = new LineData(set1);

        data.setValueTextSize(15f); // value값 글자 크기

        // set data
        mpinvertedlinechart.setData(data);
    }
}
