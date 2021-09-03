package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//기존 라이브러리와 조금 다름
//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/MultiLineChartActivity.java
public class MPMultiLineActivity extends MPAndroidChartActivity{
    LineChart mpLineChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpmultiline);

        mpLineChart = (LineChart)findViewById(R.id.line_chart);


        List<Entry> entry1 = new ArrayList<>();
        entry1.add(new Entry(0, 5));
        entry1.add(new Entry(1, 1));
        entry1.add(new Entry(2, 2));
        entry1.add(new Entry(3, 0));
        entry1.add(new Entry(4, 4));
        entry1.add(new Entry(5, 3));
        entry1.add(new Entry(6, 0));
        entry1.add(new Entry(7, 7));
        entry1.add(new Entry(8, 5));
        entry1.add(new Entry(9, 3));

        LineDataSet lineDataSet1 = new LineDataSet(entry1, "속성1");
        lineDataSet1.setLineWidth(2); // 그래프 라인 두께
        lineDataSet1.setCircleRadius(6); // 그래프 점 표시하는 원의 반지름
        lineDataSet1.setCircleColor(Color.parseColor("#660000")); // 그래프 점 색 설정
        //lineDataSet1.setCircleHoleColor(Color.GREEN); // 그래프 점(원) 중심 색 설정
        lineDataSet1.setColor(Color.parseColor("#FF0000")); // 그래프 선 색 설정정        lineDataSet.setDrawCircleHole(true);
        lineDataSet1.setDrawCircles(true); //그래프 원 표시 여부
        lineDataSet1.setDrawHorizontalHighlightIndicator(false);
        lineDataSet1.setDrawHighlightIndicators(false);
        lineDataSet1.setDrawValues(true); //그래프에 Y값 표시 여부
        lineDataSet1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER /*CUBIC_BEZIER*/); //그래프 모양 설정
        lineDataSet1.setDrawFilled(true); //그래프 채우기
        lineDataSet1.setFillColor(Color.YELLOW); // 채우기 색

        List<Entry> entry2 = new ArrayList<>();
        entry2.add(new Entry(0, 3));
        entry2.add(new Entry(1, 7));
        entry2.add(new Entry(2, 6));
        entry2.add(new Entry(3, 8));
        entry2.add(new Entry(4, 1));
        entry2.add(new Entry(5, 0));
        entry2.add(new Entry(6, 1));
        entry2.add(new Entry(7, 2));
        entry2.add(new Entry(8, 6));
        entry2.add(new Entry(9, 1));

        LineDataSet lineDataSet2 = new LineDataSet(entry2, "속성2");
        lineDataSet2.setLineWidth(2); // 그래프 라인 두께
        lineDataSet2.setCircleRadius(6); // 그래프 점 표시하는 원의 반지름
        lineDataSet2.setCircleColor(Color.parseColor("#6600ff")); // 그래프 점 색 설정
        lineDataSet2.setCircleHoleColor(Color.BLACK); // 그래프 점(원) 중심 색 설정
        lineDataSet2.setColor(Color.parseColor("#660000")); // 그래프 선 색 설정정        lineDataSet.setDrawCircleHole(true);
        lineDataSet2.setDrawCircles(true); //그래프 원 표시 여부
        lineDataSet2.setDrawHorizontalHighlightIndicator(false);
        lineDataSet2.setDrawHighlightIndicators(false);
        lineDataSet2.setDrawValues(true); //그래프에 Y값 표시 여부
        lineDataSet2.setMode(LineDataSet.Mode.LINEAR /*CUBIC_BEZIER*/); //그래프 모양 설정
        lineDataSet2.setDrawFilled(true); //그래프 채우기
        lineDataSet2.setFillColor(Color.GREEN); // 채우기 색

        LineData lineData1 = new LineData(lineDataSet1);
        mpLineChart.setData(lineData1);

        LineData lineData2 = new LineData(lineDataSet2);
        mpLineChart.setData(lineData2);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData lineData = new LineData(dataSets);
        mpLineChart.setData(lineData);

        lineData.setValueTextColor(Color.BLUE); //라인 데이터의 텍스트 컬러 설정
        lineData.setValueTextSize(15f);

        XAxis xAxis = mpLineChart.getXAxis(); //X축 설정
        xAxis.setPosition(XAxis.XAxisPosition.TOP); // X축 위치 설정
        xAxis.setTextColor(Color.BLACK); // X축 서식 색 설정
        xAxis.enableGridDashedLine(8, 24, 0); // vertical grid lines

        YAxis yLAxis = mpLineChart.getAxisLeft(); //왼쪽 Y축 설정
        yLAxis.setTextColor(Color.BLACK); // 왼쪽 Y축 서식 색 설정
        yLAxis.setDrawLabels(true);
        yLAxis.setDrawAxisLine(true);
        yLAxis.setDrawGridLines(true);

        YAxis yRAxis = mpLineChart.getAxisRight(); // 오른쪽 Y축 설정
        yRAxis.setDrawLabels(true); // Y축 서식 표시 여부
        yRAxis.setDrawAxisLine(true); // Y축 기준(왼쪽 실선) 선 표시 여부
        yRAxis.setDrawGridLines(true); // Y축 그리드 선 표시 여부

        Description description = new Description();
        description.setText("");

        mpLineChart.setDoubleTapToZoomEnabled(false);
        mpLineChart.setDrawGridBackground(false); // 그리드 배경 여부(gray or white)
        mpLineChart.setDescription(description);
        mpLineChart.animateY(2000);//, Easing.EasingOption.EaseInCubic); mpLineChart.animate()
        mpLineChart.invalidate();//차트 초기화

        Legend legend = mpLineChart.getLegend();
        legend.setTextColor(Color.RED); // 범례 색 설정
        legend.setTextSize(15f); // 범례 글자크기 설정
        legend.setEnabled(true); // 범례 표시 여부
        legend.setXOffset(85f); // 범례 X축 위치 설정
        legend.setYOffset(10f); // 범례 Y축 위치 설정

    }
}
