package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Waterfall;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/WaterfallChartActivity.java
public class AnyWaterfallActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anywaterfall);

        // 기존값(이전달 값)을 Absolute, 이번 달 변화량을 Difference로 출력
        AnyChartView anyChartView = findViewById(R.id.any_waterfall_chart);

        Waterfall waterfall = AnyChart.waterfall();

        waterfall.title("ACME corp. Revenue Flow 2017");

        waterfall.yScale().minimum(0d); // Y축 최소값

        waterfall.yAxis(0).labels().format("${%Value}{scale:(1000000)(1)|(mln)}"); // Y축 라벨 포맷
        waterfall.labels().enabled(true); // 차트 전체 라벨 보기
        waterfall.labels().format(
                "function() {\n" +
                        "      if (this['isTotal']) {\n" +
                        "        return anychart.format.number(this.absolute, {\n" +
                        "          scale: true\n" +
                        "        })\n" +
                        "      }\n" +
                        "\n" +
                        "      return anychart.format.number(this.value, {\n" +
                        "        scale: true\n" +
                        "      })\n" +
                        "    }");

        DataEntry end = new DataEntry();
        end.setValue("x", "End");
        end.setValue("isTotal", true);
        data().add(end);
        // 새로운 DataEntry를 만들어서 값 한 개 넣은 후 기존 data에 추가

        waterfall.data(data());

        anyChartView.setChart(waterfall);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry("Start", 23000000));
        data.add(new ValueDataEntry("Jan", 2200000));
        data.add(new ValueDataEntry("Feb", -4600000));
        data.add(new ValueDataEntry("Mar", -9100000));
        data.add(new ValueDataEntry("Apr", 3700000));
        data.add(new ValueDataEntry("May", -2100000));
        data.add(new ValueDataEntry("Jun", 5300000));
        data.add(new ValueDataEntry("Jul", 3100000));
        data.add(new ValueDataEntry("Aug", -1500000));
        data.add(new ValueDataEntry("Sep", 4200000));
        data.add(new ValueDataEntry("Oct", 5300000));
        data.add(new ValueDataEntry("Nov", -1500000));
        data.add(new ValueDataEntry("Dec", 5100000));

        return data;
    }
}
