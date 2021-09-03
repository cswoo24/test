package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.XRenderer;
import com.db.chart.renderer.YRenderer;
import com.db.chart.view.StackBarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/barchart/BarCardThree.java
public class WilStackBarActivity extends WilliamChartActivity {

    private StackBarChartView mChart;

    private final String[] mLabels = // label
            {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
            //{"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}; // 포르투갈어

    private final float[][] mValuesOne = // data value
            {{30f, 40f, 25f, 25f, 40f, 25f, 25f, 30f, 30f, 25f, 40f, 25f},
                    {30f, 30f, 25f, 40f, 25f, 30f, 40f, 30f, 30f, 25f, 25f, 25f},
                    {30f, 30f, 25f, 25f, 25f, 25f, 25f, 30f, 40f, 25, 25, 40f}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilstackbar);

        initView();
    }

    private void initView() {
        mChart = (StackBarChartView)findViewById(R.id.chart);


        Paint thresPaint = new Paint();
        thresPaint.setColor(Color.parseColor("#011f8a")); // 선 색
        thresPaint.setPathEffect(new DashPathEffect(new float[] {10, 20}, 0)); // 경로 효과 개체를 설정(간격 – ON 및 OFF 거리의 배열, 위상 – 간격 배열로 간격띄우기)
        thresPaint.setStyle(Paint.Style.STROKE);// 모양(채우기, 천, 채우기+선)
        thresPaint.setAntiAlias(true); //안티에일리어싱(가장자리 부드럽게)
        thresPaint.setStrokeWidth(Tools.fromDpToPx(5f)); // 선 두께

        BarSet stackBarSet = new BarSet(mLabels, mValuesOne[0]);
        stackBarSet.setColor(Color.parseColor("#a1d949")); // 라벨0 색 설정
        mChart.addData(stackBarSet);

        stackBarSet = new BarSet(mLabels, mValuesOne[1]);
        stackBarSet.setColor(Color.parseColor("#ffcc6a")); // 라벨1 색 설정
        mChart.addData(stackBarSet);

        stackBarSet = new BarSet(mLabels, mValuesOne[2]);
        stackBarSet.setColor(Color.parseColor("#ff7a57")); // 라벨2 색 설정
        mChart.addData(stackBarSet);

        mChart.setBarSpacing(Tools.fromDpToPx(15)); // 바 간격
        mChart.setRoundCorners(Tools.fromDpToPx(10)); // 바 코너 부드럽게(반지름)

        mChart.setXAxis(true) // X축
                .setXLabels(XRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치
                .setYAxis(true) // Y축
                .setYLabels(YRenderer.LabelPosition.OUTSIDE) // Y축 라벨 위치
                .setValueThreshold(89.f, 89.f, thresPaint); // 높이 89에서 thresPaint 실행

        mChart.show();
    }

}
