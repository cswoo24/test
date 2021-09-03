package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;



import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/PieChartActivity.java
public class MPPieActivity extends MPAndroidChartActivity{

    PieChart mpPieChart;

    int[] colorArray = new int[]{Color.LTGRAY,Color.rgb(33,66,204),Color.rgb(99,00,99),Color.DKGRAY,Color.BLUE,
            Color.MAGENTA,Color.rgb(66,00,99),
            Color.rgb(66,66,00),Color.GRAY,Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mppie);

        mpPieChart = (PieChart)findViewById(R.id.pie_chart);

        PieDataSet pieDataSet = new PieDataSet(dataValues1(), ""); // Dataset 생성
        pieDataSet.setColors(colorArray); // 위에서 설정한 색으로 data 색 입히기

        PieData pieData = new PieData();
        pieData.addDataSet(pieDataSet);

        pieData.setValueTextColor(Color.rgb(204,255,255)); // 데이터 리벨의 텍스트 컬러 설정
        pieData.setValueTextSize(15f); // 라벨 글자 크기 설정
        pieData.setHighlightEnabled(true);


        mpPieChart.setData(pieData);
        mpPieChart.invalidate();


        mpPieChart.setDrawEntryLabels(true); // 라벨 표시 여부
        mpPieChart.setUsePercentValues(false); // 데이터 퍼센트 표시 여부(true일 경우 데이터 표시 X)
        mpPieChart.setCenterText("Temp Data"); // 원 안에 Text(String) 입력
        mpPieChart.setCenterTextSize(15); // 원 안 Text 크기
        mpPieChart.setCenterTextRadiusPercent(80);
        mpPieChart.setHoleRadius(25); // 가운데 공백 원 반지름 설정
        mpPieChart.setCenterTextColor(Color.RED); // 가운데 글자 색 설정
        mpPieChart.setTransparentCircleRadius(35);
        mpPieChart.setDrawHoleEnabled(true); // Center Circle 존재 여부 -> 원형(false) or 도넛형(true)
        mpPieChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과

        Legend legend = mpPieChart.getLegend(); // 범례례        legend.setTextColor(Color.BLACK); // 범례 색 설정
        legend.setTextSize(10f); // 범례 글자크기 설정
        legend.setEnabled(true); // 범례 표시 여부

    }

    private ArrayList<PieEntry> dataValues1() {
        ArrayList<PieEntry> datavals = new ArrayList<>();

        datavals.add(new PieEntry(945f, "Jan"));
        datavals.add(new PieEntry(1040f, "Feb"));
        datavals.add(new PieEntry(1133f, "Mar"));
        datavals.add(new PieEntry(1240f, "Apr"));
        datavals.add(new PieEntry(1369f, "May"));
        datavals.add(new PieEntry(1487f, "Jun"));
        datavals.add(new PieEntry(1501f, "Jul"));
        datavals.add(new PieEntry(1645f, "Aug"));
        datavals.add(new PieEntry(1578f, "Sep"));
        datavals.add(new PieEntry(1695f, "Oct"));

        return datavals;
    }
}
