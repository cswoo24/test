package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pyramid;
import com.anychart.core.ui.Legend;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/PyramidActivity.java
public class AnyPyramidActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anypyramid);

        AnyChartView anyChartView = findViewById(R.id.any_pyramid);

        Pyramid pyramid = AnyChart.pyramid();

        List<DataEntry> data = new ArrayList<>(); // data 순서 상관 없음. value 큰 data부터 쌓임
        data.add(new ValueDataEntry("TV promotion", 6371664));
        data.add(new ValueDataEntry("Radio promotion", 7216301));
        data.add(new ValueDataEntry("Advertising leaflets", 1486621));
        data.add(new ValueDataEntry("Before advertising started", 1586622));

        pyramid.data(data);

        Legend legend = pyramid.legend();
        legend.enabled(true);
        legend.position("outside-right");
        legend.itemsLayout(LegendLayout.VERTICAL);
        legend.align(Align.TOP);
        legend.padding(0d, 0d, 25d, 0d);// top right bottom left


        anyChartView.setChart(pyramid);
    }
}
