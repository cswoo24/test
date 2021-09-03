package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.XRenderer;
import com.db.chart.renderer.YRenderer;
import com.db.chart.view.BarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/barchart/BarCardOne.java
public class WilGroupBarActivity extends WilliamChartActivity {

    private BarChartView mChart;
    private final String[] mLabels = {"A", "B", "C", "D"}; // 라벨
    private final float[][] mValues = {{6.5f, 8.5f, 2.5f, 10f}, {7.5f, 3.5f, 5.5f, 4f}}; // data value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilgroupbar);

        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음

        initView();
    }

    private void initView() {
        mChart = (BarChartView) findViewById(R.id.chart);

        BarSet barSet = new BarSet(mLabels, mValues[0]); // dataset1 정의(라벨,데이터)
        barSet.setColor(Color.parseColor("#fc2a53")); // 색 지정
        mChart.addData(barSet);

        BarSet barSet1 = new BarSet(mLabels, mValues[1]); // dataset2 정의
        barSet1.setColor(Color.parseColor("#2afc73"));
        mChart.addData(barSet1);

        mChart.setBarSpacing(Tools.fromDpToPx(20));// 바 간격(숫자 : Converts dp size into pixels.)
        mChart.setRoundCorners(Tools.fromDpToPx(20)); // 바 각진 부분 round형으로 (숫자 : 반지름)
        mChart.setBarBackgroundColor(Color.parseColor("#592932"));

        // Chart
        mChart.setXAxis(true) // X축 표시
                .setYAxis(true) // Y축 표시
                .setXLabels(XRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치
                .setYLabels(YRenderer.LabelPosition.OUTSIDE) // Y축 라벨 위치
                .setLabelsColor(Color.BLUE )//(Color.parseColor("#86705c"))// X,Y 라벨 섹
                .setAxisColor(Color.RED);//(Color.parseColor("#86705c")) // X,Y축 색;


        mChart.show(); // chart load
    }
}
