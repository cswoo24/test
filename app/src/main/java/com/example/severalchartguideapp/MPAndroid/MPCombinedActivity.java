package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/CombinedChartActivity.java
public class MPCombinedActivity extends MPAndroidChartActivity{

    CombinedChart mpCombinedChart;
    private final int count = 12;

    protected final String[] months = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpcombined);


        mpCombinedChart =(CombinedChart) findViewById(R.id.combinedchart);

        mpCombinedChart.getDescription().setEnabled(false);
        mpCombinedChart.setBackgroundColor(Color.WHITE);
        mpCombinedChart.setDrawGridBackground(false);
        mpCombinedChart.setDrawBarShadow(false);
        mpCombinedChart.setHighlightFullBarEnabled(false);


        mpCombinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE
        });

        Legend l = mpCombinedChart.getLegend();
        l.setEnabled(true);
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        YAxis rightAxis = mpCombinedChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = mpCombinedChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)


        XAxis xAxis = mpCombinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(months));
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(false);
        xAxis.setGranularityEnabled(true);

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        data.setData(generateBarData());
        data.setData(generateBubbleData());

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);

        mpCombinedChart.setData(data);
        mpCombinedChart.invalidate();

/*
        YAxis yLAxis = mpCombinedChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        YAxis yRAxis = mpCombinedChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(false); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(false); // Y축 그리드 선 표시 여부*/

        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        mpCombinedChart.setDragEnabled(true);
        mpCombinedChart.setVisibleXRangeMaximum(5);
        mpCombinedChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과






        /*
        String[] xAxisLables = new String[]{"1월","2월", "3월", "4월" ,"5월","6월","7월","8월","9월","10월"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLables));*/

    }

    private LineData generateLineData() { // line data 생성

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<>();

        for (int index = 0; index < count+1; index++)
            entries.add(new Entry(index + 0.5f, getRandom(15, 5)));


        LineDataSet set = new LineDataSet(entries, "Line DataSet");
        set.setColor(Color.RED);
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.RED);
        set.setCircleRadius(5f);
        set.setFillColor(Color.RED);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.RED);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    private BarData generateBarData() { // bar data 생성

        ArrayList<BarEntry> entries1 = new ArrayList<>();
        ArrayList<BarEntry> entries2 = new ArrayList<>();

        for (int index = 0; index < count+1; index++) {
            entries1.add(new BarEntry(0, getRandom(25, 25)));

            // stacked
            entries2.add(new BarEntry(0, new float[]{getRandom(13, 12), getRandom(13, 12)}));
        }

        BarDataSet set1 = new BarDataSet(entries1, "Bar 1");
        set1.setColor(Color.rgb(60, 220, 78));
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        BarDataSet set2 = new BarDataSet(entries2, "");
        set2.setColors(Color.rgb(61, 165, 255), Color.rgb(23, 197, 255));
        set2.setValueTextColor(Color.rgb(61, 165, 255));
        set2.setValueTextSize(10f);
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData d = new BarData(set1, set2);
        d.setBarWidth(barWidth);

        // make this BarData object grouped
        d.groupBars(0, groupSpace, barSpace); // start at x = 0

        return d;
    }
    private BubbleData generateBubbleData() {

        BubbleData bd = new BubbleData();

        ArrayList<BubbleEntry> entries = new ArrayList<>();

        for (int index = 0; index < count+1; index++) {
            float y = getRandom(10, 105);
            float size = getRandom(100, 105);
            entries.add(new BubbleEntry(index + 0.5f, y, size));
        }

        BubbleDataSet set = new BubbleDataSet(entries, "Bubble DataSet");
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.BLACK);
        set.setHighlightCircleWidth(1.5f);
        set.setDrawValues(true);
        bd.addDataSet(set);

        return bd;
    }

    protected float getRandom(float range, float start) {
        return (float) (Math.random() * range) + start;
    }

}
