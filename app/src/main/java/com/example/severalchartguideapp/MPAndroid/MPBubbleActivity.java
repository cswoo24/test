package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;


import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BubbleChartActivity.java
public class MPBubbleActivity extends MPAndroidChartActivity{

    BubbleChart mpBubbleChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpbubble);

        mpBubbleChart = (BubbleChart) findViewById(R.id.bubble_chart);

        BubbleDataSet dataSet1 = new BubbleDataSet(dataValues1(), "data1");
        BubbleDataSet dataSet2 = new BubbleDataSet(dataValues2(), "data2");

        BubbleData bubbleData = new BubbleData();
        bubbleData.addDataSet(dataSet1);
        bubbleData.addDataSet(dataSet2);

        bubbleData.setDrawValues(true); // 데이터 값 표시 여부
        bubbleData.setValueTextColor(Color.BLACK);
        bubbleData.setValueTextSize(15f);

        dataSet1.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        dataSet1.setIconsOffset(new MPPointF(150, 30));

        dataSet2.setColor(ColorTemplate.COLORFUL_COLORS[2]);
        dataSet2.setIconsOffset(new MPPointF(0, 15));

        XAxis xAxis = mpBubbleChart.getXAxis();
        xAxis.setTextSize(12f);
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(true);
        xAxis.setSpaceMax(2f); // 자동 계산된 X축 길이에 추가 MAX길이
        xAxis.setSpaceMin(2f); // 자동 계산된 X축 길이에 추가 MIN길이
        //xAxis.setLabelCount(10, false);// X축 label 개수 설정

        YAxis yLAxis = mpBubbleChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부
        yLAxis.setSpaceTop(30f);
        yLAxis.setSpaceBottom(30f);

        YAxis yRAxis = mpBubbleChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부


        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        Legend legend = mpBubbleChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); //범례 위치 설정(상단,중간,하단)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER); // 범례 위치 설정(왼쪽,가운데,오른쪽)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL); //범례 설정(범례 정렬 - 가로/세로)
        legend.setTextSize(15f);
        legend.setDrawInside(false); // 범례 위치 설정(차트 안에 넣을지 아닌지)
        legend.setXEntrySpace(30f); // 범례 간 x 간격
        legend.setYEntrySpace(30f); // 범례 간 y 간격
        legend.setTextColor(Color.BLACK);

        mpBubbleChart.setDoubleTapToZoomEnabled(true);
        mpBubbleChart.setDrawGridBackground(true); // 그리드 배경 여부(gray or white)
        mpBubbleChart.setDescription(description);
        mpBubbleChart.animateY(2000);

        mpBubbleChart.setData(bubbleData);
        mpBubbleChart.invalidate();
    }

    private ArrayList<BubbleEntry> dataValues1() {
        ArrayList<BubbleEntry> datavals = new ArrayList<>();

        datavals.add(new BubbleEntry(2, 0,0.21f));
        datavals.add(new BubbleEntry(4.5f, 1, 0.4f));
        datavals.add(new BubbleEntry(6.4f, 1, 0.32f));
        datavals.add(new BubbleEntry(8, 3.2f, 0.62f));
        datavals.add(new BubbleEntry(4.1f, 4, 0.35f));
        datavals.add(new BubbleEntry(3.5f, 3, 0.72f));

        return datavals;
    }

    private ArrayList<BubbleEntry> dataValues2() {
        ArrayList<BubbleEntry> datavals = new ArrayList<>();

        datavals.add(new BubbleEntry(5.4f, 1,0.15f));
        datavals.add(new BubbleEntry(2.4f, 4, 0.62f));
        datavals.add(new BubbleEntry(3.6f, 2.4f, 0.34f));
        datavals.add(new BubbleEntry(4, 2, 0.26f));
        datavals.add(new BubbleEntry(2.4f, 3.4f, 0.47f));
        datavals.add(new BubbleEntry(3, 2.3f, 0.55f));

        return datavals;
    }
}
