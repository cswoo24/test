package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Column3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.SolidFill;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/Column3DChartActivity.java
public class AnyColumn3DActivity extends AnyChartActivity{

    AnyChartView anyColumn3dChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anycolumn3d);

        anyColumn3dChart = findViewById(R.id.any_column3d_chart);

        Cartesian3d column3d = AnyChart.column3d();

        column3d.yScale().stackMode(ScaleStackMode.VALUE); // Y축에 쌓을때 사용하는 기준. none(쌓지 않음), percent(데이터의 퍼센테이지), value(데이터 값)

        column3d.animation(true);

        column3d.title("Types of Coffee");
        column3d.title().padding(0d, 0d, 15d, 0d); // 차트 제목 위치
        //anyColumn3dChart.setBackgroundColor("#cc99cc"); // 차트 로딩 전 배경색

        Set set = Set.instantiate();
        set.data(dataValues1());
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");
        Mapping series5Data = set.mapAs("{ x: 'x', value: 'value5' }");
        Mapping series6Data = set.mapAs("{ x: 'x', value: 'value6' }");

        Column3d series1 = column3d.column(series1Data);
        series1.name("Espresso");
        series1.fill(new SolidFill("#3e2723", 1d)); // 그래프 색과 불투명도 설정
        series1.stroke("1 #f7f3f3"); // 테두리의 두께와 색 설정
        series1.hovered().stroke("3 #f7f3f3"); // ?

        Column3d series2 = column3d.column(series2Data);
        series2.name("Water");
        series2.fill(new SolidFill("#64b5f6", 1d));
        series2.stroke("1 #f7f3f3");
        series2.hovered().stroke("3 #f7f3f3");
        series2.labels().fontColor("#ccFF00");

        Column3d series3 = column3d.column(series3Data);
        series3.name("Milk");
        series3.fill(new SolidFill("#fff3e0", 1d));
        series3.stroke("1 #f7f3f3");
        series3.hovered().stroke("3 #f7f3f3");

        Column3d series4 = column3d.column(series4Data);
        series4.name("Steamed milk");
        series4.fill(new SolidFill("#bcaaa4", 1d));
        series4.stroke("1 #f7f3f3");
        series4.hovered().stroke("3 #f7f3f3");

        Column3d series5 = column3d.column(series5Data);
        series5.name("Cream");
        series5.fill(new SolidFill("#e6c1b5", 1d));
        series5.stroke("1 #f7f3f3");
        series5.hovered().stroke("3 #f7f3f3");

        Column3d series6 = column3d.column(series6Data);
        series6.name("Chocolate");
        series6.fill(new SolidFill("#bf360c", 1d));
        series6.stroke("1 #f7f3f3");
        series6.hovered().stroke("3 #f7f3f3");

        column3d.legend().enabled(true);
        column3d.legend().fontSize(13d);
        column3d.legend().padding(0d, 0d, 20d, 0d);

        column3d.yScale().ticks("[0, 1, 2, 3, 4, 5]"); // Y축 라벨
        column3d.xAxis(0).stroke("1 #a18b7e");
        column3d.xAxis(0).labels().fontSize(15d); // X축 라벨 글자 크기
        column3d.yAxis(0).stroke("1 #a18b7e"); // Y축 굵기,색
        column3d.yAxis(0).labels().fontColor("#a18b7e");
        column3d.yAxis(0).labels().format("{%Value}{groupsSeparator: }"); // Y축 라벨 포맷

        column3d.yAxis(0).title().enabled(true);
        column3d.yAxis(0).title().text("Portions of Ingredients");
        column3d.yAxis(0).title().fontColor("#a18b7e");

        column3d.interactivity().hoverMode(HoverMode.BY_X);

        column3d.tooltip()
                .displayMode(TooltipDisplayMode.UNION) // tooltip 보여주기 설정
                .format("{%Value} {%SeriesName}");


        column3d.yGrid(0).stroke("#a18b7e", 1d, null, null, null); // Y축 그리드 설정
        column3d.xGrid(0).stroke("#a18b7e", 1d, null, null, null); // X축 그리드 설정

        column3d.labels(true);

        anyColumn3dChart.setChart(column3d);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("Espresso", 1, null, null, null, null, null));
        datavals.add(new CustomDataEntry("Doppio", 2, null, null, null, null, null));
        datavals.add(new CustomDataEntry("Trippio", 3, null, null, null, null, null));
        datavals.add(new CustomDataEntry("Americano", 1, 3, null, null, null, null));
        datavals.add(new CustomDataEntry("Cappuchino", 1, null, 1, 2, null, null));
        datavals.add(new CustomDataEntry("Macchiato", 2.5, null, null, 1, null, null));
        datavals.add(new CustomDataEntry("Latte", 1, null, 2, 1, null, null));
        datavals.add(new CustomDataEntry("Latte Macchiato", 1, null, 2, null, 1, null));
        datavals.add(new CustomDataEntry("Vienna Coffee", 1, null, null, null, 2, null));
        datavals.add(new CustomDataEntry("Mocco", 1, null, 1, null, 1, 1));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5, Number value6) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
            setValue("value6", value6);
        }
    }
}
