package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/LineChartActivityColored.java
public class MPLineColoredActivity extends MPAndroidChartActivity {

    private final LineChart[] mplinecoloredchart = new LineChart[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplinecolored);

        mplinecoloredchart[0] = findViewById(R.id.chart1);
        mplinecoloredchart[1] = findViewById(R.id.chart2);
        mplinecoloredchart[2] = findViewById(R.id.chart3);
        mplinecoloredchart[3] = findViewById(R.id.chart4);

        for (int i = 0; i < mplinecoloredchart.length; i++) {

            LineData data = getData(36, 100);

            // add some transparency to the color with "& 0x90FFFFFF"
            setupChart(mplinecoloredchart[i], data, colors[i % colors.length]); // data setting & invalidate
        }
    }

    private final int[] colors = new int[] { // chart별 색 정의
            Color.rgb(137, 230, 81),
            Color.rgb(240, 240, 30),
            Color.rgb(89, 199, 250),
            Color.rgb(250, 104, 104)
    };

    private void setupChart(LineChart chart, LineData data, int color) {

        ((LineDataSet) data.getDataSetByIndex(0)).setCircleHoleColor(color);

        // no description text
        chart.getDescription().setEnabled(false);

        // chart.setDrawHorizontalGrid(false);
        //
        // enable / disable grid background
        chart.setDrawGridBackground(false);
//        chart.getRenderer().getGridPaint().setGridColor(Color.WHITE & 0x70FFFFFF);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setBackgroundColor(color); // 배경색 설정

        // set custom chart offsets (automatic offset calculation is hereby disabled)
        chart.setViewPortOffsets(10, 0, 10, 0); // 오프셋 자동 설정 취소(커스텀 오프셋)

        // add data
        chart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = chart.getLegend(); // 범례 설정
        l.setEnabled(false);

        chart.getAxisLeft().setEnabled(false); // 왼쪽 Y축 설정
        chart.getAxisLeft().setSpaceTop(40);
        chart.getAxisLeft().setSpaceBottom(40);
        chart.getAxisRight().setEnabled(false);

        chart.getXAxis().setEnabled(false); // X축 설정

        // animate calls invalidate()...
        chart.animateX(2500); // 애니메이션
        chart.invalidate();
    }

    private LineData getData(int count, float range) { // 데이터 가져올 때 기본 설정

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "DataSet 1");
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        set1.setLineWidth(1.75f); // 라인너비
        set1.setCircleRadius(5f); // 원 반지름
        set1.setCircleHoleRadius(2.5f); // 원 안의 동심원 반지름
        set1.setColor(Color.WHITE); // 라인색
        set1.setCircleColor(Color.WHITE); // 원 색
        set1.setHighLightColor(Color.BLACK); // chart클릭 시 나오는 highlight 색 설정
        set1.setDrawValues(false); // value값 표시 여부

        // create a data object with the data sets
        return new LineData(set1);
    }
}
