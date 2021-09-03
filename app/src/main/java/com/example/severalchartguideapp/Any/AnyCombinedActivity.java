package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleStackMode;
import com.anychart.scales.Linear;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;


import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/CombinedChartActivity.java
public class AnyCombinedActivity extends AnyChartActivity{

    AnyChartView anyCombinedChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anycombined);

        anyCombinedChart = findViewById(R.id.any_combined_chart);

        Cartesian cartesian = AnyChart.cartesian();

        cartesian.animation(true); // 애니메이션 설정

        cartesian.title("Combination of Stacked Column and Line Chart (Dual Y-Axis)"); // 차트 이름 설정

        cartesian.yScale().stackMode(ScaleStackMode.VALUE); // Y축에 쌓을때 사용하는 기준. none(쌓지 않음), percent(데이터의 퍼센테이지), value(데이터 값)

        Linear scalesLinear = Linear.instantiate(); // linechart 세팅
        scalesLinear.minimum(0d);  // Y축 최소값
        scalesLinear.maximum(100d); // Y축 최대값
        scalesLinear.ticks("{ interval: 20 }"); // Y축 간격


        com.anychart.core.axes.Linear extraYAxis = cartesian.yAxis(1d);
        extraYAxis.orientation(Orientation.RIGHT) // Y축 위치
                .scale(scalesLinear); // ?
        extraYAxis.labels() // Y축 라벨 설정
                .padding(0d, 0d, 0d, 5d) // Y축 라벨 위치
                .format("{%Value}%") // Y축 포맷
                .fontColor("#ffcc00"); // Y축 글자색

        Set set = Set.instantiate();
        set.data(dataValues1()); // 56-57 dataset 차트에 set
        Mapping lineData = set.mapAs("{ x: 'x', value: 'value' }"); // 58-61 각 데이터 값별로 매핑
        Mapping column1Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping column2Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping column3Data = set.mapAs("{ x: 'x', value: 'value4' }");

        Line line = cartesian.line(lineData); // 라인데이터 설정
        line.yScale(scalesLinear); // linechart의 Y축 스케일 설정
        line.color("#aacc00"); // 라인색 설정
        line.labels().fontColor("#339900"); // line data 라벨 글자색
        line.name("생산량"); // line data 범례 이름
        line.labels().padding(0d,0d,15d,0d); // line data 라벨 위치

        Column column1 = cartesian.column(column1Data);
        column1.labels().fontColor("#ff3333");
        column1.labels().padding(0d,0d,-30d,0d);
        column1.name("Wine");
        column1.color("#00ccff");

        Column column2 = cartesian.column(column2Data);
        column2.labels().fontColor("#cc2266");
        column2.name("Whiskey");
        column2.labels().padding(0d,0d,-30d,0d);

        Column column3 = cartesian.column(column3Data);
        column3.labels().fontColor("#6600ff");
        column3.name("ETC");
        column3.labels().padding(0d,0d,-30d,0d);

        cartesian.labels(true); // 라벨 설정{위에서 라벨 설정 했어도 요거 없으면 라벨 안보임)
        cartesian.legend(true); // 범례 설정
        cartesian.legend().padding(0d, 0d, 20d, 0d); // 범례 위치

        anyCombinedChart.setChart(cartesian); // chart 로딩
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("P1", 96.5, 2040, 1200, 1600));
        datavals.add(new CustomDataEntry("P2", 77.1, 1794, 1124, 1724));
        datavals.add(new CustomDataEntry("P3", 73.2, 2026, 1006, 1806));
        datavals.add(new CustomDataEntry("P4", 61.1, 2341, 921, 1621));
        datavals.add(new CustomDataEntry("P5", 70.0, 1800, 1500, 1700));
        datavals.add(new CustomDataEntry("P6", 60.7, 1507, 1007, 1907));
        datavals.add(new CustomDataEntry("P7", 62.1, 2701, 921, 1821));
        datavals.add(new CustomDataEntry("P8", 75.1, 1671, 971, 1671));
        datavals.add(new CustomDataEntry("P9", 80.0, 1980, 1080, 1880));
        datavals.add(new CustomDataEntry("P10", 54.1, 1041, 1041, 1641));
        datavals.add(new CustomDataEntry("P11", 51.3, 813, 1113, 1913));
        datavals.add(new CustomDataEntry("P12", 59.1, 691, 1091, 1691));

        return datavals;
    }

    private static class CustomDataEntry extends ValueDataEntry { // dataset 생성 위한 class
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
        }
    }
}
