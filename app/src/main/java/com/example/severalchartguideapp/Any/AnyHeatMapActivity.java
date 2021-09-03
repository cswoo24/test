package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.HeatDataEntry;
import com.anychart.charts.HeatMap;
import com.anychart.enums.SelectionMode;
import com.anychart.graphics.vector.SolidFill;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/HeatMapChartActivity.java
public class AnyHeatMapActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyheatmap);

        AnyChartView anyChartView = findViewById(R.id.any_heat_map);

        HeatMap riskMap = AnyChart.heatMap();

        riskMap.stroke("1 #fff"); // 맵의 두께 색
        riskMap.hovered() // 칸 클릭할 때
                .stroke("6 #fff") // 클릭한 칸의 테두리 두께, 색
                .fill(new SolidFill("#545f69", 1d)) // 선택된 칸의 색, 불투명도
                .labels("{ fontColor: '#fff' }"); // 라벨 색

        riskMap.interactivity().selectionMode(SelectionMode.NONE);

        riskMap.title().enabled(true); // 맵 제목 사용여부
        riskMap.title() // 맵 제목 설정
                .text("Risk Matrix in Project Server")
                .padding(0d, 0d, 20d, 0d);

        riskMap.labels().enabled(true); // 라벨 사용 여부
        riskMap.labels()
                .minFontSize(14d) /// 최소 글자 크기
                .format("function() {\n" +
                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
                        "      return namesList[this.heat];\n" +
                        "    }");

        riskMap.yAxis(0).stroke(null); // Y축 테두리 없음
        riskMap.yAxis(0).labels().padding(0d, 15d, 0d, 0d); // Y축 라벨 위치
        riskMap.yAxis(0).ticks(false); // Y축 보조선 사용 여부
        riskMap.xAxis(0).stroke(null); // X축 테두리 없음
        riskMap.xAxis(0).ticks(false); // X축 보조선 사용 여부

        riskMap.tooltip().title().useHtml(true); // tooltip 제목에서 html 속성 사용여부
        riskMap.tooltip()
                .useHtml(true) // html 속성 사용
                .titleFormat("function() {\n" +
                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
                        "      return '<b>' + namesList[this.heat] + '</b> Residual Risk';\n" +
                        "    }")
                .format("function () {\n" +
                        "       return '<span style=\"color: #CECECE\">Likelihood: </span>' + this.x + '<br/>' +\n" +
                        "           '<span style=\"color: #CECECE\">Consequence: </span>' + this.y;\n" +
                        "   }");

        List<DataEntry> data = new ArrayList<>(); // data
        data.add(new CustomHeatDataEntry("Rare", "Insignificant", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Rare", "Minor", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Rare", "Moderate", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Rare", "Major", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Rare", "Extreme", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Unlikely", "Insignificant", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Unlikely", "Minor", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Unlikely", "Moderate", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Unlikely", "Major", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Unlikely", "Extreme", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Possible", "Insignificant", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Possible", "Minor", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Possible", "Moderate", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Possible", "Major", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Possible", "Extreme", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Likely", "Insignificant", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Likely", "Minor", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Likely", "Moderate", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Likely", "Major", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("Likely", "Extreme", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("Almost\\nCertain", "Insignificant", 0, "#90caf9"));
        data.add(new CustomHeatDataEntry("Almost\\nCertain", "Minor", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Almost\\nCertain", "Moderate", 1, "#ffb74d"));
        data.add(new CustomHeatDataEntry("Almost\\nCertain", "Major", 2, "#ef6c00"));
        data.add(new CustomHeatDataEntry("Almost\\nCertain", "Extreme", 3, "#d84315"));

        riskMap.data(data);


        anyChartView.setChart(riskMap);
    }

    private class CustomHeatDataEntry extends HeatDataEntry {
        CustomHeatDataEntry(String x, String y, Integer heat, String fill) {
            super(x, y, heat);
            setValue("fill", fill);
        }
    }
}

