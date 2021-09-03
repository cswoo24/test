package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Mekko;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Orientation;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/MekkoChartActivity.java
public class AnyMekkoActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anymekko);

        AnyChartView anyChartView = findViewById(R.id.any_mekko_chart);

        Mekko mekkoChart = AnyChart.mekko();

        Set set = Set.instantiate();
        set.data(data());
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");

        mekkoChart.mekko(series1Data) // 차트에 mekko serise 추가
                .name("Phone"); // serise에 이름 add

        mekkoChart.mekko(series2Data)
                .name("Tablet");

        mekkoChart.mekko(series3Data)
                .name("Desktop");

        mekkoChart.mekko(series4Data)
                .name("Laptop");

        mekkoChart.legend().enabled(true);
        mekkoChart.legend().position("bottom")
                .padding(15d,15d,15d,30d);

        mekkoChart.xAxis(0).orientation(Orientation.TOP); // X축 위치

        mekkoChart.labels().format("${%Value}k"); // 라벨 포맷

        mekkoChart.tooltip().format("{%seriesName}: ${%Value}k"); // tooltip 포맷

        anyChartView.setChart(mekkoChart); // chart set and view
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();
        data.add(new CustomDataEntry("Acer", 2254, 1274, 635, 253));
        data.add(new CustomDataEntry("Dell", 1010, 950, 675, 250));
        data.add(new CustomDataEntry("HP", 417, 631, 405, 251));
        data.add(new CustomDataEntry("Lenovo", 210, 307, 450, 257));

        return data;
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
