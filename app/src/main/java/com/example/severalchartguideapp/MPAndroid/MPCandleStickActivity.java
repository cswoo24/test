package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/CandleStickChartActivity.java

public class MPCandleStickActivity extends MPAndroidChartActivity {

    CandleStickChart mpCandleStickChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpcandlestick);

        mpCandleStickChart = (CandleStickChart)findViewById(R.id.candlestick_chart);


        CandleDataSet set1 = new CandleDataSet(dataValues1(), "DataSet 1");
        //set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(getResources().getColor(R.color.colorLightGrayMore)); // 데이터 심지 색
        set1.setShadowWidth(2f); // 심지 너비
        set1.setDecreasingColor(getResources().getColor(R.color.colorChartLow)); // 하락장 색
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(getResources().getColor(R.color.colorChartHigh)); // 상승장 color.xml에서 정의한 색 가져오기
        set1.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE); // 상승장 색칠 타입(테두리, 채우기, 둘다)
        set1.setNeutralColor(Color.DKGRAY); //
        set1.setDrawValues(true); // shadowhigh 값 출력
        set1.setDrawHighlightIndicators(false); // 화면 터치 시 highlight 사용 여부



        YAxis yAxis = mpCandleStickChart.getAxisLeft();
        YAxis rightAxis = mpCandleStickChart.getAxisRight();
        yAxis.setDrawGridLines(true);
        yAxis.setDrawLabels(true);
        rightAxis.setDrawGridLines(true);
        rightAxis.setTextColor(Color.BLACK);
        mpCandleStickChart.requestDisallowInterceptTouchEvent(true);

        XAxis xAxis = mpCandleStickChart.getXAxis();
        xAxis.setDrawGridLines(false);// disable x axis grid lines
        xAxis.setDrawLabels(true);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);

        Description description = new Description(); // chart 오른쪽 하단 문자 설정
        description.setText("");
        description.setEnabled(false);

        Legend legend = mpCandleStickChart.getLegend(); // 범례
        legend.setEnabled(true);
        legend.setTextSize(10f);
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);


        mpCandleStickChart.animateY(3000/*, Easing.EasingOption.EaseInCubic*/); // 라인 애니메이션 효과
        mpCandleStickChart.setDoubleTapToZoomEnabled(true);
        mpCandleStickChart.setDrawGridBackground(true); // 그리드 배경 여부(gray or white)




// create a data object with the datasets
        CandleData data = new CandleData(set1);


// set data
        mpCandleStickChart.setData(data);
        mpCandleStickChart.invalidate();

    }

    private ArrayList<CandleEntry> dataValues1() { // Column Chart Data 생성
        ArrayList<CandleEntry> datavals = new ArrayList<CandleEntry>();

        datavals.add(new CandleEntry(0,224.f,222.2f,222.8f,222.9f));
        datavals.add(new CandleEntry(1,222.4f,222.0f,222.f,222.2f));
        datavals.add(new CandleEntry(2, 222.5F,  221.5F, 222.2F,  221.9F));
        datavals.add(new CandleEntry(3, 223.7F,  222.1F, 222.4F,  222.3F));
        datavals.add(new CandleEntry(4, 221.9F,  221.5F, 221.6F,  221.9F));
        datavals.add(new CandleEntry(5, 225.0F,  221.0F, 221.8F,  224.9F));
        datavals.add(new CandleEntry(6, 225.4F,  219.2F, 225.0F,  220.2F));
        datavals.add(new CandleEntry(7, 227.5F,  222.2F, 222.2F,  225.9F));
        datavals.add(new CandleEntry(8, 228.1F,  225.1F, 226.0F,  228.1F));
        datavals.add(new CandleEntry(9, 230.9F,  226.5F, 227.6F,  228.9F));
        datavals.add(new CandleEntry(10, 230.9F,  228.0F, 228.6F,  228.6F));


        return datavals;
    }


}
