package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/StackedBarActivityNegative.java
public class MPStackedNegActivity extends MPAndroidChartActivity {

    private HorizontalBarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpstackedneg);

        chart = findViewById(R.id.stack_bar_neg_chart);

        // X축 : 세로, Y축 : 가로

        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setHighlightFullBarEnabled(false);

        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setAxisMaximum(25f); // Y축 최대값
        chart.getAxisRight().setAxisMinimum(-25f); // Y축 최소값
        chart.getAxisRight().setDrawGridLines(false); // 그리드 라인
        chart.getAxisRight().setDrawZeroLine(true); // zero line 여부
        chart.getAxisRight().setLabelCount(7, false); //Y축 라벨 개수
        chart.getAxisRight().setValueFormatter(new CustomFormatter()); // 사용자 정의 value 포맷
        chart.getAxisRight().setTextSize(12f); // Y축 글자 크기

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED); //X축 설정(양쪽)
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(false);
        xAxis.setTextSize(12f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(110f);
        xAxis.setCenterAxisLabels(true); // X 그리드 라인을 데이터 중앙에 배치
        xAxis.setLabelCount(12); // X축 라벨 수
        xAxis.setGranularity(10f); // X축 간격
        xAxis.setValueFormatter(new ValueFormatter() { // X측 value 포맷 설정

            private final DecimalFormat format = new DecimalFormat("###");

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return format.format(value) + "-" + format.format(value + 10);
            }
        });

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false); // 차트 안에 범례 위치 여부
        l.setFormSize(12f);
        l.setFormToTextSpace(4f);
        l.setXEntrySpace(6f);
        l.setYEntrySpace(40f);
        l.setTextSize(12f); // 글자 크기

        // IMPORTANT: When using negative values in stacked bars, always make sure the negative values are in the array first
        ArrayList<BarEntry> values = new ArrayList<>();
        values.add(new BarEntry(5, new float[]{-10, 10}));
        values.add(new BarEntry(15, new float[]{-12, 13}));
        values.add(new BarEntry(25, new float[]{-15, 15}));
        values.add(new BarEntry(35, new float[]{-17, 17}));
        values.add(new BarEntry(45, new float[]{-19, 20}));
        values.add(new BarEntry(45, new float[]{-19, 20}));
        values.add(new BarEntry(55, new float[]{-19, 19}));
        values.add(new BarEntry(65, new float[]{-16, 16}));
        values.add(new BarEntry(75, new float[]{-13, 14}));
        values.add(new BarEntry(85, new float[]{-10, 11}));
        values.add(new BarEntry(95, new float[]{-5, 6}));
        values.add(new BarEntry(105, new float[]{-1, 2}));

        BarDataSet set = new BarDataSet(values, "Age Distribution");
        set.setDrawIcons(false);
        set.setValueFormatter(new CustomFormatter());
        set.setValueTextSize(12f);
        set.setAxisDependency(YAxis.AxisDependency.RIGHT); // Y축은 오른쪽만
        set.setColors(Color.rgb(67, 67, 72), Color.rgb(124, 181, 236)); // 남., 녀 색 구분
        set.setStackLabels(new String[]{  // 라벨 설정
                "Men", "Women"
        });

        BarData data = new BarData(set);
        data.setBarWidth(8.5f); // 바 너비
        chart.setData(data);
        chart.animateXY(1500,1500, Easing.EaseInOutQuad);
        chart.invalidate();
    }

    private class CustomFormatter extends ValueFormatter implements IValueFormatter, IAxisValueFormatter {

        private final DecimalFormat mFormat;

        CustomFormatter() {
            mFormat = new DecimalFormat("###");
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mFormat.format(Math.abs(value)) + "m";
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(Math.abs(value)) + "m";
        }
    }
}

