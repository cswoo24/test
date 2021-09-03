package com.example.severalchartguideapp.Hello;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/PieChartActivity.java
public class HelPieActivity extends HelloChartActivity {

    private PieChartView chart;
    private PieChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpie);

        chart = (PieChartView)findViewById(R.id.hel_pie_chart);

        generateData();

    }
    private void generateData() {
        int numValues = 6; // data 개수

        List<SliceValue> values = new ArrayList<SliceValue>(); // data 생성
        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15, ChartUtils.pickColor());
            values.add(sliceValue);
        }

        data = new PieChartData(values);
        data.setHasLabels(true); // label 표시 여부
        data.setHasLabelsOnlyForSelected(false); // 선택될 때만 value 표시 여부
        data.setValueLabelTextSize(20); // value 글자 크기
        data.setHasLabelsOutside(false); // value 밖에 표시할 건지
        data.setHasCenterCircle(true); // 중앙 원 생성할 건지
        data.setCenterCircleScale(0.5f); // 중앙 원 크기
        data.setCenterText1("Random Number"); // 원에 들어갈 글자
        data.setCenterText1FontSize(20); // 원에 들어간 글자 크기
        data.setCenterText1Color(Color.parseColor("#0097A7")); // 원에 들어간 글자 색

        chart.setPieChartData(data);
        chart.setChartRotationEnabled(true); // 차트 회전 여부
        chart.setScaleX(0.8f); // X크기
        chart.setScaleY(0.8f); // Y크기
    }
}



/*
public class HelPieActivity extends HelloChartActivity {

    private PieChartView mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpie);

        mChart = findViewById(R.id.hel_pie_chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(15, Color.BLUE).setLabel("ANDROID"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("IOS"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("WEB"));
        pieData.add(new SliceValue(60, Color.MAGENTA).setLabel("GRAPHIC"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true);
        pieChartData.setValueLabelTextSize(15);
        pieChartData.setValueLabelBackgroundColor(Color.YELLOW);
        //pieChartData.setValueLabelsTextColor(Color.BLACK);
        pieChartData.setHasCenterCircle(true);
        pieChartData.setCenterCircleScale(0.5f);
        mChart.set
        pieChartData.setCenterText1("COXTUNES SKILLS");
        pieChartData.setCenterText1FontSize(20);
        pieChartData.setCenterText1Color(Color.parseColor("#0097A7"));
        mChart.setPieChartData(pieChartData);
        pieChartData.setSlicesSpacing(5);
        pieChartData.setHasLabelsOnlyForSelected(false);
        mChart.setChartRotationEnabled(false);
        pieChartData.setValues(pieData);
    }
}*/