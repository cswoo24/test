package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.CircularGauge;
import com.anychart.core.axes.Circular;
import com.anychart.core.gauge.pointers.Bar;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.VAlign;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/CircularGaugeActivity.java
public class AnyCircularGaugeActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anycirculargauge);

        AnyChartView anyChartView = findViewById(R.id.any_circular_gauge);

        CircularGauge circularGauge = AnyChart.circular();

        circularGauge.animation(true);

        circularGauge.data(new SingleValueDataSet(new String[] { "23", "34", "67", "93", "56","77", "100"})); // dataset. 마지막 데이터 값은 항상 100으로 고정. 게이지 바 넣을 때 사용함
        circularGauge.fill("#fff") // 게이지바 색
                .stroke(null) // 게이지바 두께
                .padding(0d, 0d, 0d, 0d)
                .margin(100d, 100d, 100d, 100d);
        circularGauge.startAngle(0d); // 게이지바 시작 각도(0도)
        circularGauge.sweepAngle(270d); // 게이지바 회전각도(270도)

        Circular xAxis = circularGauge.axis(0)
                .radius(100d) // 막대 포인터 반지름. null이면 자동계산
                .width(1d)
                .fill((Fill) null); // 막대 x축 색(제일 바깥원에만 색 나옴)
        xAxis.scale()
                .minimum(0d) // X축의 최소값. 적혀진 숫자부터 시작
                .maximum(100d); // X축의 최대값
        xAxis.ticks("{ interval: 1 }")
                .minorTicks("{ interval: 1 }");
        xAxis.labels().enabled(false);
        xAxis.ticks().enabled(false);
        xAxis.minorTicks().enabled(false);

        circularGauge.label(0d)
                .text("Temazepam, <span style=\"\">32%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER) // 글자의 horizontal align
                .vAlign(VAlign.MIDDLE); // 글자의 vertical align
        circularGauge.label(0d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%") // ?(이 계산식이 왜 나왔는지 잘 모르겠음. width / ? + "%")
                .offsetY(100d + "%") // bar0, bar100과 Y 맞춤
                .offsetX(0d);
        Bar bar0 = circularGauge.bar(0d); // 데이터 값
        bar0.dataIndex(0d); // data index 세팅
        bar0.radius(100d); // 반지름
        bar0.width(17d); // 데이터 값 너비
        bar0.fill(new SolidFill("#64b5f6", 1d)); // 데이터 색
        bar0.stroke(null); // 데이터 두께, 색
        bar0.zIndex(5d); // 데이터 깊이
        Bar bar100 = circularGauge.bar(100d);
        bar100.dataIndex(6d); // 게이지바 데이터 값(dataset)
        bar100.radius(100d);
        bar100.width(17d);
        bar100.fill(new SolidFill("#F5F4F4", 1d)); // 게이지바 색
        bar100.stroke("1 #e5e4e4"); // 게이지바 두께, 색
        bar100.zIndex(4d); // 깊이

        circularGauge.label(1d)
                .text("Guaifenesin, <span style=\"\">34%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(1d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(80d + "%")
                .offsetX(0d);
        Bar bar1 = circularGauge.bar(1d);
        bar1.dataIndex(1d);
        bar1.radius(80d);
        bar1.width(17d);
        bar1.fill(new SolidFill("#1976d2", 1d));
        bar1.stroke(null);
        bar1.zIndex(5d);
        Bar bar101 = circularGauge.bar(101d);
        bar101.dataIndex(6d);
        bar101.radius(80d);
        bar101.width(17d);
        bar101.fill(new SolidFill("#F5F4F4", 1d));
        bar101.stroke("1 #e5e4e4");
        bar101.zIndex(4d);

        circularGauge.label(2d)
                .text("Salicylic Acid, <span style=\"\">67%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(2d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(60d + "%")
                .offsetX(0d);
        Bar bar2 = circularGauge.bar(2d);
        bar2.dataIndex(2d);
        bar2.radius(60d);
        bar2.width(17d);
        bar2.fill(new SolidFill("#ef6c00", 1d));
        bar2.stroke(null);
        bar2.zIndex(5d);
        Bar bar102 = circularGauge.bar(102d);
        bar102.dataIndex(6d);
        bar102.radius(60d);
        bar102.width(17d);
        bar102.fill(new SolidFill("#F5F4F4", 1d));
        bar102.stroke("1 #e5e4e4");
        bar102.zIndex(4d);

        circularGauge.label(3d)
                .text("Fluoride, <span style=\"\">93%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(3d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(40d + "%")
                .offsetX(0d);
        Bar bar3 = circularGauge.bar(3d);
        bar3.dataIndex(3d);
        bar3.radius(40d);
        bar3.width(17d);
        bar3.fill(new SolidFill("#ffd54f", 1d));
        bar3.stroke(null);
        bar3.zIndex(5d);
        Bar bar103 = circularGauge.bar(103d);
        bar103.dataIndex(6d);
        bar103.radius(40d);
        bar103.width(17d);
        bar103.fill(new SolidFill("#F5F4F4", 1d));
        bar103.stroke("1 #e5e4e4");
        bar103.zIndex(4d);

        circularGauge.label(4d)
                .text("Zinc Oxide, <span style=\"\">56%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(4d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(20d + "%")
                .offsetX(0d);
        Bar bar4 = circularGauge.bar(4d);
        bar4.dataIndex(4d);
        bar4.radius(20d);
        bar4.width(17d);
        bar4.fill(new SolidFill("#455a64", 1d));
        bar4.stroke(null);
        bar4.zIndex(5d);
        Bar bar104 = circularGauge.bar(104d);
        bar104.dataIndex(6d);
        bar104.radius(20d);
        bar104.width(17d);
        bar104.fill(new SolidFill("#F5F4F4", 1d));
        bar104.stroke("1 #e5e4e4");
        bar104.zIndex(4d);

        circularGauge.label(5d)
                .text("Test data, <span style=\"\">77%</span>")
                .useHtml(true)
                .hAlign(HAlign.CENTER)
                .vAlign(VAlign.MIDDLE);
        circularGauge.label(5d)
                .anchor(Anchor.RIGHT_CENTER)
                .padding(0d, 10d, 0d, 0d)
                .height(17d / 2d + "%")
                .offsetY(120d + "%")
                .offsetX(0d);
        Bar bar5 = circularGauge.bar(5d);
        bar5.dataIndex(5d);
        bar5.radius(120d);
        bar5.width(17d);
        bar5.fill(new SolidFill("#f21", 1d));
        bar5.stroke(null);
        bar5.zIndex(5d);
        Bar bar105 = circularGauge.bar(105d);
        bar105.dataIndex(6d);
        bar105.radius(120d);
        bar105.width(17d);
        bar105.fill(new SolidFill("#F5F4F4", 1d));
        bar105.stroke("1 #e5e4e4");
        bar105.zIndex(4d);


        circularGauge.margin(50d, 50d, 50d, 50d); // 차트 전체 위치
        circularGauge.title()
                .text("Medicine manufacturing progress' +\n" +
                        "    '<br/><span style=\"color:#929292; font-size: 12px;\">(ACME CORPORATION)</span>")
                .useHtml(true);
        circularGauge.title().enabled(true);
        circularGauge.title().hAlign(HAlign.CENTER);
        circularGauge.title() // 제목 설정
                .padding(0d, 0d, 0d, 0d) // 순서대로 top, right, bottom, left
                .margin(0d, 0d, 20d, 0d);

        anyChartView.setChart(circularGauge);
    }
}
