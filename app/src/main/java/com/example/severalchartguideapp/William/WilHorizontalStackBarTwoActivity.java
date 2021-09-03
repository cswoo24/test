package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.view.HorizontalStackBarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/stackedchart/StackedCardThree.java
public class WilHorizontalStackBarTwoActivity extends WilliamChartActivity {

    private HorizontalStackBarChartView mChart;

    private final String[] mLabels = {"", "", "", ""};

    private final float[][] mValues =
            {{30f, 60f, 50f, 80f}, {-70f, -40f, -50f, -20f}, {50f, 70f, 10f, 30f},
                    {-40f, -70f, -60f, -50f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilhorizontalstacktwo);
        initView();
    }

    private void initView(){
        mChart = (HorizontalStackBarChartView)findViewById(R.id.chart);

        BarSet dataset = new BarSet(mLabels, mValues[0]); // data insert
        dataset.setColor(Color.parseColor("#687E8E")); // data 색
        mChart.addData(dataset);

        dataset = new BarSet(mLabels, mValues[1]);
        dataset.setColor(Color.parseColor("#FF5C8E67"));
        mChart.addData(dataset);

        mChart.setRoundCorners(Tools.fromDpToPx(5)); // 바 꼭지점 둥글기 정도
        mChart.setBarSpacing(Tools.fromDpToPx(5)); // 바 간격

        mChart.setBorderSpacing(Tools.fromDpToPx(5)) // 차트와 데이터 간의 간격
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE) // Y축 라벨 위치
                .setXLabels(AxisRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치
                .setXAxis(true) // X축
                .setYAxis(true) // Y축
                .setAxisBorderValues(-80, 80, 10); // X축 label 최소값,최대값, 간격

        //Animation anim = new Animation().setEasing(new DecelerateInterpolator()).setEndAction(action);

        mChart.show();


    }

}
