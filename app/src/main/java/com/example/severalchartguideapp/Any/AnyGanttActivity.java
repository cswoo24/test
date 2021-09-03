package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Gantt;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/GanttChartActivity.java
public class AnyGanttActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anygantt);

        AnyChartView anyChartView = findViewById(R.id.any_gantt_chart);

        // 데이터 넣는 함수 생성 필요. 기존 라이브러리에 넣는 것 없음 bubblemap 밑에 참조
        // anychart/src/main/java/com/anychart/scales/GanttDateTime.java

        Gantt gantt = AnyChart.ganttProject();
        gantt.splitterPosition(320d);

        //gantt.data(data());



        anyChartView.setChart(gantt);
    }
/*
    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomDataEntry("Phase 1 - Strategic Plan", 1);
                //0.14,"2000-02-24", "2000-03-28T09:00" );

        data.add( );
        data.add(new ValueDataEntry("Valid Contacts", 112167));
        data.add(new ValueDataEntry("Interested to Buy", 79128));
        data.add(new ValueDataEntry("Purchased", 79128));

        return data;
    }

    private class CustomDataEntry  {
        public CustomDataEntry(String x, Number value, Number value2, Number value3, Date value4, Date value5) {
            setValue(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }*/
}
