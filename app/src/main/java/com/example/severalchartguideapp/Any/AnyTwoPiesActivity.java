package com.example.severalchartguideapp.Any;

import android.os.Bundle;
import android.widget.Toast;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Column;
import com.anychart.core.ui.Tooltip;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/TwoPiesOneColumnActivity.java
public class AnyTwoPiesActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anytwopies);

        final AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        APIlib.getInstance().setActiveAnyChartView(anyChartView);

        final Pie pie = AnyChart.pie();

        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) { // 파이 클릭했을 때 메세지 창 띄움(value값)
            @Override
            public void onClick(Event event) {
                Toast.makeText(AnyTwoPiesActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });

        List<DataEntry> data = new ArrayList<>(); // pie 왼쪽 data
        data.add(new ValueDataEntry("Apples", 6371664));
        data.add(new ValueDataEntry("Pears", 789622));
        data.add(new ValueDataEntry("Bananas", 7216301));
        data.add(new ValueDataEntry("Grapes", 1486621));
        data.add(new ValueDataEntry("Oranges", 1200000));

        pie.data(data);

        pie.title("Fruits imported in 2015 (in kg)");

        anyChartView.setChart(pie);

        final AnyChartView anyChartView1 = findViewById(R.id.any_chart_view1);
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);

        final Pie pie1 = AnyChart.pie(); // pie 오른쪽

        pie1.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {  // 파이 클릭했을 때 메세지 창 띄움(value값)
            @Override
            public void onClick(Event event) {
                Toast.makeText(AnyTwoPiesActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });

        List<DataEntry> data1 = new ArrayList<>();
        data1.add(new ValueDataEntry("Apples", 6371664));
        data1.add(new ValueDataEntry("Pears", 789622));
        data1.add(new ValueDataEntry("Bananas", 7216301));
        data1.add(new ValueDataEntry("Grapes", 1486621));
        data1.add(new ValueDataEntry("Oranges", 1200000));

        pie1.data(data1);

        pie1.title("Fruits imported in 2015 (in kg)");

        anyChartView1.setChart(pie1);

        AnyChartView anyChartView2 = findViewById(R.id.any_chart_view2); // 아래 column data
        APIlib.getInstance().setActiveAnyChartView(anyChartView2);

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data2 = new ArrayList<>();
        data2.add(new ValueDataEntry("Rouge", 80540));
        data2.add(new ValueDataEntry("Foundation", 94190));
        data2.add(new ValueDataEntry("Mascara", 102610));
        data2.add(new ValueDataEntry("Lip gloss", 110430));
        data2.add(new ValueDataEntry("Lipstick", 128000));
        data2.add(new ValueDataEntry("Nail polish", 143760));
        data2.add(new ValueDataEntry("Eyebrow pencil", 170670));
        data2.add(new ValueDataEntry("Eyeliner", 213210));
        data2.add(new ValueDataEntry("Eyeshadows", 249980));

        Column column = cartesian.column(data2);

        column.tooltip() // tooltip 설정
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d) // Y좌표
                .format("${%Value}{groupsSeparator: }"); // 구분자 포함(백단위)

        cartesian.title("Top 10 Cosmetic Products by Revenue"); // chart 제목

        cartesian.yScale().minimum(0d); // Y축 최소값

        cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Product"); // X축 이름
        cartesian.yAxis(0).title("Revenue"); // Y축 이름름
        anyChartView2.setChart(cartesian);

//        final int delayMillis = 500;
//        handler = new Handler();
//        runnable = new Runnable() {
//            public void run() {
//                APIlib.getInstance().setActiveAnyChartView(anyChartView);
//                List<DataEntry> data = new ArrayList<>();
//                data.add(new ValueDataEntry("Apples", new Random().nextDouble() * 140d));
//                data.add(new ValueDataEntry("Pears", new Random().nextDouble() * 140d));
//                pie.data(data);
//                handler.postDelayed(this, delayMillis);
//
//                APIlib.getInstance().setActiveAnyChartView(anyChartView1);
//                List<DataEntry> data1 = new ArrayList<>();
//                data1.add(new ValueDataEntry("Apples", new Random().nextDouble() * 140d));
//                data1.add(new ValueDataEntry("Pears", new Random().nextDouble() * 140d));
//                pie1.data(data1);
//                handler.postDelayed(this, delayMillis);
//            }
//        };
//        handler.postDelayed(runnable, delayMillis);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        handler.removeCallbacks(runnable);
    }
}
