package com.example.severalchartguideapp.MPAndroid;

import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/ScrollViewActivity.java
public class MPScrollViewActivity extends MPAndroidChartActivity {

    private BarChart mpscrollviewchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mplinearscrollview);
        setContentView(R.layout.activity_mpnotscrollview);

        mpscrollviewchart = findViewById(R.id.chart01);

        //  layout이 scrollview인 chart
        // 위, 아래 size 조정은 layout에서

        mpscrollviewchart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        mpscrollviewchart.setPinchZoom(false);

        mpscrollviewchart.setDrawBarShadow(false); // bar 그림자 여부
        mpscrollviewchart.setDrawGridBackground(false); // 그리드 배경 여부

        XAxis xAxis = mpscrollviewchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X축 위치
        xAxis.setDrawGridLines(false); // X축 그리드 라인 여부

        mpscrollviewchart.getAxisLeft().setDrawGridLines(false); // 왼쪽 Y축 그리드 라인 여부

        mpscrollviewchart.getLegend().setEnabled(false); //범례 표시

        setData(10);
        mpscrollviewchart.setFitBars(true); // 막대 차트의 막대가 완전히 표시되도록 x축 범위의 각 측면에 막대 너비의 절반을 추가
    }

    private void setData(int count) {

        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * count) + 15;
            values.add(new BarEntry(i, (int) val));
        }

        BarDataSet set = new BarDataSet(values, "Data Set");
        set.setColors(ColorTemplate.VORDIPLOM_COLORS); // data 색 지정
        set.setDrawValues(true); // value값 표시
        set.setValueTextSize(12f);

        BarData data = new BarData(set);

        mpscrollviewchart.setData(data);
        mpscrollviewchart.invalidate();
        mpscrollviewchart.animateY(800);
    }
}
