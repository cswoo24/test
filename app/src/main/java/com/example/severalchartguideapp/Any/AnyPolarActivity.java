package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Polar;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.PolarSeriesType;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.ScaleTypes;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.scales.Linear;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/PolarChartActivity.java
public class AnyPolarActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anypolor);

        AnyChartView anyChartView = findViewById(R.id.any_polar_chart);

        Polar polar = AnyChart.polar();

        Set set = Set.instantiate();
        set.data(data());
        // 각 value 별로 Serise mapping 후 컬럼별로 넣음
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");

        polar.column(series1Data);

        polar.column(series2Data);

        polar.column(series3Data);

        polar.title("Company Profit Dynamic in Regions by Year");

        polar.sortPointsByX(true) // X 별로 분류
                .defaultSeriesType(PolarSeriesType.COLUMN)
                .yAxis(false) // Y축 없음
               .xScale(ScaleTypes.ORDINAL); // scale 지정.(first, second..  서수)

        polar.title().margin().bottom(20d);

        ((Linear) polar.yScale(Linear.class)).stackMode(ScaleStackMode.VALUE); // Yscale =  데이터값으로 (log나 date 아님)

        polar.tooltip()
                .valuePrefix("$") // value 앞에 $ 표시
                .displayMode(TooltipDisplayMode.UNION); // 같은 축 data 다 같이 보기

        polar.legend() // 범례 설정
                .enabled(true)
                .position("bottom");

        anyChartView.setChart(polar);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomDataEntry("Nail polish", 12814, 4376, 4229));
        data.add(new CustomDataEntry("Eyebrow pencil", 13012, 3987, 3932));
        data.add(new CustomDataEntry("Rouge", 11624, 3574, 5221));
        data.add(new CustomDataEntry("Pomade", 8814, 4376, 9256));
        data.add(new CustomDataEntry("Eyeshadows", 12998, 4572, 3308));
        data.add(new CustomDataEntry("Eyeliner", 12321, 3417, 5432));
        data.add(new CustomDataEntry("Foundation", 10342, 5231, 13701));
        data.add(new CustomDataEntry("Lip gloss", 22998, 4572, 4008));
        data.add(new CustomDataEntry("Mascara", 11261, 6134, 18712));
        data.add(new CustomDataEntry("Powder", 10261, 5134, 25712));

        return data;
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }
    }
}
