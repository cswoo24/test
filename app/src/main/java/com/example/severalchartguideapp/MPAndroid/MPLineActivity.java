package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/InvertedLineChartActivity.java
public class MPLineActivity extends MPAndroidChartActivity{

    LineChart mpLineChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpline);

        mpLineChart = (LineChart)findViewById(R.id.line_chart);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 5));
        entries.add(new Entry(1, 1));
        entries.add(new Entry(2, 2));
        entries.add(new Entry(3, 0));
        entries.add(new Entry(4, 4));
        entries.add(new Entry(5, 3));
        entries.add(new Entry(6, 0));
        entries.add(new Entry(7, 7));
        entries.add(new Entry(8, 5));
        entries.add(new Entry(9, 3));

        ArrayList<String> labels = new ArrayList<>();

        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");


        LineDataSet lineDataSet = new LineDataSet(entries, "?????????1");
        lineDataSet.setLineWidth(2); // ????????? ?????? ??????
        lineDataSet.setCircleRadius(6); // ????????? ??? ???????????? ?????? ?????????
        lineDataSet.setCircleColor(Color.parseColor("#660000")); // ????????? ??? ??? ??????
        //lineDataSet.setCircleHoleColor(Color.GREEN); // ????????? ???(???) ?????? ??? ??????
        lineDataSet.setColor(Color.parseColor("#FF0000")); // ????????? ??? ??? ?????????        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true); //????????? ??? ?????? ??????
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(true); //???????????? Y??? ?????? ??????
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER /*CUBIC_BEZIER*/); //????????? ?????? ??????
        lineDataSet.setDrawFilled(true); //????????? ????????? ??????(???????????????)

        LineData lineData = new LineData(lineDataSet);
        mpLineChart.setData(lineData);

        lineData.setValueTextColor(Color.BLUE); //?????? ???????????? ????????? ?????? ??????
        lineData.setValueTextSize(15f);

        XAxis xAxis = mpLineChart.getXAxis(); //X??? ??????
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X??? ?????? ??????
        xAxis.setTextColor(Color.BLACK); // X??? ?????? ??? ??????
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines

        String[] xAxisLables = new String[]{"1???","2???", "3???", "4???" ,"5???","6???","7???","8???","9???","10???"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLables));

        YAxis yLAxis = mpLineChart.getAxisLeft(); //?????? Y??? ??????
        yLAxis.setTextColor(Color.BLACK); // ?????? Y??? ?????? ??? ??????
        yLAxis.setDrawLabels(true); // Y??? ?????? ?????? ??????
        yLAxis.setDrawAxisLine(true); // Y??? ??????(?????? ??????) ??? ?????? ??????
        yLAxis.setDrawGridLines(true); // Y??? ????????? ??? ?????? ??????

        String[] yAxisLables = new String[]{"10","20", "30", "40" ,"50","60","70","80","90","100"};
        yLAxis.setValueFormatter(new IndexAxisValueFormatter(yAxisLables));

        YAxis yRAxis = mpLineChart.getAxisRight(); // ????????? Y??? ??????
        yRAxis.setDrawLabels(false); // Y??? ?????? ?????? ??????
        yRAxis.setDrawAxisLine(false); // Y??? ??????(?????? ??????) ??? ?????? ??????
        yRAxis.setDrawGridLines(false); // Y??? ????????? ??? ?????? ??????


        Description description = new Description();
        description.setText("Temp Data");
        description.setTextSize(15);
        description.setTextColor(Color.GREEN);

        mpLineChart.setDoubleTapToZoomEnabled(false);
        //mpLineChart.setBackgroundColor(Color.YELLOW); // ????????? ??????
        mpLineChart.setBorderColor(Color.MAGENTA);
        mpLineChart.setBorderWidth(3);
        mpLineChart.setDrawGridBackground(false); // ????????? ?????? ??????(gray or white)
        mpLineChart.setDescription(description);
        mpLineChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // ?????? ??????????????? ??????
        //mpLineChart.animateY(1400, Easing.EaseInOutSine);
        mpLineChart.invalidate();//?????? ?????????

        Legend legend = mpLineChart.getLegend();
        legend.setTextColor(Color.RED); // ?????? ??? ??????
        legend.setTextSize(15f); // ?????? ???????????? ??????
        legend.setEnabled(true); // ?????? ?????? ??????
        /*legend.setXOffset(85f); // ?????? X??? ?????? ??????
        legend.setYOffset(10f); // ?????? Y??? ?????? */
    }
/*
    private class MYValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return value + "$";
        }
    }*/




}
