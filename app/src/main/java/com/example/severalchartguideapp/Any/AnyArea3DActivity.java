package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Area3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.hatchfill.HatchFillType;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/Area3DChartActivity.java
public class AnyArea3DActivity extends AnyChartActivity{

    AnyChartView anyArea3DChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyarea3d);

        anyArea3DChart = findViewById(R.id.any_area3d_chart);

        Cartesian3d area3d = AnyChart.area3d();

        area3d.xAxis(0).labels().format("${%Value}"); // X축 라벨 포맷

        area3d.animation(true); // 애니메이션 on(lond 시)

        area3d.yAxis(0).title("The Share Price");
        area3d.xAxis(0).title("Year/Month/Day");
        area3d.xAxis(0).labels().padding(5d, 5d, 0d, 5d); // X축 라벨 위치

        area3d.title("The cost of ACME\\'s shares<br/>' +\n" +
                "    '<span style=\"color:#212121; font-size: 13px;\">Statistics was collected from site N during September</span>");

        area3d.title().useHtml(true); // Html 속성을 사용할 것인지 여부
        area3d.title().padding(0d, 0d, 20d, 0d); // 차트 제목 위치


        Set set = Set.instantiate();
        set.data(dataValues1());
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");

        Area3d series1 = area3d.area(series1Data);
        series1.name("ACME Share Price");
        series1.hovered().markers(false);
        series1.hatchFill("diagonal", "#000", 0.6d, 10d); // chart 채우기(채우기 모양, 색,두께, 크기)(https://api.anychart.com 에 hatchFill 검색하면 HatchFillType 나옴. 아니면 밑에처럼 사용할 수 있음)

        Area3d series2 = area3d.area(series2Data);
        series2.name("The Competitor\\'s Share Price");
        series2.hovered().markers(false);
        series2.hatchFill(HatchFillType.DIAGONAL_BRICK, "#000", 0.6d, 10d);

        area3d.tooltip()
                .position(Position.CENTER_TOP)
                .positionMode(TooltipPositionMode.POINT)
                .anchor(Anchor.LEFT_BOTTOM)
                .offsetX(5d)
                .offsetY(5d);

        area3d.interactivity().hoverMode(HoverMode.BY_X);
        area3d.zAspect("100%"); // 3D 깊이 설정

        anyArea3DChart.setChart(area3d);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<DataEntry> datavals = new ArrayList<>();

        List<DataEntry> seriesData = new ArrayList<>();
        datavals.add(new CustomDataEntry("1986", 162, 42));
        datavals.add(new CustomDataEntry("1987", 134, 54));
        datavals.add(new CustomDataEntry("1988", 116, 26));
        datavals.add(new CustomDataEntry("1989", 122, 32));
        datavals.add(new CustomDataEntry("1990", 178, 68));
        datavals.add(new CustomDataEntry("1991", 144, 54));
        datavals.add(new CustomDataEntry("1992", 125, 35));
        datavals.add(new CustomDataEntry("1993", 176, 66));
        datavals.add(new CustomDataEntry("1994", 156, 80));
        datavals.add(new CustomDataEntry("1995", 195, 120));
        datavals.add(new CustomDataEntry("1996", 215, 115));
        datavals.add(new CustomDataEntry("1997", 176, 36));
        datavals.add(new CustomDataEntry("1998", 167, 47));
        datavals.add(new CustomDataEntry("1999", 142, 72));
        datavals.add(new CustomDataEntry("2000", 117, 37));
        datavals.add(new CustomDataEntry("2001", 113, 23));
        datavals.add(new CustomDataEntry("2002", 132, 30));
        datavals.add(new CustomDataEntry("2003", 146, 46));
        datavals.add(new CustomDataEntry("2004", 169, 59));
        datavals.add(new CustomDataEntry("2005", 184, 44));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2) {
            super(x, value);
            setValue("value2", value2);
        }
    }
}