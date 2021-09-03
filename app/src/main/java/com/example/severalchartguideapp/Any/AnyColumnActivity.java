package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;


import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/ColumnChartActivity.java
public class AnyColumnActivity extends AnyChartActivity{

    AnyChartView anyColumnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anycolumn);

        anyColumnChart = findViewById(R.id.any_column_chart);

        Cartesian cartesian = AnyChart.column();

        Column column = cartesian.column(dataValues1());

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_TOP/*Position.CENTER*/)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }")
        ;

        cartesian.animation(true); // animation setting
        cartesian.title("Top 10 Cosmetic Products by Revenue"); // chart 제목

        cartesian.yScale().minimum(0d); // Y축 데이터의 최소값

        cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }"); // Y축 라벨의 포맷

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X); //?

        cartesian.xAxis(0).title("Product"); // X축 이름
        cartesian.yAxis(0).title("Revenue"); // Y축 이름

        column.color("#cc6600"); // 그래프 색 설정
        column.labels(true); // 라벨 데이터 표시
        column.labels().fontColor("#cc2266");


        anyColumnChart.setChart(cartesian);


    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<DataEntry> datavals = new ArrayList<>();

        datavals.add(new ValueDataEntry("Rouge", 80540));
        datavals.add(new ValueDataEntry("Foundation", 94190));
        datavals.add(new ValueDataEntry("Mascara", 102610));
        datavals.add(new ValueDataEntry("Lip gloss", 110430));
        datavals.add(new ValueDataEntry("Lipstick", 128000));
        datavals.add(new ValueDataEntry("Nail polish", 143760));
        datavals.add(new ValueDataEntry("Eyebrow pencil", 170670));
        datavals.add(new ValueDataEntry("Eyebrow pencil", 213210));
        datavals.add(new ValueDataEntry("Eyeliner", 249980));
        datavals.add(new ValueDataEntry("Eyeshadows", 27420));

        return datavals;
    }
}
