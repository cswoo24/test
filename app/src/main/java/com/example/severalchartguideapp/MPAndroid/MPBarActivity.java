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
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BarChartActivityMultiDataset.java
public class MPBarActivity extends MPAndroidChartActivity {

    BarChart mpBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpbar);

        mpBarChart = (BarChart) findViewById(R.id.bar_chart);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(), "dataset1");
        BarDataSet barDataSet2 = new BarDataSet(dataValues2(), "dataset2");

        barDataSet1.setColor(Color.RED);
        barDataSet1.setBarBorderColor(Color.BLACK);
        barDataSet1.setBarBorderWidth(1);

        barDataSet2.setColor(Color.BLUE);
        barDataSet2.setBarBorderColor(Color.GREEN);
        barDataSet2.setBarBorderWidth(1);

        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
        barData.addDataSet(barDataSet2);

        mpBarChart.setData(barData);
        mpBarChart.invalidate();

        barData.setValueTextColor(Color.BLUE); //라인 데이터의 텍스트 컬러 설정
        barData.setValueTextSize(15f);

        XAxis xAxis = mpBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE); // X축 위치 설정
        xAxis.setTextColor(Color.BLACK); // X축 서식 색 설정
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines
        String[] xAxisLables = new String[]{"1월","2월", "3월", "4월" ,"5월","6월","7월","8월","9월","10월"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLables));

        YAxis yLAxis = mpBarChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        YAxis yRAxis = mpBarChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(false); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(false); // Y축 그리드 선 표시 여부

        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        mpBarChart.setDoubleTapToZoomEnabled(false);
        //mpBarChart.setBackgroundColor(Color.YELLOW); // 배경색 설정
        mpBarChart.setBorderColor(Color.MAGENTA);
        mpBarChart.setBorderWidth(3);
        mpBarChart.setDrawGridBackground(false); // 그리드 배경 여부(gray or white)
        mpBarChart.setDescription(description);
        mpBarChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과
        mpBarChart.invalidate();//차트 초기화


        Legend legend = mpBarChart.getLegend();
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

    private ArrayList<BarEntry> dataValues2() {
        ArrayList<BarEntry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(0.5f, 30));
        datavals.add(new BarEntry(1.7f, 65));
        datavals.add(new BarEntry(2, 25));
        datavals.add(new BarEntry(4.5f, 50));

        return datavals;
    }
}



