package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;


import java.util.ArrayList;
import java.util.List;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/BarChartPositiveNegative.java
public class MPBarPosNegActivity extends MPAndroidChartActivity {

    private BarChart mpbarposnegchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpbarposneg);

        mpbarposnegchart = findViewById(R.id.mp_bar_posneg_chart);

        mpbarposnegchart.setBackgroundColor(Color.LTGRAY); // chart 밖 background 색
        mpbarposnegchart.setExtraTopOffset(-30f); // chart top 위치
        mpbarposnegchart.setExtraBottomOffset(10f); // chart bottom 위치
        mpbarposnegchart.setExtraLeftOffset(50f); // chart left 위치
        mpbarposnegchart.setExtraRightOffset(50f); // chart right 위치

        mpbarposnegchart.setDrawBarShadow(false); // bar 그림자
        mpbarposnegchart.setDrawValueAboveBar(true); // bar 위, 아래에 data값 표시

        mpbarposnegchart.getDescription().setEnabled(false); // chart 하단 우측 문구 출력

        // scaling can now only be done on x- and y-axis separately
        mpbarposnegchart.setPinchZoom(true);

        mpbarposnegchart.setDrawGridBackground(true); // grid 색 여부. false일 경우 setBackgroundColor와 연동

        XAxis xAxis = mpbarposnegchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X축 위치
        xAxis.setDrawGridLines(true); // X축에 대한 grid line 그리기(세로선)
        xAxis.setDrawAxisLine(true);
        xAxis.setTextColor(Color.LTGRAY); // 글자색
        xAxis.setTextSize(13f); // 글자크기
        xAxis.setLabelCount(10); // X축 라벨 수. 데이터보다 숫자 크면 데이터만큼 보임
        xAxis.setCenterAxisLabels(false);
        xAxis.setGranularity(1f); // X축을 어느 정도로 자세하게 볼 수 있는가(세분화?)

        YAxis left = mpbarposnegchart.getAxisLeft();
        left.setDrawLabels(true); // Y축 라벨 표시
        left.setSpaceTop(25f); // Y축 기준으로 chart top과의 거리
        left.setSpaceBottom(25f); // Y축 기준으로 chart bottom과의 거리
        left.setDrawAxisLine(true);
        left.setDrawGridLines(false); // 왼쪽 Y축 그리드 라인 생성 여부
        left.setDrawZeroLine(true); // draw a zero line
        left.setZeroLineColor(Color.GRAY);
        left.setZeroLineWidth(0.7f); // zero line 너비

        mpbarposnegchart.getAxisRight().setEnabled(true); // 오른쪽 Y축 표시
        mpbarposnegchart.getLegend().setEnabled(true); // 볌례 표시


// set data
        setData(dataValues1()); // setData 함수 정의(line 101~142)


    }
    private List<Data> dataValues1() {
        List<Data> datavals = new ArrayList<>();

        datavals.add(new Data(0f, -224.1f, "12-29"));
        datavals.add(new Data(1f, 238.5f, "12-30"));
        datavals.add(new Data(2f, 1280.1f, "12-31"));
        datavals.add(new Data(3f, -442.3f, "01-01"));
        datavals.add(new Data(4f, -2280.1f, "01-02"));

        return datavals;
    }

    private class Data { // Entry에 add할 data 정의

        final String xAxisValue;
        final float yValue;
        final float xValue;

        Data(float xValue, float yValue, String xAxisValue) {
            this.xAxisValue = xAxisValue;
            this.yValue = yValue;
            this.xValue = xValue;
        }
    }

    private void setData(List<Data> dataList) {

        ArrayList<BarEntry> values = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        int green = Color.rgb(110, 190, 102);
        int red = Color.rgb(211, 74, 88);

        for (int i = 0; i < dataList.size(); i++) {

            Data d = dataList.get(i);
            BarEntry entry = new BarEntry(d.xValue, d.yValue);
            values.add(entry);

            // specific colors
            if (d.yValue >= 0)
                colors.add(red);
            else
                colors.add(green);
        }

        BarDataSet set;

        if (mpbarposnegchart.getData() != null &&
                mpbarposnegchart.getData().getDataSetCount() > 0) {
            set = (BarDataSet) mpbarposnegchart.getData().getDataSetByIndex(0);
            set.setValues(values);
            mpbarposnegchart.getData().notifyDataChanged();
            mpbarposnegchart.notifyDataSetChanged();
        } else {
            set = new BarDataSet(values, "Values");
            set.setColors(colors);
            set.setValueTextColors(colors);

            BarData data = new BarData(set);
            data.setValueTextSize(13f);
            data.setBarWidth(0.8f);

            mpbarposnegchart.setData(data);
            mpbarposnegchart.invalidate();
        }
    }
}
