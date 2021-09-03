package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/HorizontalBarChartActivity.java
public class MPHorizontalBarActivity extends MPAndroidChartActivity{

    HorizontalBarChart  mpHorizontalBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mphorezontalbar);


        mpHorizontalBarChart = (HorizontalBarChart) findViewById(R.id.HorizontalBarChart);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(), "dataset1");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);

        mpHorizontalBarChart.setData(barData);
        mpHorizontalBarChart.invalidate();

        XAxis xAxis = mpHorizontalBarChart.getXAxis();
        xAxis.setTextSize(13f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setDrawGridLines(false);
        String[] xAxisLables = new String[]{"1","2", "3", "4" ,"5"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLables));

        barData.setValueTextColor(Color.BLUE); //라인 데이터의 텍스트 컬러 설정
        barData.setValueTextSize(15f);
        barData.setBarWidth(0.5f);
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        //mpHorizontalBarChart.setBackgroundColor(Color.TRANSPARENT); //set whatever color you prefer
        mpHorizontalBarChart.setDrawGridBackground(true);

        YAxis yLAxis = mpHorizontalBarChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        YAxis yRAxis = mpHorizontalBarChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        Description description = new Description();
        description.setText("Test");
        description.setTextSize(15);
        description.setTextColor(Color.GREEN);
        description.setEnabled(true);

        mpHorizontalBarChart.setDoubleTapToZoomEnabled(false);
        //mpHorizontalBarChart.setBackgroundColor(Color.YELLOW); // 배경색 설정
        mpHorizontalBarChart.setBorderColor(Color.MAGENTA);
        mpHorizontalBarChart.setBorderWidth(3);
        mpHorizontalBarChart.setDrawGridBackground(false); // 그리드 배경 여부(gray or white)
        mpHorizontalBarChart.setDescription(description);
        mpHorizontalBarChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과
        mpHorizontalBarChart.invalidate();//차트 초기화

        Legend legend = mpHorizontalBarChart.getLegend();
        legend.setTextColor(Color.RED); // 범례 색 설정
        legend.setTextSize(15f); // 범례 글자크기 설정
        legend.setEnabled(true); // 범례 표시 여부


    }

    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(0, 50));
        datavals.add(new BarEntry(1, 75));
        datavals.add(new BarEntry(2, 0));
        datavals.add(new BarEntry(3, 25));
        datavals.add(new BarEntry(4, 60));

        return datavals;
    }
}
