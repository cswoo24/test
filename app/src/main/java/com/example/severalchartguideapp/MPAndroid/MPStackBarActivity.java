package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/StackedBarActivity.java
public class MPStackBarActivity extends MPAndroidChartActivity{
    BarChart mpStackBarChart;
    int[] colorArray = new int[]{Color.RED,Color.BLUE,Color.GREEN};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpstackbar);

        mpStackBarChart = (BarChart) findViewById(R.id.stack_bar_chart);

        BarDataSet StackbarDataSet = new BarDataSet(dataValues1(), "dataset1");
        StackbarDataSet.setColors(colorArray); // 위에서 설정한 색으로 data 색 입히기

        BarData stackbarData = new BarData(StackbarDataSet);

        stackbarData.setValueTextColor(Color.BLACK); //라인 데이터의 텍스트 컬러 설정
        stackbarData.setValueTextSize(15f);
        stackbarData.setBarWidth(0.5f);

        StackbarDataSet.setStackLabels(new String[]{"1","2","3","4"});

        mpStackBarChart.setData(stackbarData);
        mpStackBarChart.invalidate();

        XAxis xAxis = mpStackBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines

        YAxis yLAxis = mpStackBarChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        YAxis yRAxis = mpStackBarChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        Legend legend = mpStackBarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); //범례 위치 설정(상단,중간,하단)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // 범례 위치 설정(왼쪽,가운데,오른쪽)
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); //범례 설정(범례 정렬 - 가로/세로)
        mpStackBarChart.setDescription(description);
        legend.setDrawInside(false); // 범례 위치 설정(차트 안에 넣을지 아닌지)
        legend.setXEntrySpace(3f); // 범례 간 x 간격
        legend.setYEntrySpace(5f); // 범례 간 y 간격
        legend.setTextColor(Color.BLACK);
        mpStackBarChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과

    }

    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> datavals = new ArrayList<BarEntry>();

        datavals.add(new BarEntry(1, new float[]{2,4.5f,3}));
        datavals.add(new BarEntry(2, new float[]{3,2,8}));
        datavals.add(new BarEntry(3, new float[]{4,1.5f,5}));
        datavals.add(new BarEntry(4, new float[]{1.5f,6,7}));

        return datavals;
    }
}
