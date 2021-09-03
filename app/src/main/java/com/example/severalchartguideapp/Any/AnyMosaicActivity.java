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
import com.anychart.enums.TooltipDisplayMode;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/MosaicChartActivity.java
public class AnyMosaicActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anymosaic);

        AnyChartView anyChartView = findViewById(R.id.any_mosaic_chart);

        Mekko mosaic = AnyChart.mosaic();

        mosaic.title("Skills and Self-ID Top Factors");

        Set set = Set.instantiate();
        set.data(data());
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Data = set.mapAs("{ x: 'x', value: 'value4' }");
        Mapping series5Data = set.mapAs("{ x: 'x', value: 'value5' }");

        mosaic.mekko(series1Data)
                .name("Business");

        mosaic.mekko(series2Data)
                .name("ML/Big Data");

        mosaic.mekko(series3Data)
                .name("Math/OR");

        mosaic.mekko(series4Data)
                .name("Programming")
        .color("#090");

        mosaic.mekko(series5Data)
                .name("Statistics");

        mosaic.legend().enabled(true)
                .position("bottom")
                .padding(15d,15d,15d,30d);

        mosaic.xAxis(0).orientation(Orientation.TOP);
        mosaic.tooltip().displayMode(TooltipDisplayMode.UNION); // 모든 데이터 같이 보기

        anyChartView.setChart(mosaic);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomDataEntry("Data Businessperson", 50, 15, 10, 5, 25));
        data.add(new CustomDataEntry("Data Creative", 17, 23, 10, 20, 30));
        data.add(new CustomDataEntry("Data Developer", 17, 25, 16, 27, 15));
        data.add(new CustomDataEntry("Data Researcher", 12, 12, 17, 5, 51));

        return data;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }
}
