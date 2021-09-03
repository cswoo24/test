package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Funnel;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/FunnelChartActivity.java
public class AnyFunnelActivity extends AnyChartActivity{

    AnyChartView anyFunnelChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyfunnel);

        anyFunnelChart = findViewById(R.id.any_funnel_chart);

        Funnel funnel = AnyChart.funnel();

        funnel.data(data());

        funnel.margin(new String[] { "10", "20%", "10", "20%" }); // 순서대로 top, right, bottom, left
        funnel.baseWidth("70%") // 차트 윗줄 너비 default=90%
                .neckWidth("17%"); // 차트 좁아지는 곳 너비 default=30%

        funnel.labels() // 라벨 설정
                .position("outsideleft") // 위치 설정
                .format("{%X} - {%Value}"); // 라벨 포맷

        funnel.animation(true); // 애니메이션

        anyFunnelChart.setChart(funnel);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry("Website Visits", 528756));
        data.add(new ValueDataEntry("Downloads", 164052));
        data.add(new ValueDataEntry("Valid Contacts", 112167));
        data.add(new ValueDataEntry("Interested to Buy", 79128));
        data.add(new ValueDataEntry("Purchased", 79128));

        return data;
    }
}
