package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.axes.Linear;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.Orientation;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/BarChartActivity.java
public class AnyBarActivity extends AnyChartActivity {

    AnyChartView anyBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anybar);

        // 여기서는 X축이 세로, y축이 가로!!
        anyBarChart = findViewById(R.id.any_bar_chart);

        Cartesian barChart = AnyChart.bar();

        barChart.animation(true);

        barChart.padding(10d, 20d, 5d, 20d); // chart 위치 정의. 순서대로 top, right, bottom, left

        barChart.yScale().stackMode(ScaleStackMode.VALUE);

        barChart.yAxis(0).labels().format(
                "function() {\n" +
                        "    return Math.abs(this.value).toLocaleString();\n" +
                        "  }"); // Y축 라벨 포맷

        barChart.yAxis(0d).title("Revenue in Dollars");

        barChart.xAxis(0d).overlapMode(LabelsOverlapMode.ALLOW_OVERLAP); // X0축 라벨 다 보여줄 건지 설정

        Linear xAxis1 = barChart.xAxis(1d);
        xAxis1.enabled(true); // X1축 생성 여부
        xAxis1.orientation(Orientation.RIGHT); // X1축 위치 설정
        xAxis1.overlapMode(LabelsOverlapMode.ALLOW_OVERLAP); // X1축 라벨 다 보여줄 건지 설정

        barChart.title("Cosmetic Sales by Gender");

        barChart.interactivity().hoverMode(HoverMode.BY_X);

        barChart.tooltip() // 데이터 선택했을 때 나오는 데이터 값 출력 창
                .title(false) // tooltip 제목
                .separator(false) //  union tooltip separator 설정
                .displayMode(TooltipDisplayMode.SEPARATED) // tooltip 보기 설정. union은 한 박스 안에 같이, SEPARATED는 따로
                .positionMode(TooltipPositionMode.POINT) // tooltip 위치 설정
                .useHtml(true) // Html 구성 사용 여부
                .fontSize(12d)
                .offsetX(5d)
                .offsetY(0d)
                .format(
                        "function() {\n" +
                                "      return '<span style=\"color: #D9D9D9\">$</span>' + Math.abs(this.value).toLocaleString();\n" +
                                "    }"); // tooltip 포맷 설정

        Set set = Set.instantiate();
        set.data(dataValues1());
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");

        Bar series1 = barChart.bar(series1Data);
        series1.name("Females")
                .color("HotPink");
        series1.tooltip()
                .position("right") // tooltip 위치
                .anchor(Anchor.LEFT_CENTER); // tooltip 박스 위치

        Bar series2 = barChart.bar(series2Data);
        series2.name("Males")
        .color("LightBlue");
        series2.tooltip()
                .position("left") // tooltip 위치
                .anchor(Anchor.RIGHT_CENTER); // tooltip 박스 위치

        barChart.legend().enabled(true);
        barChart.legend().inverted(true); // 범례 순서 변경 여부
        barChart.legend().fontSize(13d);
        barChart.legend().padding(0d, 0d, 20d, 0d);

        anyBarChart.setChart(barChart);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        List<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("Nail polish", 5376, -229));
        datavals.add(new CustomDataEntry("Eyebrow pencil", 10987, -932));
        datavals.add(new CustomDataEntry("Rouge", 7624, -5221));
        datavals.add(new CustomDataEntry("Lipstick", 8814, -256));
        datavals.add(new CustomDataEntry("Eyeshadows", 8998, -308));
        datavals.add(new CustomDataEntry("Eyeliner", 9321, -432));
        datavals.add(new CustomDataEntry("Foundation", 8342, -701));
        datavals.add(new CustomDataEntry("Lip gloss", 6998, -908));
        datavals.add(new CustomDataEntry("Mascara", 9261, -712));
        datavals.add(new CustomDataEntry("Shampoo", 5376, -9229));
        datavals.add(new CustomDataEntry("Hair conditioner", 10987, -13932));
        datavals.add(new CustomDataEntry("Body lotion", 7624, -10221));
        datavals.add(new CustomDataEntry("Shower gel", 8814, -12256));
        datavals.add(new CustomDataEntry("Soap", 8998, -5308));
        datavals.add(new CustomDataEntry("Eye fresher", 9321, -432));
        datavals.add(new CustomDataEntry("Deodorant", 8342, -11701));
        datavals.add(new CustomDataEntry("Hand cream", 7598, -5808));
        datavals.add(new CustomDataEntry("Foot cream", 6098, -3987));
        datavals.add(new CustomDataEntry("Night cream", 6998, -847));
        datavals.add(new CustomDataEntry("Day cream", 5304, -4008));
        datavals.add(new CustomDataEntry("Vanila cream", 9261, -712));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2) {
            super(x, value);
            setValue("value2", value2);
        }
    }
}
