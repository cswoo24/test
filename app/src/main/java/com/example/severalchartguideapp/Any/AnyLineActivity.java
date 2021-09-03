package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/LineChartActivity.java
public class AnyLineActivity extends AnyChartActivity{

    AnyChartView anyLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyline);

        anyLineChart = findViewById(R.id.any_line_chart);


        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true); // animation setting

        cartesian.padding(10d, 20d, 5d, 20d); // chart padding 설정. 순서대로 bottom, left, right, top

        cartesian.crosshair().enabled(true); // 그래프 클릭 시 크로스헤어 여부
        cartesian.crosshair()
                .yLabel(true) // 크로스헤어 yLabel 세팅(object 값이 들어가서 세팅될 수도 있음)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null); // Y축 stroke 설정(라인 색, 두께 등)

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT); // 상세데이터 위치(chart : 차트 상단, point: 선택 위치에서 바로, float:선택 위치 옆에서 )

        cartesian.title("Trend of Sales of the Most Popular Products of ACME Corp."); // 차트 제목

        cartesian.yAxis(0).title("Number of Bottles Sold (thousands)"); // Y축 타이틀
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d); // X라벨 padding 세팅. 순서대로 top, right, bottom, left

        List<DataEntry> seriesData = new ArrayList<>(); // x라벨, 데이터 세팅
        seriesData.add(new CustomDataEntry("1986", 3.6, 2.3, 2.8));
        seriesData.add(new CustomDataEntry("1987", 7.1, 4.0, 4.1));
        seriesData.add(new CustomDataEntry("1988", 8.5, 6.2, 5.1));
        seriesData.add(new CustomDataEntry("1989", 9.2, 11.8, 6.5));
        seriesData.add(new CustomDataEntry("1990", 10.1, 13.0, 12.5));
        seriesData.add(new CustomDataEntry("1991", 11.6, 13.9, 18.0));
        seriesData.add(new CustomDataEntry("1992", 16.4, 18.0, 21.0));
        seriesData.add(new CustomDataEntry("1993", 18.0, 23.3, 20.3));
        seriesData.add(new CustomDataEntry("1994", 13.2, 24.7, 19.2));
        seriesData.add(new CustomDataEntry("1995", 12.0, 18.0, 14.4));
        seriesData.add(new CustomDataEntry("1996", 3.2, 15.1, 9.2));
        seriesData.add(new CustomDataEntry("1997", 4.1, 11.3, 5.9));
        seriesData.add(new CustomDataEntry("1998", 6.3, 14.2, 5.2));
        seriesData.add(new CustomDataEntry("1999", 9.4, 13.7, 4.7));
        seriesData.add(new CustomDataEntry("2000", 11.5, 9.9, 4.2));
        seriesData.add(new CustomDataEntry("2001", 13.5, 12.1, 1.2));
        seriesData.add(new CustomDataEntry("2002", 14.8, 13.5, 5.4));
        seriesData.add(new CustomDataEntry("2003", 16.6, 15.1, 6.3));
        seriesData.add(new CustomDataEntry("2004", 18.1, 17.9, 8.9));
        seriesData.add(new CustomDataEntry("2005", 17.0, 18.9, 10.1));
        seriesData.add(new CustomDataEntry("2006", 16.6, 20.3, 11.5));
        seriesData.add(new CustomDataEntry("2007", 14.1, 20.7, 12.2));
        seriesData.add(new CustomDataEntry("2008", 15.7, 21.6, 10));
        seriesData.add(new CustomDataEntry("2009", 12.0, 22.5, 8.9));

        Set set = Set.instantiate();
        set.data(seriesData); // 78-79 차트에 데이터 삽입
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }"); // data를 차트에 mapping
        Mapping series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

        Line series1 = cartesian.line(series1Mapping); // data를 line에 추가
        series1.name("Brandy"); // data 이름
        series1.color("#AA6600"); // 라인 색
        series1.hovered().markers().enabled(); // 마커 표시 여부
        series1.hovered().markers()
                .type(MarkerType.CIRCLE) // 마커 모양
                .size(4d); // 마커 크기
        series1.tooltip()
                .position("right") // 상세사항 위치
                .anchor(Anchor.LEFT_CENTER) // tooltip 움직일 때 마우스 위치
                .offsetX(5d) // tooltip의 x 좌표
                .offsetY(5d); // tooltip의 y 좌표

        Line series2 = cartesian.line(series2Mapping);
        series2.name("Whiskey");
        series2.hovered().markers().enabled(true);
        series2.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series2.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        Line series3 = cartesian.line(series3Mapping);
        series3.name("Tequila");
        series3.hovered().markers().enabled(true);
        series3.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series3.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        cartesian.legend().enabled(true); // 범례 표시 여부
        cartesian.legend().fontSize(13d); // 범례 글씨 크기
        cartesian.legend().padding(0d, 0d, 10d, 0d); // 범례 위치. 순서대로 top, right, bottom, left


        anyLineChart.setChart(cartesian); // 차트 load

        // You can't customize credits without a license key. See https://www.anychart.com/buy/ to learn more.
        // AnyChart Trial Version 제거 못함
    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) { // X라벨과 3개의 데이터를 생성하기 위해 만든 Custom Entry
            super(x, value); // ValueDataEntry에서 정의됨.
            setValue("value2", value2); // 데이터 추가
            setValue("value3", value3); // 데이터 추가
        }

    }
}
