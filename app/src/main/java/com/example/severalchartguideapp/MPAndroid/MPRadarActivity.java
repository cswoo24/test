package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/RadarChartActivity.java
public class MPRadarActivity extends MPAndroidChartActivity{
    RadarChart mpRadarChart;
    String[] labels = {"사과","배","바나나","귤", "포도"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpradar);

        mpRadarChart = (RadarChart) findViewById(R.id.rader_chart);

        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(), "가게1");
        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(), "가게2");

        dataSet1.setColor(Color.RED); // 데이터 선 색 설정
        dataSet1.setFillColor(Color.MAGENTA); // 데이터 범위 안 색 설정
        dataSet1.setDrawFilled(true); // 데이터 범위 안 색 여부(false:색 없음)
        dataSet1.setFillAlpha(180); // 데이터 색칠 범위(선까지 얼마나 색칠 할건지)
        dataSet1.setLineWidth(2f); //데이터 선 굵기
        dataSet1.setDrawHighlightCircleEnabled(true); // ?
        dataSet1.setDrawHighlightIndicators(true); // ?

        dataSet2.setColor(Color.BLUE);
        dataSet2.setFillColor(Color.YELLOW);
        dataSet2.setDrawFilled(true);
        dataSet2.setFillAlpha(180);
        dataSet2.setLineWidth(2f);
        dataSet2.setDrawHighlightCircleEnabled(true);
        dataSet2.setDrawHighlightIndicators(false);

        RadarData radarData = new RadarData();
        radarData.addDataSet(dataSet1);
        radarData.addDataSet(dataSet2);

        XAxis xAxis = mpRadarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels)); // 레이더 라벨 설정

        mpRadarChart.setData(radarData);
        mpRadarChart.invalidate();

        radarData.setValueTextColor(Color.BLUE); //라인 데이터의 텍스트 컬러 설정
        radarData.setValueTextSize(10f);
        radarData.setDrawValues(true);


        XAxis xAxis1 =  mpRadarChart.getXAxis();
        xAxis1.setTextSize(13f); // 데이터 라벨 글자크기
        xAxis1.setTextColor(Color.BLACK); // 데이터 라벨 색
        //xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        //xAxis1.setDrawGridLines(false);

        YAxis yAxis = mpRadarChart.getYAxis();
        yAxis.setSpaceTop(20f);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(15f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(true); // 레이더 범위 단위 표시 여부(0,20,40 ...)

        mpRadarChart.setWebLineWidthInner(1f); // 레이더 둘레 굵기 설정
        mpRadarChart.setWebLineWidth(1f); // 레이더 중심에서 뻗어 나오는 선 굵기 설정
        mpRadarChart.animateXY(1400, 1400, Easing.EaseInOutQuad);




        Legend legend = mpRadarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); //범례 위치 설정(상단,중간,하단)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER); // 범례 위치 설정(왼쪽,가운데,오른쪽)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL); //범례 설정(범례 정렬 - 가로/세로)
        legend.setDrawInside(false); // 범례 위치 설정(차트 안에 넣을지 아닌지)
        legend.setXEntrySpace(7f);
        legend.setYEntrySpace(5f);
        legend.setTextColor(Color.BLACK);

    }

    private ArrayList<RadarEntry> dataValues1() {
        ArrayList<RadarEntry> datavals = new ArrayList<>();

        datavals.add(new RadarEntry(50));
        datavals.add(new RadarEntry(75));
        datavals.add(new RadarEntry(30));
        datavals.add(new RadarEntry(25));
        datavals.add(new RadarEntry(60));
        datavals.add(new RadarEntry(60));
        datavals.add(new RadarEntry(60));
        datavals.add(new RadarEntry(0));

        return datavals;
    }

    private ArrayList<RadarEntry> dataValues2() {
        ArrayList<RadarEntry> datavals = new ArrayList<>();

        datavals.add(new RadarEntry(35));
        datavals.add(new RadarEntry(45));
        datavals.add(new RadarEntry(50));
        datavals.add(new RadarEntry(70));
        datavals.add(new RadarEntry(80));
        datavals.add(new RadarEntry(60));
        datavals.add(new RadarEntry(10));

        return datavals;
    }
}
