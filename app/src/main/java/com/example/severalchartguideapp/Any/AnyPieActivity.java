package com.example.severalchartguideapp.Any;

import android.os.Bundle;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/PieChartActivity.java
public class AnyPieActivity extends AnyChartActivity{

    AnyChartView anyPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anypie);

        anyPieChart = findViewById(R.id.any_pie_chart);

        Pie pie = AnyChart.pie();
/*
        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(AnyPieActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        }); // 파이 일부분 클릭했을 때 Toast 메시지 창 짧게 뜨면서 실제 데이터 값 보여줌*/

        pie.data(dataValues1());
        //pie.innerRadius("15%");
        pie.animation(true);

        pie.title("Fruits imported in 2015 (in kg)");

        pie.labels().position("outside"); // 라벨 위치 설정. (https://api.anychart.com/anychart.core.ui.LabelsFactory#position에 모든 chart 라벨 설정 볼 수 있음)

        pie.legend().title().enabled(true); // 범례 이름 설정
        pie.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d); // 범례 이름 위치 설정

        pie.legend()
                .position("center-bottom") // 범례 위치
                .itemsLayout(LegendLayout.HORIZONTAL) // 범례 레이아웃 설정
                .align(Align.CENTER); // 범례 위치 설정


        anyPieChart.setChart(pie);

    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        List<DataEntry> datavals = new ArrayList<>();

        datavals.add(new ValueDataEntry("Apples", 6371664));
        datavals.add(new ValueDataEntry("Pears", 789622));
        datavals.add(new ValueDataEntry("Bananas", 7216301));
        datavals.add(new ValueDataEntry("Grapes", 1486621));
        datavals.add(new ValueDataEntry("Oranges", 1200000));

        return datavals;
    }
}
