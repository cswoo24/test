package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.NameValueDataEntry;
import com.anychart.charts.Venn;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/VennDiagramActivity.java
public class AnyVennDiagramActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyvenndiagram);

        AnyChartView anyChartView = findViewById(R.id.any_venndiagram);

        Venn venn = AnyChart.venn();

        venn.data(data());

        venn.stroke("2 #FFFFFF"); // 벤 다이어그램 안쪽 둘레 선 두께,색

        venn.labels().format("{%Name}"); // 라벨 포맷(교집합 제외)
        //venn.labels().fontColor("#f30");

        venn.intersections().hovered().fill("black", 0.25d); // 클릭했을 때 색, 불투명도

        venn.intersections().labels().fontWeight("bold"); // 라벨 글씨 굵기
        venn.intersections().labels().format("{%Name}"); // 라벨 포맷(모집합 제외)
       // venn.intersections().labels().fontColor("#000");

        venn.tooltip().titleFormat("{%Name}"); // tooltip 제목 포맷

        anyChartView.setChart(venn);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new NameValueDataEntry("A", "Data Science", 100));
        data.add(new NameValueDataEntry("B", "Computer Science", 25));
        data.add(new NameValueDataEntry("C", "Math and Statistics", 25));
        data.add(new NameValueDataEntry("D", "Subject Matter Expertise", 25));
        data.add(new NameValueDataEntry("A&B", "Computer Science", 50));
        data.add(new NameValueDataEntry("A&C", "Math and Statistics", 50));
        data.add(new NameValueDataEntry("A&D", "Subject Matter Expertise", 50));
        data.add(new NameValueDataEntry("B&C", "Machine\\nLearning", 5));
        data.add(new NameValueDataEntry("C&D", "Traditional\\nResearch", 5));
        data.add(new NameValueDataEntry("D&B", "Traditional\\nSoftware", 5));
        data.add(new NameValueDataEntry("B&C&D", "Unicorn", 5));

        return data;
    }
}
