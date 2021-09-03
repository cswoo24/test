package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.CircularGauge;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/WindDirectionActivity.java
public class AnyWinddirectionActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anywinddirection);

        AnyChartView anyChartView = findViewById(R.id.any_winddirection);

        CircularGauge circularGauge = AnyChart.circular();
        circularGauge.fill("#fff") // 채우기 흰색
                .stroke("null") // 둘레 두께 없음
                .padding(0, 0, 0, 0)
                .margin(30, 30, 30, 30)
                .startAngle(0) // 시작 : 0도
                .sweepAngle(360); // 360도 돌기

        circularGauge.data(new SingleValueDataSet(new Double[] { 18.1 })); // dataset

        circularGauge.axis(0) // 차트
                .startAngle(0)
                .radius(80) // 반지름
                .sweepAngle(360)
                .width(3) // 너비
                .drawFirstLabel(false)
                .ticks("{ type: 'line', length: 4, position: 'outside' }");

        circularGauge.axis(0).labels() // 차트 라벨
                .position("outside") // 밖에
                .useHtml(true);
        circularGauge.axis(0).labels().format( // 라벨 포맷 속성
                "function () {\n" +
                        "    return this.value + '&deg;'\n" +
                        "  }");

        circularGauge.axis(0).scale()
                .minimum(0) // 최소값
                .maximum(360); // 최대값
        circularGauge.axis(0).scale()
                .ticks("{interval: 45}") // 간격 45도씩
                .minorTicks("{interval: 10}");

        circularGauge.marker(0) // 마커
                .fill(new SolidFill("#64b5f6", 1)) // 색, 불투명도
                .stroke("null"); // 둘레 두께
        circularGauge.marker(0)
                .size(7)
                .radius(80);

        circularGauge.label(0) // 차트 라벨(원안에 들어가는 wind direction)
                .text("<span style=\"font-size: 25\">Wind Direction</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(0)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(50)
                .padding(15, 20, 0, 0);

        circularGauge.label(1) // 현재 바람 방향
                .text("<span style=\"font-size: 20\">18.1</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER);
        circularGauge.label(1)
                .anchor(Anchor.CENTER_TOP)
                .offsetY(-20)
                .padding(5, 10, 0, 0)
                .background("{fill: 'none', stroke: '#c1c1c1', corners: 3, cornerType: 'ROUND'}"); // 방향 배경 표시(배경색,  둘레 색, 두께, 각진 회수, 각 모양)

        anyChartView.setChart(circularGauge);
    }
}
