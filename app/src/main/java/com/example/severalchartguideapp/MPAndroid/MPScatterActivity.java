package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/ScatterChartActivity.java
public class MPScatterActivity extends MPAndroidChartActivity{

    ScatterChart mpScatterChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpscatter);

        mpScatterChart = (ScatterChart) findViewById(R.id.scatter_chart);

        ScatterDataSet dataSet1 = new ScatterDataSet(dataValues1(), "data1");
        ScatterDataSet dataSet2 = new ScatterDataSet(dataValues2(), "data2");

        ScatterData scatterData = new ScatterData();
        scatterData.addDataSet(dataSet1);
        scatterData.addDataSet(dataSet2);

        dataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        dataSet1.setScatterShapeSize(40f);
        dataSet2.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
        dataSet2.setScatterShapeSize(50f);

        dataSet1.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        dataSet2.setColor(ColorTemplate.COLORFUL_COLORS[2]);
        dataSet1.setDrawValues(false);
        dataSet2.setDrawValues(false);

        scatterData.setValueTextSize(10);

        XAxis xAxis = mpScatterChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines
        xAxis.setSpaceMax(2.5f);
        xAxis.setSpaceMin(2.5f);

        YAxis yLAxis = mpScatterChart.getAxisLeft(); //?????? Y??? ??????
        yLAxis.setTextColor(Color.BLACK); // ?????? Y??? ?????? ??? ??????
        yLAxis.setDrawLabels(true); // Y??? ?????? ?????? ??????
        yLAxis.setDrawAxisLine(false); // Y??? ??????(?????? ??????) ??? ?????? ??????
        yLAxis.setDrawGridLines(true); // Y??? ????????? ??? ?????? ??????
        yLAxis.setSpaceTop(30f);
        yLAxis.setSpaceBottom(30f);

        YAxis yRAxis = mpScatterChart.getAxisRight(); // ????????? Y??? ??????
        yRAxis.setDrawLabels(true); // Y??? ?????? ?????? ??????
        yRAxis.setDrawAxisLine(false); // Y??? ??????(?????? ??????) ??? ?????? ??????
        yRAxis.setDrawGridLines(true); // Y??? ????????? ??? ?????? ??????

        Legend legend = mpScatterChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); //?????? ?????? ??????(??????,??????,??????)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // ?????? ?????? ??????(??????,?????????,?????????)
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); //?????? ??????(?????? ?????? - ??????/??????)
        legend.setDrawInside(false); // ?????? ?????? ??????(?????? ?????? ????????? ?????????)
        legend.setXEntrySpace(3f); // ?????? ??? x ??????
        legend.setYEntrySpace(5f); // ?????? ??? y ??????
        legend.setTextColor(Color.BLACK);

        Description description = new Description();
        description.setText("");
        description.setEnabled(false);

        mpScatterChart.setDoubleTapToZoomEnabled(false);
        mpScatterChart.setDrawGridBackground(true); // ????????? ?????? ??????(gray or white)
        mpScatterChart.setDescription(description);
        mpScatterChart.animateY(2000);//, Easing.EasingOption.EaseInCubic); mpLineChart.animate()

        mpScatterChart.setData(scatterData);
        mpScatterChart.invalidate();
    }

    private ArrayList<Entry> dataValues1() {
        ArrayList<Entry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(20, 0));
        datavals.add(new BarEntry(45, 1));
        datavals.add(new BarEntry(64, 1));
        datavals.add(new BarEntry(80, 3.2f));
        datavals.add(new BarEntry(71, 4));
        datavals.add(new BarEntry(35, 3));

        return datavals;
    }

    private ArrayList<Entry> dataValues2() {
        ArrayList<Entry> datavals = new ArrayList<>();

        datavals.add(new BarEntry(50, 5));
        datavals.add(new BarEntry(75,2.7f));
        datavals.add(new BarEntry(30,1));
        datavals.add(new BarEntry(25,3));
        datavals.add(new BarEntry(60,0));
        datavals.add(new BarEntry(15,3.3f));
        datavals.add(new BarEntry(55,5));
        datavals.add(new BarEntry(0,2));

        return datavals;
    }
}
