package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.TooltipPositionMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/Bar3DChartActivity.java
public class AnyBar3DActivity extends AnyChartActivity{

    AnyChartView anyBar3DChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anybar3d);

        anyBar3DChart = findViewById(R.id.any_bar3d_chart);

        Cartesian3d bar3d = AnyChart.bar3d();

        bar3d.animation(true); // 애니메이션 여부

        bar3d.padding(10d, 40d, 5d, 20d); // 차트 위치

        bar3d.title("Top 3 Products with Region Sales Data");

        bar3d.yScale().minimum(0d); // Y축 최소값

        bar3d.xAxis(0).labels()
                .rotation(-90d) // X축 라벨 회전 설정
                .padding(0d, 0d, 20d, 0d); //  X축 라벨 위치

        bar3d.yAxis(0).labels().format("${%Value}{groupsSeparator: }"); // Y축 라벨 포맷

        bar3d.yAxis(0).title("Revenue in Dollars");

        Set set = Set.instantiate();
        set.data(dataValues1());
        Mapping bar1Data = set.mapAs("{ x: 'x', value: 'value' }"); // 데이터 값 매핑
        Mapping bar2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping bar3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping bar4Data = set.mapAs("{ x: 'x', value: 'value4' }");

        bar3d.bar(bar1Data)
                .name("Florida"); // 데이터그룹 이름 설정

        bar3d.bar(bar2Data)
                .name("Texas");

        bar3d.bar(bar3Data)
                .name("Arizona");

        bar3d.bar(bar4Data)
                .name("Nevada");

        bar3d.legend().enabled(true); // 범례 보기 설정
        bar3d.legend().fontSize(13d);
        bar3d.legend().padding(0d, 0d, 20d, 0d);

        bar3d.interactivity().hoverMode(HoverMode.SINGLE);

        bar3d.tooltip()
                .positionMode(TooltipPositionMode.POINT)
                .position("right")
                .anchor(Anchor.LEFT_CENTER) // 중앙 기준으로 tooltip 박스 위치
                .offsetX(5d)
                .offsetY(0d)
                .format("${%Value}");

        bar3d.zAspect("10%") // 깊이 정도
                .zPadding(20d) // Z축 간 간격(0이면 그래프 간격 없음)
                .zAngle(45d) // 깊이의 각도 (90: 평면)
                .zDistribution(true); // Z축 분포 활성화(false : 그냥 그룹column 차트)

        anyBar3DChart.setChart(bar3d);
    }

    private List<DataEntry> dataValues1() { // Column Chart Data 생성
        List<DataEntry> datavals = new ArrayList<>();

        datavals.add(new CustomDataEntry("Nail polish", 6229, 4376, 4054, 2381));
        datavals.add(new CustomDataEntry("Eyebrow pencil", 9332, 8987, 5067, 1401));
        datavals.add(new CustomDataEntry("Lipstick", 9256, 7376, 5054, 981));

        return datavals;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
        }
    }
}
