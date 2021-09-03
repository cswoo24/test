package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Area;
import com.anychart.core.ui.Crosshair;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.Stroke;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/AreaChartActivity.java
public class AnyAreaActivity extends AnyChartActivity {

    AnyChartView anyAreaChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyarea);

        anyAreaChart = findViewById(R.id.any_area_chart);


        Cartesian areaChart = AnyChart.area();

        areaChart.animation(true);

        Crosshair crosshair = areaChart.crosshair();
        crosshair.enabled(true);
        // TODO yStroke xStroke in crosshair
        crosshair.yStroke((Stroke) null, null, null, (String) null, (String) null)
                .xStroke("#fff", 1d, null, (String) null, (String) null) // 크로스헤어 선 속성
                .zIndex(300); // 인덱스가 클수록 요소 위치가 위에 있음
        crosshair.yLabel(0).enabled(true); // 크로스헤어 볼 때 y값 보기 여부

        areaChart.yScale().stackMode(ScaleStackMode.VALUE);

        areaChart.title("Unaudited Apple Inc. Revenue by Operating Segments");

        Set set = Set.instantiate();
        set.data(dataValues1()); // data insert
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");
        Mapping series5Data = set.mapAs("{ x: 'x', value: 'value5' }");

        // data
        Area series1 = areaChart.area(series1Data);
        series1.name("Americas"); // 그룹 이름
        series1.stroke("10 #fff"); // 그룹 간 간격, 색
        // 64-69 line 아직 이해 못함(20210413) // 66-72 적용 안 된 것으로 보임. 굵기,색,모양 바꿔도 보이지 않았음
        series1.hovered().stroke("10 #f00");
        series1.hovered().markers().enabled(true); // 64-69 line 아직 이해 못함(20210413)
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series1.markers().zIndex(100d);

        Area series2 = areaChart.area(series2Data);
        series2.name("Europe");
        series2.stroke("3 #fff");
        series2.hovered().stroke("3 #fff");
        series2.hovered().markers().enabled(true);
        series2.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series2.markers().zIndex(100d);

        Area series3 = areaChart.area(series3Data);
        series3.name("Greater China");
        series3.stroke("3 #fff");
        series3.hovered().stroke("3 #fff");
        series3.hovered().markers().enabled(true);
        series3.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series3.markers().zIndex(100d);

        Area series4 = areaChart.area(series4Data);
        series4.name("Japan");
        series4.stroke("3 #fff");
        series4.hovered().stroke("3 #fff");
        series4.hovered().markers().enabled(true);
        series4.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series4.markers().zIndex(100d);

        Area series5 = areaChart.area(series5Data);
        series5.name("Rest of Asia Pacific");
        series5.stroke("3 #fff");
        series5.hovered().stroke("3 #fff");
        series5.hovered().markers().enabled(true);
        series5.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d)
                .stroke("1.5 #fff");
        series5.markers().zIndex(100d);

        areaChart.legend().enabled(true); // 범례
        areaChart.legend().fontSize(13d);
        areaChart.legend().padding(0d, 0d, 20d, 0d);

        areaChart.xAxis(0).title(false); // X축 제목
        areaChart.yAxis(0).title("Revenue (in Billons USD)"); // Y축 제목

        areaChart.interactivity().hoverMode(HoverMode.BY_X);
        areaChart.tooltip()
                .valuePrefix("$") // 데이터 앞에 고정으로 들어감
                .valuePostfix(" bln.") // 데이터 뒤에 고정으로 들어감
                .displayMode(TooltipDisplayMode.UNION) // tooltip 볼 때 모든 파일의 값을 다 볼수 있게
                .background("#ccccff") // tooltip box 배경색
                .fontColor("#000") // tooltip 글자색
        ;

        anyAreaChart.setChart(areaChart);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("Q2 2014", 17.982, 10.941, 9.835, 4.047, 2.841));
        datavals.add(new CustomDataEntry("Q3 2014", 17.574, 8.659, 6.230, 2.627, 2.242));
        datavals.add(new CustomDataEntry("Q4 2014", 19.75, 10.35, 6.292, 3.595, 2.136));
        datavals.add(new CustomDataEntry("Q1 2015", 30.6, 17.2, 16.1, 5.4, 5.2));
        datavals.add(new CustomDataEntry("Q2 2015", 21.316, 12.204, 16.823, 3.457, 4.210));
        datavals.add(new CustomDataEntry("Q3 2015", 20.209, 10.342, 13.23, 2.872, 2.959));
        datavals.add(new CustomDataEntry("Q4 2015", 21.773, 10.577, 12.518, 3.929, 2.704));
        datavals.add(new CustomDataEntry("Q1 2016", 29.3, 17.9, 18.4, 4.8, 5.4));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }
}
