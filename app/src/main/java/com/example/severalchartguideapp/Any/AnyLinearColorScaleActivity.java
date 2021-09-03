package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.LinearGauge;
import com.anychart.enums.Anchor;
import com.anychart.enums.Layout;
import com.anychart.enums.MarkerType;
import com.anychart.enums.Orientation;
import com.anychart.enums.Position;
import com.anychart.scales.OrdinalColor;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/LinearColorScaleActivity.java
public class AnyLinearColorScaleActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anylinearcolorscale);

        AnyChartView anyChartView = findViewById(R.id.any_linear_color_scale);

        LinearGauge linearGauge = AnyChart.linear();

        linearGauge.data(new SingleValueDataSet(new Double[] { 5.3D }));

        linearGauge.layout(Layout.HORIZONTAL); // layout 가로 세로 정의

        linearGauge.label(0)
                .position(Position.LEFT_CENTER) // 위치
                .anchor(Anchor.LEFT_CENTER)
                .offsetY("-50px") // Y 이동 정도
                .offsetX("50px") // X 이동 정도
                .fontColor("black")
                .fontSize(17);
        linearGauge.label(0).text("Total Rainfall"); // 라벨 0 정의

        linearGauge.label(1)
                .position(Position.LEFT_CENTER)
                .anchor(Anchor.LEFT_CENTER)
                .offsetY("40px")
                .offsetX("50px")
                .fontColor("#777777")
                .fontSize(17);
        linearGauge.label(1).text("Drought Hazard"); //라벨 1 정의

        linearGauge.label(2)
                .position(Position.RIGHT_CENTER)
                .anchor(Anchor.RIGHT_CENTER)
                .offsetY("40px")
                .offsetX("50px")
                .fontColor("#777777")
                .fontSize(17);
        linearGauge.label(2).text("Flood Hazard");

        OrdinalColor scaleBarColorScale = OrdinalColor.instantiate();
        scaleBarColorScale.ranges(new String[]{
                "{ from: 0, to: 2, color: ['red 0.5'] }",
                "{ from: 2, to: 3, color: ['yellow 0.5'] }",
                "{ from: 3, to: 7, color: ['green 0.5'] }",
                "{ from: 7, to: 8, color: ['yellow 0.5'] }",
                "{ from: 8, to: 10, color: ['red 0.5'] }"
        }); // line 범위

        linearGauge.scaleBar(0)
                .width("5%") // 너비 정의
                .colorScale(scaleBarColorScale); // scale bar 색 정의

        linearGauge.marker(0)
                .type(MarkerType.TRIANGLE_DOWN) // 마커 모양
                .color("red") // 색
                .offset("-3.5%")
                .zIndex(10); // 마커 정의

        linearGauge.scale()
                .minimum(0) // 라인 최소값
                .maximum(10); // 라인 최대값
//        linearGauge.scale().ticks

        linearGauge.axis(0)
                .minorTicks(false) // 보조선 사용 여부
                .width("1%");
        linearGauge.axis(0)
                .offset("-1.5%")
                .orientation(Orientation.TOP)
                .labels("top"); // 라벨 위치

        linearGauge.padding(0, 30, 0, 30);

        anyChartView.setChart(linearGauge);
    }
}
