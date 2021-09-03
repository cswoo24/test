package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//기존 라이브러리에는 없는 차트
//라이브러리와 유튜브 참고하여 만듬
// https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BarChartActivityMultiDataset.java
// https://www.youtube.com/watch?v=Bd76zMHdrDE&t=1254s
public class MPGroupBarActivity extends MPAndroidChartActivity {

    BarChart mpGouupBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpgroupbar);

        mpGouupBarChart = (BarChart) findViewById(R.id.group_bar_chart);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(), "dataset1");
        barDataSet1.setColor(Color.RED);
        BarDataSet barDataSet2 = new BarDataSet(dataValues2(), "dataset2");
        barDataSet2.setColor(Color.BLUE);

        BarData groupbardata = new BarData();
        groupbardata.addDataSet(barDataSet1);
        groupbardata.addDataSet(barDataSet2);

        mpGouupBarChart.setData(groupbardata);


        String[] days = new String[]{"Sun","Mon","Tue","Wen","Thu","Fri","Sat"};

        XAxis xAxis = mpGouupBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        YAxis yLAxis = mpGouupBarChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        YAxis yRAxis = mpGouupBarChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(false); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(false); // Y축 그리드 선 표시 여부

        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        mpGouupBarChart.setDoubleTapToZoomEnabled(false);
        //mpBarChart.setBackgroundColor(Color.YELLOW); // 배경색 설정
        mpGouupBarChart.setDrawGridBackground(false); // 그리드 배경 여부(gray or white)
        mpGouupBarChart.setDescription(description);
        mpGouupBarChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과

        mpGouupBarChart.setDragEnabled(true);
        mpGouupBarChart.setVisibleXRangeMaximum(3);

        float barspace=0.1f;
        float groupspace=0.5f;
        groupbardata.setBarWidth(0.15f);

        mpGouupBarChart.getXAxis().setAxisMaximum(0);
        mpGouupBarChart.getXAxis().setAxisMaximum(0+mpGouupBarChart.getBarData().getGroupWidth(groupspace, barspace)*7);
        mpGouupBarChart.getXAxis().setAxisMinimum(0);
        mpGouupBarChart.groupBars(0,groupspace,barspace);

        mpGouupBarChart.invalidate();


    }

    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(1, 2000));
        datavals.add(new BarEntry(2, 795));
        datavals.add(new BarEntry(3, 630));
        datavals.add(new BarEntry(4, 782));
        datavals.add(new BarEntry(5, 2614));
        datavals.add(new BarEntry(6, 500));
        datavals.add(new BarEntry(7, 2173));

        return datavals;
    }

    private ArrayList<BarEntry> dataValues2() {
        ArrayList<BarEntry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(1, 900));
        datavals.add(new BarEntry(2, 691));
        datavals.add(new BarEntry(3, 1030));
        datavals.add(new BarEntry(4, 382));
        datavals.add(new BarEntry(5, 2714f));
        datavals.add(new BarEntry(6, 3000));
        datavals.add(new BarEntry(7, 1173f));

        return datavals;
    }
}
