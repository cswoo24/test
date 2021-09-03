package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.RangeColumn;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/RangeChartActivity.java
public class AnyRangeActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyrange);

        AnyChartView anyChartView = findViewById(R.id.any_range_chart);

        Cartesian cartesian = AnyChart.cartesian();

        cartesian.title("Coastal Water Temperature \\nin London vs edinburgh in 2015 (°C)");

        Set set = Set.instantiate();
        set.data(data());
        Mapping londonData = set.mapAs("{ x: 'x', high: 'londonHigh', low: 'londonLow' }"); // x값 각각의 londonHigh,londonLow value를  그래프의 high와 low로 mapping(name:londondata)
        Mapping edinburghData = set.mapAs("{ x: 'x', high: 'edinburghHigh', low: 'edinburghLow' }");

        RangeColumn columnLondon = cartesian.rangeColumn(londonData); // mapping data를 series로
        columnLondon.name("London"); // series name

        RangeColumn columnedinburgh = cartesian.rangeColumn(edinburghData);
        columnedinburgh.name("edinburgh");

        cartesian.xAxis(true); // X축 show
        cartesian.yAxis(true); // Y축 show

        cartesian.yScale()
                .minimum(4d) // Y축 최소값
                .maximum(20d); // Y축 최대값

        cartesian.legend(true); // 범례

        cartesian.yGrid(true) // Y축 그리드 선 show
                .yMinorGrid(true); // Y축 보조 그리드 선 show

        cartesian.tooltip().titleFormat("{%SeriesName} ({%x})"); // tooltip 제목 포맷맷
        anyChartView.setChart(cartesian);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomDataEntry("Jan", 5.8, 7.9, 6.1, 8.9));
        data.add(new CustomDataEntry("Feb", 4.6, 6.1, 5.5, 8.2));
        data.add(new CustomDataEntry("Mar", 5.9, 8.1, 5.9, 8.1));
        data.add(new CustomDataEntry("Apr", 7.8, 10.7, 7.1, 9.8));
        data.add(new CustomDataEntry("May", 10.5, 13.7, 8.3, 10.7));
        data.add(new CustomDataEntry("June", 13.8, 17, 10.7, 14.5));
        data.add(new CustomDataEntry("July", 16.5, 18.5, 12.3, 16.7));
        data.add(new CustomDataEntry("Aug", 17.8, 19, 14, 16.3));
        data.add(new CustomDataEntry("Sep", 15.4, 17.8, 13.7, 15.3));
        data.add(new CustomDataEntry("Oct", 12.7, 15.3, 12.3, 14.4));
        data.add(new CustomDataEntry("Nov", 9.8, 13, 12.9, 10.7));
        data.add(new CustomDataEntry("Dec", 9, 10.1, 8.2, 11.1));

        return data;
    }

    private class CustomDataEntry extends DataEntry {
        public CustomDataEntry(String x, Number edinburghHigh, Number edinburghLow, Number londonHigh, Number londonLow) {
            setValue("x", x);
            setValue("edinburghHigh", edinburghHigh);
            setValue("edinburghLow", edinburghLow);
            setValue("londonHigh", londonHigh);
            setValue("londonLow", londonLow);
        }
    }
}
