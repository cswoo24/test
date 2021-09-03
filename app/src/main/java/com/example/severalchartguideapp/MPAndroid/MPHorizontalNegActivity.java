package com.example.severalchartguideapp.MPAndroid;

import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/HorizontalBarNegativeChartActivity.java
public class MPHorizontalNegActivity extends MPAndroidChartActivity {

    private HorizontalBarChart mphorizontalnegchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mphorizontalneg);
        mphorizontalnegchart = findViewById(R.id.HorizontalNegChart);

        // dataset : random

        mphorizontalnegchart.setDrawBarShadow(false); // bar 그림자 표시(전체 범위)
        mphorizontalnegchart.setDrawValueAboveBar(true); // value값 bar 위에 표시(왼쪽은 bar 안에)
        mphorizontalnegchart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mphorizontalnegchart.setMaxVisibleValueCount(60); // 최대 data수(현재 6개)

        // scaling can now only be done on x- and y-axis separately
        mphorizontalnegchart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
        // mphorizontalnegchart.setDrawBarShadow(true);

        mphorizontalnegchart.setDrawGridBackground(false); // 그리드 배경색 여부


        setData(6, 30); // dataset

            XAxis xl = mphorizontalnegchart.getXAxis(); // X축
            xl.setPosition(XAxis.XAxisPosition.BOTTOM);
            xl.setDrawAxisLine(true); // X축 line 표시
            xl.setDrawGridLines(true); // X축 그리드 line 표시
            xl.setGranularity(10f); // X축 정밀도(간격)

            YAxis yl = mphorizontalnegchart.getAxisLeft();
            yl.setDrawAxisLine(true);
            yl.setDrawGridLines(true);
//        yl.setInverted(true);

            YAxis yr = mphorizontalnegchart.getAxisRight();
            yr.setDrawAxisLine(true);
            yr.setDrawGridLines(false);
//        yr.setInverted(true);

            mphorizontalnegchart.setFitBars(true); // 막대 차트의 막대가 완전히 표시되도록 x축 범위의 각 측면에 막대 너비의 절반을 추가
            mphorizontalnegchart.animateY(2500, Easing.EaseInOutQuad); // 시간, 동작

            Legend l = mphorizontalnegchart.getLegend();
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            l.setDrawInside(false);
            l.setFormSize(8f);
            l.setXEntrySpace(4f);

            mphorizontalnegchart.invalidate();
        }

    private void setData(int count, float range) {

        float barWidth = 9f; // 바 너비
        float spaceForBar = 10f; // 바 간격
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range - range / 2);
            values.add(new BarEntry(i * spaceForBar, val));
        }

        BarDataSet set1;

        if (mphorizontalnegchart.getData() != null &&
                mphorizontalnegchart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mphorizontalnegchart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mphorizontalnegchart.getData().notifyDataChanged();
            mphorizontalnegchart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(values, "DataSet 1");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f); // value 글자크기
            data.setBarWidth(barWidth);
            mphorizontalnegchart.setData(data);
        }
    }
}

