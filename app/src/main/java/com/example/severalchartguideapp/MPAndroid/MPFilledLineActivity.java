package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/FilledLineActivity.java
public class MPFilledLineActivity extends MPAndroidChartActivity {

    private LineChart mpfilledlinechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpfilledline);

        mpfilledlinechart = findViewById(R.id.filled_line_chart);

         // linedata1, linedata2 : random data//
        mpfilledlinechart.setBackgroundColor(Color.YELLOW); // 배경색
        mpfilledlinechart.setGridBackgroundColor(Color.CYAN); // 데이터 사이의 그리드 색
        mpfilledlinechart.setDrawGridBackground(true); //그리드 색 사용 여부

        mpfilledlinechart.setDrawBorders(true); // 차트 테두리선 사용

        // no description text
        mpfilledlinechart.getDescription().setEnabled(false); // 하단 오른쪽 문구 표시 여부

        // if disabled, scaling can be done on x- and y-axis separately
        mpfilledlinechart.setPinchZoom(false);

        Legend l = mpfilledlinechart.getLegend(); // 범례
        l.setEnabled(true);

        XAxis xAxis = mpfilledlinechart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE); // X축 위치

        YAxis leftAxis = mpfilledlinechart.getAxisLeft();
        leftAxis.setAxisMaximum(900f); // Y축 최대값
        leftAxis.setAxisMinimum(-250f); // Y축 최소값
        leftAxis.setDrawAxisLine(false); //
        leftAxis.setDrawZeroLine(true); // Y축 zero 축 표시 여부. dataset에서 색 없어야 보임
        leftAxis.setDrawGridLines(true); // Y축 그리드 선 표시

        mpfilledlinechart.getAxisRight().setEnabled(false); // 오른쪽 Y축 표시 여부

        // add data
        setData(100, 60);// data 수, 범위

        mpfilledlinechart.invalidate();
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values1 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 50;
            values1.add(new Entry(i, val));
        }

        ArrayList<Entry> values2 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 450;
            values2.add(new Entry(i, val));
        }

        LineDataSet set1, set2;

        if (mpfilledlinechart.getData() != null &&
                mpfilledlinechart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mpfilledlinechart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet) mpfilledlinechart.getData().getDataSetByIndex(1);
            set1.setValues(values1);
            set2.setValues(values2);
            mpfilledlinechart.getData().notifyDataChanged(); //차트데이터가 변경되었음을 알리 때 호출. 호출 시 데이터가 변경됐을 때 필요한 모든 재계산 작업 수행
            mpfilledlinechart.notifyDataSetChanged(); // 차트에 데이터의 변경을 알리고 필요한 재계산 작업을 수행. 데이터 동적 변경경  이 메소드 호룿
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values1, "DataSet 1");

            set1.setAxisDependency(YAxis.AxisDependency.LEFT); // Y축 위치 설정(왼쪽/오른쪽)
            set1.setColor(Color.rgb(0, 111, 216)); // data 색
            set1.setDrawCircles(false); // 각 데이터에 circle 표시
            set1.setLineWidth(2f); // 라인두께
            set1.setCircleRadius(15f); // 원 크기. 위에서 false 설정
            set1.setFillAlpha(255); // 투명도
            set1.setDrawFilled(true); // 데이터 채우기색 표시 여부
            set1.setFillColor(Color.WHITE);// 데이터 채우기색
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false); //원 가운데 hole(빈 동심원)
            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) { //
                    // change the return value here to better understand the effect
                    // return 0;
                    return mpfilledlinechart.getAxisLeft().getAxisMinimum();
                }
            });

            // create a dataset and give it a type
            set2 = new LineDataSet(values2, "DataSet 2");
            set2.setAxisDependency(YAxis.AxisDependency.LEFT);
            set2.setColor(Color.rgb(255, 241, 46));
            set2.setDrawCircles(false);
            set2.setLineWidth(2f);
            set2.setCircleRadius(3f);
            set2.setFillAlpha(255);
            set2.setDrawFilled(true);
            set2.setFillColor(Color.WHITE);
            set2.setDrawCircleHole(false);
            set2.setHighLightColor(Color.rgb(244, 117, 117));
            set2.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    // change the return value here to better understand the effect
                    // return 600;
                    return mpfilledlinechart.getAxisLeft().getAxisMaximum();
                }
            });

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets
            dataSets.add(set2);

            // create a data object with the data sets
            LineData data = new LineData(dataSets);
            data.setDrawValues(true); // value 값 표시
            data.setValueTextSize(15f); // value값 글자크기

            // set data
            mpfilledlinechart.setData(data);
        }
    }
}
