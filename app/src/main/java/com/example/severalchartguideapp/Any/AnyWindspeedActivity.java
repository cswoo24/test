package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.CircularGauge;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.text.HAlign;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/WindSpeedActivity.java
public class AnyWindspeedActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anywindspeed);

        AnyChartView anyChartView = findViewById(R.id.any_windspeed);

        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff")
                .stroke(null)
                .padding(0, 0, 0, 0)
                .margin(30, 30, 30, 30);
        circularGauge.startAngle(0)
                .sweepAngle(360);

        double currentValue = 13.8D; // 현재 속도
        circularGauge.data(new SingleValueDataSet(new Double[] { currentValue }));

        circularGauge.axis(0)
                .startAngle(-150) // 시작 위치
                .radius(80) // 반지름
                .sweepAngle(300) // 종료 위치
                .width(3) // 너비
                .ticks("{ type: 'line', length: 4, position: 'outside' }");

        circularGauge.axis(0).labels().position("outside"); // 차트 라벨 위치

        circularGauge.axis(0).scale()
                .minimum(0) // 최소값
                .maximum(140); // 최대값

        circularGauge.axis(0).scale()
                .ticks("{interval: 10}") // 간격 10
                .minorTicks("{interval: 10}");

        circularGauge.needle(0) // 속도 표시 바(빨간색 바늘)
                .stroke(null)
                .startRadius("6%")
                .endRadius("38%")
                .startWidth("2%")
                .endWidth(0)
                .fill("#f30");

        circularGauge.cap() // 속도계 가운데 원
                .radius("4%")
                .enabled(true)
                .stroke(null);

        circularGauge.label(0) // 원 안 wind speed 속성
                .text("<span style=\"font-size: 25\">Wind Speed</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(0)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(100)
                .padding(15, 20, 0, 0);

        circularGauge.label(1) // 현재 속도 표시 부분
                .text("<span style=\"font-size: 20\">" + currentValue + "</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(1)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(-100) // Y축 좌표
                .padding(5, 10, 0, 0)
                .background("{fill: 'none', stroke: '#c1c1c1', corners: 3, cornerType: 'ROUND'}"); // 속도 배경 표시(배경색,  둘레 색, 두께, 각진 회수, 각 모양)

        circularGauge.range(0, // 차트 범위 (저속 구간)
                "{\n" +
                        "    from: 0,\n" +
                        "    to: 25,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'green 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        circularGauge.range(1, // 차트 범위(고속 구간)
                "{\n" +
                        "    from: 80,\n" +
                        "    to: 140,\n" +
                        "    position: 'inside',\n" +
                        "    fill: 'red 0.5',\n" +
                        "    stroke: '1 #000',\n" +
                        "    startSize: 6,\n" +
                        "    endSize: 6,\n" +
                        "    radius: 80,\n" +
                        "    zIndex: 1\n" +
                        "  }");

        anyChartView.setChart(circularGauge);
    }
}
