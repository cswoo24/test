package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Radar;
import com.anychart.core.radar.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Align;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/RadarChartActivity.java
public class AnyRadarActivity extends AnyChartActivity{

    AnyChartView anyRadarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyradar);

        anyRadarChart = findViewById(R.id.any_radar_chart);

        Radar radar = AnyChart.radar();

        radar.animation(true);

        radar.title("WoW base stats comparison radar chart: Shaman vs Warrior vs Priest");

        radar.yScale().minimum(0d);
        radar.yScale().minimumGap(0d); // Y축 scale minimum이 사용되지 않을 경우 동작함
        radar.yScale().ticks().interval(50d); // Y축 간격

        radar.xAxis().labels().padding(5d, 5d, 5d, 5d);

        radar.legend()
                .align(Align.CENTER)
                .enabled(true);

        Set set = Set.instantiate();
        set.data(dataValues1());
        Mapping shamanData = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping warriorData = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping priestData = set.mapAs("{ x: 'x', value: 'value3' }");

        Line shamanLine = radar.line(shamanData);
        shamanLine.name("Shaman");
        shamanLine.markers()
                .enabled(true) // 마커 표시 여부
                .type(MarkerType.DIAGONAL_CROSS) // 차트 로딩됐을 때 보이는 마커 모양
                .size(8d); // 마커 크기

        Line warriorLine = radar.line(warriorData);
        warriorLine.name("Warrior");
        warriorLine.color("#00cc00");
        warriorLine.markers()
                .enabled(true)
                .type(MarkerType.STAR5)
                .size(8d);

        Line priestLine = radar.line(priestData);
        priestLine.name("Priest");
        priestLine.markers()
                .enabled(true)
                .type(MarkerType.PENTAGON)
                .size(8d);

        radar.tooltip()
                .positionMode(TooltipPositionMode.POINT)
                .position("right")
                .anchor(Anchor.LEFT_CENTER) // 중앙 기준으로 tooltip 박스 위치
                .format("Value: {%Value}")
                .fontSize(15d);

        anyRadarChart.setChart(radar);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        List<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("Strength", 136, 199, 43));
        datavals.add(new CustomDataEntry("Agility", 79, 125, 56));
        datavals.add(new CustomDataEntry("Stamina", 149, 173, 101));
        datavals.add(new CustomDataEntry("Intellect", 135, 33, 202));
        datavals.add(new CustomDataEntry("Spirit", 158, 64, 196));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }
    }
}
