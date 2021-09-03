package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pareto;
import com.anychart.core.cartesian.series.Base;
import com.anychart.enums.Anchor;
import com.anychart.graphics.vector.StrokeLineCap;
import com.anychart.graphics.vector.StrokeLineJoin;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/ParetoChartActivity.java
public class AnyParetoActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anypareto);

        AnyChartView anyChartView = findViewById(R.id.any_pareto_chart);

        Pareto pareto = AnyChart.pareto();

        pareto.data(data());

        pareto.title("Pareto Chart of Restaurant Complaints");

        pareto.yAxis(0d).title("Defect frequency"); // 왼쪽 Y축 타이틀

        pareto.yAxis(1d).title("Cumulative Percentage"); // 오른쪽 Y축 타이틀

        pareto.animation(true);

        pareto.lineMarker(0) // 라인마커(점선) 표시
                .value(75d) // 오른쪽 Y축 값
                .axis(pareto.yAxis(1d)) // 점선 위치
                .stroke("#A5B3B3", 1d, "5 10", StrokeLineJoin.ROUND, StrokeLineCap.ROUND); // 점선 설정

        pareto.getSeries(0d).tooltip().format("Value: {%Value}"); // column chart(막대) tolltip 포맷(클릭 시 data값 출력)

        Base line = pareto.getSeries(1d); // line chart
        line.seriesType("spline") // 부드러운 line type
                .markers(true); // 마커 표시
        line.labels().enabled(true); // 라벨 값 표시 여부
        line.labels()
                .anchor(Anchor.RIGHT_BOTTOM)
                .format("{%CF}%");
        line.tooltip().format("Cumulative Frequency: {%CF}% \\n Relative Frequency: {%RF}%");

        pareto.crosshair().enabled(true); // 크로스헤어(선택했을 때 라인 보이는 것) 설정
        pareto.crosshair().xLabel(true);

        anyChartView.setChart(pareto);

    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry("Food is tasteless", 65));
        data.add(new ValueDataEntry("Wait time", 109));
        data.add(new ValueDataEntry("Unfriendly staff", 12.5));
        data.add(new ValueDataEntry("Not clean", 45));
        data.add(new ValueDataEntry("Overpriced", 250));
        data.add(new ValueDataEntry("To noisy", 27));
        data.add(new ValueDataEntry("Food not fresh", 35));
        data.add(new ValueDataEntry("Small portions", 170));
        data.add(new ValueDataEntry("Not atmosphere", 35));
        data.add(new ValueDataEntry("Food is to salty", 35));

        return data;
    }
}
