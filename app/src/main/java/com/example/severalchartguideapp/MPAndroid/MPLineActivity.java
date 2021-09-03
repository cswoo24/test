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


        LineDataSet lineDataSet = new LineDataSet(entries, "속성명1");
        lineDataSet.setLineWidth(2); // 그래프 라인 두께
        lineDataSet.setCircleRadius(6); // 그래프 점 표시하는 원의 반지름
        lineDataSet.setCircleColor(Color.parseColor("#660000")); // 그래프 점 색 설정
        //lineDataSet.setCircleHoleColor(Color.GREEN); // 그래프 점(원) 중심 색 설정
        lineDataSet.setColor(Color.parseColor("#FF0000")); // 그래프 선 색 설정정        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true); //그래프 원 표시 여부
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(true); //그래프에 Y값 표시 여부
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER /*CUBIC_BEZIER*/); //그래프 모양 설정
        lineDataSet.setDrawFilled(true); //그래프 밑부분 색칠(그라데이션)

        LineData lineData = new LineData(lineDataSet);
        mpLineChart.setData(lineData);

        lineData.setValueTextColor(Color.BLUE); //라인 데이터의 텍스트 컬러 설정
        lineData.setValueTextSize(15f);

        XAxis xAxis = mpLineChart.getXAxis(); //X축 설정
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X축 위치 설정
        xAxis.setTextColor(Color.BLACK); // X축 서식 색 설정
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines

        String[] xAxisLables = new String[]{"1월","2월", "3월", "4월" ,"5월","6월","7월","8월","9월","10월"};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLables));

        YAxis yLAxis = mpLineChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yLAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yLAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        String[] yAxisLables = new String[]{"10","20", "30", "40" ,"50","60","70","80","90","100"};
        yLAxis.setValueFormatter(new IndexAxisValueFormatter(yAxisLables));

        YAxis yRAxis = mpLineChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(false); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(false); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(false); // Y축 그리드 선 표시 여부


        Description description = new Description();
        description.setText("Temp Data");
        description.setTextSize(15);
        description.setTextColor(Color.GREEN);

        mpLineChart.setDoubleTapToZoomEnabled(false);
        //mpLineChart.setBackgroundColor(Color.YELLOW); // 배경색 설정
        mpLineChart.setBorderColor(Color.MAGENTA);
        mpLineChart.setBorderWidth(3);
        mpLineChart.setDrawGridBackground(false); // 그리드 배경 여부(gray or white)
        mpLineChart.setDescription(description);
        mpLineChart.animateY(2000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과
        //mpLineChart.animateY(1400, Easing.EaseInOutSine);
        mpLineChart.invalidate();//차트 초기화

        Legend legend = mpLineChart.getLegend();
        legend.setTextColor(Color.RED); // 범례 색 설정
        legend.setTextSize(15f); // 범례 글자크기 설정
        legend.setEnabled(true); // 범례 표시 여부
        /*legend.setXOffset(85f); // 범례 X축 위치 설정
        legend.setYOffset(10f); // 범례 Y축 위치 */
    }
/*
    private class MYValueFormatter implements IAxisValueFormatter{

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return value + "$";
        }
    }*/




}
