package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.LinearGauge;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.Orientation;
import com.anychart.enums.Position;
import com.anychart.scales.Base;
import com.anychart.scales.Linear;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/ThermometerActivity.java
public class AnyThermometerActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anythermometer);

        AnyChartView anyChartView = findViewById(R.id.any_thermometer);

        LinearGauge linearGauge = AnyChart.linear();

        // TODO data
        linearGauge.data(new SingleValueDataSet(new Integer[] { 2 })); // 데이터 값.(2)  SingleValueDataSet에서 Array.asList 통해 같은 값을 가진 배열

        linearGauge.tooltip()
                .useHtml(true) // tooltip.  섭씨 & 화씨 표시 위해
                .format(
                        "function () {\n" +
                                "          return this.value + '&deg;' + 'C' +\n" +
                                "            ' (' + (this.value * 1.8 + 32).toFixed(1) +\n" +
                                "            '&deg;' + 'F' + ')'\n" +
                                "    }");

        linearGauge.label(0).useHtml(true); // 섭씨 표시 위해 html 속성 허용
        linearGauge.label(0)
                .text("C&deg;")
                .position(Position.LEFT_BOTTOM)
                .anchor(Anchor.LEFT_BOTTOM)
                .offsetY("20px") // C(온도기호) Y좌표
                .offsetX("38%") // C(온도기호) X좌표
                .fontColor("black")
                .fontSize(17);

        linearGauge.label(1)
                .useHtml(true)
                .text("F&deg;")
                .position(Position.RIGHT_BOTTOM)
                .anchor(Anchor.RIGHT_BOTTOM)
                .offsetY("20px")
                .offsetX("45%")
                .fontColor("black")
                .fontSize(17);

        Base scale = linearGauge.scale() // 섭씨 온도 범위
                .minimum(-30)
                .maximum(40);
//                .setTicks

        linearGauge.axis(0).scale(scale); // 섭씨
        linearGauge.axis(0)
                .offset("-1%")
                .width("0.5%");

        linearGauge.axis(0).labels()
                .format("{%Value}&deg;")
                .useHtml(true);

        linearGauge.thermometer(0) // data index 설정( 데이터가 여러 개 있으면 그 데이터에 맞게 온도계 reset
                .name("Thermometer")
                .id(1);

        linearGauge.axis(0).minorTicks(true); // 섭씨 축 보조선
        linearGauge.axis(0).labels() // 섭씨 라벨 설정
                .format(
                        "function () {\n" +
                                "    return '<span style=\"color:black;\">' + this.value + '&deg;</span>'\n" +
                                "  }")
                .useHtml(true);

        linearGauge.marker(0) // 섭씨 마커
                .labels(true)
                .offset("-2.5%") // 위치
                .color("RED") // 색
                .type("triangle-right"); // 모양

        linearGauge.axis(1).minorTicks(true); // 화씨 축 보조선
        linearGauge.axis(1).labels() // 화씨 라벨 설정
                .format(
                        "function () {\n" +
                                "    return '<span style=\"color:black;\">' + this.value + '&deg;</span>'\n" +
                                "  }")
                .useHtml(true);
        linearGauge.axis(1)
                .offset("3.5%")
                .orientation(Orientation.RIGHT);

        Linear linear = Linear.instantiate();
        linear.minimum(-20) // 화씨 범위
                .maximum(100);
//                .setTicks
        linearGauge.axis(1).scale(linear);

        anyChartView.setChart(linearGauge);
    }
}
