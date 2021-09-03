package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.core.cartesian.series.JumpLine;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/VerticalChartActivity.java
public class AnyVerticalActivity  extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyvertical);

        AnyChartView anyChartView = findViewById(R.id.any_vertical_chart);

        Cartesian vertical = AnyChart.vertical();

        vertical.animation(true) // 애니메이션 설정
                .title("Vertical Combination of Bar and Jump Line Chart"); // 차트 제목 설정

        Set set = Set.instantiate();
        set.data(data());
        Mapping barData = set.mapAs("{ x: 'x', value: 'value' }"); // bardata로 dataset에서 value값 넣기
        Mapping jumpLineData = set.mapAs("{ x: 'x', value: 'jumpLine' }"); // jumpline으로 dataset에서 jumpline값 넣기

        Bar bar = vertical.bar(barData);
        bar.labels().format("${%Value} mln"); // bar 라벨 포맷

        JumpLine jumpLine = vertical.jumpLine(jumpLineData);
        jumpLine.stroke("2 #60727B"); // 선색, 두께
        jumpLine.labels().enabled(false); // jumpLine 라벨 표시X

        vertical.yScale().minimum(0d);//Y축 최소값

        vertical.labels(true); // chart 라벨 표시

        vertical.tooltip()
                .displayMode(TooltipDisplayMode.UNION) // tooltip 보기 설정
                .positionMode(TooltipPositionMode.POINT) // tooltip 위치 설정
                .unionFormat( // tooltip 포맷
                        "function() {\n" +
                                "      return 'Plain: $' + this.points[1].value + ' mln' +\n" +
                                "        '\\n' + 'Fact: $' + this.points[0].value + ' mln';\n" +
                                "    }");

        vertical.interactivity().hoverMode(HoverMode.BY_X);

        vertical.xAxis(true); // X축 보기
        vertical.yAxis(true); // Y축 보기
        vertical.yAxis(0).labels().format("${%Value} mln"); //Y축 라벨 포맷

        anyChartView.setChart(vertical);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomDataEntry("Jan", 11.5, 9.3));
        data.add(new CustomDataEntry("Feb", 12, 10.5));
        data.add(new CustomDataEntry("Mar", 11.7, 11.2));
        data.add(new CustomDataEntry("Apr", 12.4, 11.2));
        data.add(new CustomDataEntry("May", 13.5, 12.7));
        data.add(new CustomDataEntry("Jun", 11.9, 13.1));
        data.add(new CustomDataEntry("Jul", 14.6, 12.2));
        data.add(new CustomDataEntry("Aug", 17.2, 12.2));
        data.add(new CustomDataEntry("Sep", 16.9, 10.1));
        data.add(new CustomDataEntry("Oct", 15.4, 14.5));
        data.add(new CustomDataEntry("Nov", 16.9, 14.5));
        data.add(new CustomDataEntry("Dec", 17.2, 15.5));

        return data;
    }

    private class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String x, Number value, Number jumpLine) {
            super(x, value);
            setValue("jumpLine", jumpLine);
        }
    }
}
