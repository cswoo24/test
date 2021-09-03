package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.os.Bundle;

import com.db.chart.model.LineSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.view.LineChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/linechart/LineCardOne.java
public class WilMultiLineActivity extends WilliamChartActivity {

    private LineChartView mChart;
    private final String[] mLabels = {"Jan", "Fev", "Mar", "Apr", "Jun", "May", "Jul", "Aug", "Sep"};

    private final float[][] mValues = {{3.5f, 4.7f, 4.3f, 8f, 6.5f, 9.9f, 7f, 8.3f, 7.0f},
            {4.5f, 2.5f, 2.5f, 2.9f, 4.5f, 9.5f, 5f, 8.3f, 1.8f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilmultiline);

        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음
        // 또한 패키지에서 가져온 animation.java - annotations 문제로 인해 동작X

        initView();
    }

    private void initView() {
        mChart = (LineChartView) findViewById(R.id.chart);

        LineSet dataset = new LineSet(mLabels, mValues[0]);
        dataset.setColor(Color.parseColor("#ffff00")) // 선 색
                .setFill(Color.LTGRAY)//(Color.parseColor("#2d374c")) // 채우기 섹
                .setDotsColor(Color.parseColor("#758cbb")) // data value 점 색
                .setThickness(15) // 두께
                .setDashed(new float[] {10f, 10f}) // 파선 정의(짧은 선을 나열한 선) -> line 모양
                .beginAt(3); // value index
        mChart.addData(dataset);

        dataset = new LineSet(mLabels, mValues[0]);
        dataset.setColor(Color.parseColor("#006600"))
                .setFill(Color.GREEN)//(Color.parseColor("#6699ff"))
                .setDotsColor(Color.parseColor("#990033"))
                .setThickness(10)
                .endAt(4); // (first data) ~ 개수
        mChart.addData(dataset);

        LineSet dataset1 = new LineSet(mLabels, mValues[1]);
        dataset1.setColor(Color.parseColor("#3300ff"))
                .setFill(Color.BLUE)//(Color.parseColor("#2d374c"))
                .setDotsColor(Color.parseColor("#758cbb"))
                .setThickness(4)
                .setDashed(new float[] {10f, 10f})
                .beginAt(5);
        mChart.addData(dataset1);

        dataset1 = new LineSet(mLabels, mValues[1]);
        dataset1.setColor(Color.parseColor("#b3b5bb"))
                .setFill(Color.RED)//(Color.parseColor("#2d374c"))
                .setDotsColor(Color.parseColor("#ffc755"))
                .setThickness(4)
                .endAt(6);
        mChart.addData(dataset1);

        mChart.setBorderSpacing(1)
                .setAxisBorderValues(0, 10) // Y축 최소~최대
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE) // Y라벨 위치
                .setXLabels(AxisRenderer.LabelPosition.OUTSIDE) // X라벨 위치
                .setLabelsColor(Color.parseColor("#6a84c3")) // 라벨 색
                .setXAxis(true) // X축
                .setYAxis(true) // Y축
                .setAxisColor(Color.BLACK) // X,Y축 색
        ;

        mChart.show();
    }
}
