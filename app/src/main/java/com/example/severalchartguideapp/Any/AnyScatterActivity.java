package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Scatter;
import com.anychart.core.scatter.series.Line;
import com.anychart.core.scatter.series.Marker;
import com.anychart.enums.HoverMode;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.graphics.vector.GradientKey;
import com.anychart.graphics.vector.LinearGradientStroke;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/ScatterChartActivity.java
public class AnyScatterActivity extends AnyChartActivity{

    AnyChartView anyScatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyscatter);

        anyScatterChart = findViewById(R.id.any_scatter_chart);

        Scatter scatter = AnyChart.scatter();

        scatter.animation(true);

        scatter.title("System interruptions");

        scatter.xScale()
                .minimum(1.5d) // X축 최소값
                .maximum(5.5d); // X축 최대값
//        scatter.xScale().tick
        scatter.yScale()
                .minimum(40d) // Y축 최소값
                .maximum(100d); // Y축 최소값

        scatter.yAxis(0).title("Waiting time between interruptions (Min)");
        scatter.xAxis(0)
                .title("Interruption duration (Min)")
                .drawFirstLabel(false) // X축 첫번째 라벨 표시 여부
                .drawLastLabel(false); // X축 마지막 라벨 표시 여부

        scatter.interactivity()
                .hoverMode(HoverMode.BY_SPOT) // 클릭될 때 사용되는 방법
                .spotRadius(30d); // 선택되는 spot 영역의 반지름

        scatter.tooltip().displayMode(TooltipDisplayMode.UNION);

        Marker marker = scatter.marker(getMarkerData());
        marker.type(MarkerType.PENTAGON) // 그래프에 표시되는 마커 모양, 크기
                .size(5d);
        marker.hovered() // 63-65 ?
                .size(30d)
                .fill(new SolidFill("gold", 1d))
                .stroke("anychart.color.darken(gold)");
        marker.tooltip()
                .hAlign(HAlign.START) // tooltip 내용 정렬
                .format("Waiting time: ${%Value} min.\\nDuration: ${%X} min.");

        Line scatterSeriesLine = scatter.line(getLineData());

        GradientKey gradientKey[] = new GradientKey[] {
                new GradientKey("#f00", 0d, 1d),
                new GradientKey("#0f0", 40d, 1d) // 색, 위치, 불투명도
        }; // 그라디언트 설정
        LinearGradientStroke linearGradientStroke = new LinearGradientStroke(0d, null, gradientKey, null, null, true, 1d, 2d);
        scatterSeriesLine.stroke(linearGradientStroke, 3d, null, (String) null, (String) null); // linedata의 선 색,두께,페턴 등 정의

        anyScatterChart.setChart(scatter);
    }

    private List<DataEntry> getLineData() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry(1.7, 54.310454158527));
        data.add(new ValueDataEntry(1.8, 55.2005091829704));
        data.add(new ValueDataEntry(1.9, 56.0905642074139));
        data.add(new ValueDataEntry(2, 56.9806192318574));
        data.add(new ValueDataEntry(2.1, 57.8706742563008));
        data.add(new ValueDataEntry(2.2, 58.7607292807443));
        data.add(new ValueDataEntry(2.3, 59.6507843051877));
        data.add(new ValueDataEntry(2.5, 61.4308943540747));
        data.add(new ValueDataEntry(2.6, 62.3209493785181));
        data.add(new ValueDataEntry(2.7, 63.2110044029616));
        data.add(new ValueDataEntry(2.9, 64.9911144518485));
        data.add(new ValueDataEntry(3, 65.881169476292));
        data.add(new ValueDataEntry(3.1, 66.7712245007354));
        data.add(new ValueDataEntry(3.2, 67.6612795251789));
        data.add(new ValueDataEntry(3.3, 68.5513345496223));
        data.add(new ValueDataEntry(3.4, 69.4413895740658));
        data.add(new ValueDataEntry(3.5, 70.3314445985093));
        data.add(new ValueDataEntry(3.6, 71.2214996229527));
        data.add(new ValueDataEntry(3.7, 72.1115546473962));
        data.add(new ValueDataEntry(3.8, 73.0016096718396));
        data.add(new ValueDataEntry(3.9, 73.8916646962831));
        data.add(new ValueDataEntry(4, 74.7817197207266));
        data.add(new ValueDataEntry(4.1, 75.67177474517));
        data.add(new ValueDataEntry(4.2, 76.5618297696135));
        data.add(new ValueDataEntry(4.3, 77.4518847940569));
        data.add(new ValueDataEntry(4.4, 78.3419398185004));
        data.add(new ValueDataEntry(4.5, 79.2319948429438));
        data.add(new ValueDataEntry(4.6, 80.1220498673873));
        data.add(new ValueDataEntry(4.7, 81.0121048918308));
        data.add(new ValueDataEntry(4.8, 81.9021599162742));
        data.add(new ValueDataEntry(4.9, 82.7922149407177));
        data.add(new ValueDataEntry(5, 83.6822699651611));
        data.add(new ValueDataEntry(5.1, 84.5723249896046));
        data.add(new ValueDataEntry(5.2, 85.4623800140481));

        return data;
    }

    private List<DataEntry> getMarkerData() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry(4.4, 78));
        data.add(new ValueDataEntry(3.9, 74));
        data.add(new ValueDataEntry(4, 68));
        data.add(new ValueDataEntry(4, 76));
        data.add(new ValueDataEntry(3.5, 80));
        data.add(new ValueDataEntry(4.1, 84));
        data.add(new ValueDataEntry(2.3, 50));
        data.add(new ValueDataEntry(4.7, 93));
        data.add(new ValueDataEntry(1.7, 55));
        data.add(new ValueDataEntry(4.9, 76));
        data.add(new ValueDataEntry(1.7, 58));
        data.add(new ValueDataEntry(4.6, 74));
        data.add(new ValueDataEntry(3.4, 75));
        data.add(new ValueDataEntry(4.3, 80));
        data.add(new ValueDataEntry(1.7, 56));
        data.add(new ValueDataEntry(3.9, 80));
        data.add(new ValueDataEntry(3.7, 69));
        data.add(new ValueDataEntry(3.1, 57));
        data.add(new ValueDataEntry(4, 90));
        data.add(new ValueDataEntry(1.8, 42));
        data.add(new ValueDataEntry(4.1, 91));
        data.add(new ValueDataEntry(1.8, 51));
        data.add(new ValueDataEntry(3.2, 79));
        data.add(new ValueDataEntry(1.9, 53));
        data.add(new ValueDataEntry(4.6, 82));
        data.add(new ValueDataEntry(2, 51));
        data.add(new ValueDataEntry(4.5, 76));
        data.add(new ValueDataEntry(3.9, 82));
        data.add(new ValueDataEntry(4.3, 84));
        data.add(new ValueDataEntry(2.3, 53));
        data.add(new ValueDataEntry(3.8, 86));
        data.add(new ValueDataEntry(1.9, 51));
        data.add(new ValueDataEntry(4.6, 85));
        data.add(new ValueDataEntry(1.8, 45));
        data.add(new ValueDataEntry(4.7, 88));
        data.add(new ValueDataEntry(1.8, 51));
        data.add(new ValueDataEntry(4.6, 80));
        data.add(new ValueDataEntry(1.9, 49));
        data.add(new ValueDataEntry(3.5, 82));
        data.add(new ValueDataEntry(4, 75));
        data.add(new ValueDataEntry(3.7, 73));
        data.add(new ValueDataEntry(3.7, 67));
        data.add(new ValueDataEntry(4.3, 68));
        data.add(new ValueDataEntry(3.6, 86));
        data.add(new ValueDataEntry(3.8, 72));
        data.add(new ValueDataEntry(3.8, 75));
        data.add(new ValueDataEntry(3.8, 75));
        data.add(new ValueDataEntry(2.5, 66));
        data.add(new ValueDataEntry(4.5, 84));
        data.add(new ValueDataEntry(4.1, 70));
        data.add(new ValueDataEntry(3.7, 79));
        data.add(new ValueDataEntry(3.8, 60));
        data.add(new ValueDataEntry(3.4, 86));
        data.add(new ValueDataEntry(4, 71));
        data.add(new ValueDataEntry(2.3, 67));
        data.add(new ValueDataEntry(4.4, 81));
        data.add(new ValueDataEntry(4.1, 76));
        data.add(new ValueDataEntry(4.3, 83));
        data.add(new ValueDataEntry(3.3, 76));
        data.add(new ValueDataEntry(2, 55));
        data.add(new ValueDataEntry(4.3, 73));
        data.add(new ValueDataEntry(2.9, 56));
        data.add(new ValueDataEntry(4.6, 83));
        data.add(new ValueDataEntry(1.9, 57));
        data.add(new ValueDataEntry(3.6, 71));
        data.add(new ValueDataEntry(3.7, 72));
        data.add(new ValueDataEntry(3.7, 77));
        data.add(new ValueDataEntry(1.8, 55));
        data.add(new ValueDataEntry(4.6, 75));
        data.add(new ValueDataEntry(3.5, 73));
        data.add(new ValueDataEntry(4, 70));
        data.add(new ValueDataEntry(3.7, 83));
        data.add(new ValueDataEntry(1.7, 50));
        data.add(new ValueDataEntry(4.6, 95));
        data.add(new ValueDataEntry(1.7, 51));
        data.add(new ValueDataEntry(4, 82));
        data.add(new ValueDataEntry(1.8, 54));
        data.add(new ValueDataEntry(4.4, 83));
        data.add(new ValueDataEntry(1.9, 51));
        data.add(new ValueDataEntry(4.6, 80));
        data.add(new ValueDataEntry(2.9, 78));
        data.add(new ValueDataEntry(3.5, 81));
        data.add(new ValueDataEntry(2, 53));
        data.add(new ValueDataEntry(4.3, 89));
        data.add(new ValueDataEntry(1.8, 44));
        data.add(new ValueDataEntry(4.1, 78));
        data.add(new ValueDataEntry(1.8, 61));
        data.add(new ValueDataEntry(4.7, 73));
        data.add(new ValueDataEntry(4.2, 75));
        data.add(new ValueDataEntry(3.9, 73));
        data.add(new ValueDataEntry(4.3, 76));
        data.add(new ValueDataEntry(1.8, 55));
        data.add(new ValueDataEntry(4.5, 86));
        data.add(new ValueDataEntry(2, 48));
        data.add(new ValueDataEntry(4.2, 77));
        data.add(new ValueDataEntry(4.4, 73));
        data.add(new ValueDataEntry(4.1, 70));
        data.add(new ValueDataEntry(4.1, 88));
        data.add(new ValueDataEntry(4, 75));
        data.add(new ValueDataEntry(4.1, 83));
        data.add(new ValueDataEntry(2.7, 61));
        data.add(new ValueDataEntry(4.6, 78));
        data.add(new ValueDataEntry(1.9, 61));
        data.add(new ValueDataEntry(4.5, 81));
        data.add(new ValueDataEntry(2, 51));
        data.add(new ValueDataEntry(4.8, 80));
        data.add(new ValueDataEntry(4.1, 79));
        data.add(new ValueDataEntry(4.1, 82));
        data.add(new ValueDataEntry(4.2, 80));
        data.add(new ValueDataEntry(4.5, 76));
        data.add(new ValueDataEntry(1.9, 56));
        data.add(new ValueDataEntry(4.7, 82));
        data.add(new ValueDataEntry(2, 47));
        data.add(new ValueDataEntry(4.7, 76));
        data.add(new ValueDataEntry(2.5, 61));
        data.add(new ValueDataEntry(4.3, 75));
        data.add(new ValueDataEntry(4.4, 72));
        data.add(new ValueDataEntry(4.4, 74));
        data.add(new ValueDataEntry(4.3, 69));
        data.add(new ValueDataEntry(4.6, 78));
        data.add(new ValueDataEntry(2.1, 52));
        data.add(new ValueDataEntry(4.8, 91));
        data.add(new ValueDataEntry(4.1, 66));
        data.add(new ValueDataEntry(4, 71));
        data.add(new ValueDataEntry(4, 75));
        data.add(new ValueDataEntry(4.4, 81));
        data.add(new ValueDataEntry(4.1, 77));
        data.add(new ValueDataEntry(4.3, 74));
        data.add(new ValueDataEntry(4, 70));
        data.add(new ValueDataEntry(3.9, 83));
        data.add(new ValueDataEntry(3.2, 53));
        data.add(new ValueDataEntry(4.5, 82));
        data.add(new ValueDataEntry(2.2, 62));
        data.add(new ValueDataEntry(4.7, 73));
        data.add(new ValueDataEntry(4.6, 84));
        data.add(new ValueDataEntry(2.2, 58));
        data.add(new ValueDataEntry(4.8, 82));
        data.add(new ValueDataEntry(4.3, 77));
        data.add(new ValueDataEntry(3.8, 75));
        data.add(new ValueDataEntry(4, 77));
        data.add(new ValueDataEntry(4.1, 77));
        data.add(new ValueDataEntry(1.8, 53));
        data.add(new ValueDataEntry(4.4, 75));
        data.add(new ValueDataEntry(4, 78));
        data.add(new ValueDataEntry(2.2, 51));
        data.add(new ValueDataEntry(5.1, 81));
        data.add(new ValueDataEntry(1.9, 52));
        data.add(new ValueDataEntry(5, 76));
        data.add(new ValueDataEntry(4.4, 73));
        data.add(new ValueDataEntry(4.5, 84));
        data.add(new ValueDataEntry(3.8, 72));
        data.add(new ValueDataEntry(4.3, 89));
        data.add(new ValueDataEntry(4.4, 75));
        data.add(new ValueDataEntry(2.2, 57));
        data.add(new ValueDataEntry(4.8, 81));
        data.add(new ValueDataEntry(1.9, 49));
        data.add(new ValueDataEntry(4.7, 87));
        data.add(new ValueDataEntry(1.8, 43));
        data.add(new ValueDataEntry(4.8, 94));
        data.add(new ValueDataEntry(2, 45));
        data.add(new ValueDataEntry(4.4, 81));
        data.add(new ValueDataEntry(2.5, 59));
        data.add(new ValueDataEntry(4.3, 82));
        data.add(new ValueDataEntry(4.4, 80));
        data.add(new ValueDataEntry(1.9, 54));
        data.add(new ValueDataEntry(4.7, 75));
        data.add(new ValueDataEntry(4.3, 73));
        data.add(new ValueDataEntry(2.2, 57));
        data.add(new ValueDataEntry(4.7, 80));
        data.add(new ValueDataEntry(2.3, 51));
        data.add(new ValueDataEntry(4.6, 77));
        data.add(new ValueDataEntry(3.3, 66));
        data.add(new ValueDataEntry(4.2, 77));
        data.add(new ValueDataEntry(2.9, 60));
        data.add(new ValueDataEntry(4.6, 86));
        data.add(new ValueDataEntry(3.3, 62));
        data.add(new ValueDataEntry(4.2, 75));
        data.add(new ValueDataEntry(2.6, 67));
        data.add(new ValueDataEntry(4.6, 69));
        data.add(new ValueDataEntry(3.7, 84));
        data.add(new ValueDataEntry(1.8, 58));
        data.add(new ValueDataEntry(4.7, 90));
        data.add(new ValueDataEntry(4.5, 82));
        data.add(new ValueDataEntry(4.5, 71));
        data.add(new ValueDataEntry(4.8, 80));
        data.add(new ValueDataEntry(2, 51));
        data.add(new ValueDataEntry(4.8, 80));
        data.add(new ValueDataEntry(1.9, 62));
        data.add(new ValueDataEntry(4.7, 84));
        data.add(new ValueDataEntry(2, 51));
        data.add(new ValueDataEntry(5.1, 81));
        data.add(new ValueDataEntry(4.3, 83));
        data.add(new ValueDataEntry(4.8, 84));
        data.add(new ValueDataEntry(3, 72));
        data.add(new ValueDataEntry(2.1, 54));
        data.add(new ValueDataEntry(4.6, 75));
        data.add(new ValueDataEntry(4, 74));
        data.add(new ValueDataEntry(2.2, 51));
        data.add(new ValueDataEntry(5.1, 91));
        data.add(new ValueDataEntry(2.9, 60));
        data.add(new ValueDataEntry(4.3, 80));
        data.add(new ValueDataEntry(2.1, 54));
        data.add(new ValueDataEntry(4.7, 80));
        data.add(new ValueDataEntry(4.5, 70));
        data.add(new ValueDataEntry(1.7, 60));
        data.add(new ValueDataEntry(4.2, 86));
        data.add(new ValueDataEntry(4.3, 78));
        data.add(new ValueDataEntry(1.7, 51));
        data.add(new ValueDataEntry(4.4, 83));
        data.add(new ValueDataEntry(4.2, 76));
        data.add(new ValueDataEntry(2.2, 51));
        data.add(new ValueDataEntry(4.7, 90));
        data.add(new ValueDataEntry(4, 71));
        data.add(new ValueDataEntry(1.8, 49));
        data.add(new ValueDataEntry(4.7, 88));
        data.add(new ValueDataEntry(1.8, 52));
        data.add(new ValueDataEntry(4.5, 79));
        data.add(new ValueDataEntry(2.1, 61));
        data.add(new ValueDataEntry(4.2, 81));
        data.add(new ValueDataEntry(2.1, 48));
        data.add(new ValueDataEntry(5.2, 84));
        data.add(new ValueDataEntry(2, 63));

        return data;
    }
}
