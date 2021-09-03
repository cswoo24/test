package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.view.HorizontalStackBarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

import java.text.DecimalFormat;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/stackedchart/StackedCardTwo.java
public class WilHorizontalStackBarOneActivity extends WilliamChartActivity {

    private HorizontalStackBarChartView mChart;

    private final String[] mLabels = {"0-20", "20-40", "40-60", "60-80", "80-100", "100+"};

    private final float[][] mValues =
            {{1.8f, 2f, 2.4f, 2.2f, 3.3f, 3.45f}, {-1.8f, -2.1f, -2.55f, -2.40f, -3.40f, -3.5f},
                    {1.8f, 2.1f, 2.55f, 2.40f, 3.40f, 3.5f},
                    {-1.8f, -2f, -2.4f, -2.2f, -3.3f, -3.45f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilhorizontalstackone);

        initView();
    }

   private void initView(){

        mChart = (HorizontalStackBarChartView) findViewById(R.id.chart);

        BarSet barSet = new BarSet(mLabels, mValues[0]);
        barSet.setColor(Color.parseColor("#90ee7e"));
        mChart.addData(barSet);

        barSet = new BarSet(mLabels, mValues[1]);
        barSet.setColor(Color.parseColor("#2b908f"));
        mChart.addData(barSet);

        Paint gridPaint = new Paint(); // setGrid paint 속성
        gridPaint.setColor(Color.parseColor("#e7e7e7")); // 선 색
        gridPaint.setStyle(Paint.Style.STROKE); // 선 스타일
        gridPaint.setAntiAlias(true); // 부드럽게
        gridPaint.setStrokeWidth(Tools.fromDpToPx(.7f)); // 선 너비(두께)

        mChart.setBarSpacing(Tools.fromDpToPx(10)); // 바 간격

        mChart.setBorderSpacing(0)
                .setStep(1) // 기준값(0)에서의 라벨 간격
                .setGrid(0, 10, gridPaint) // 그리드에 그릴 바의 row,column 개수, paint 속성
                .setXAxis(false) // X축
                .setYAxis(false) // Y축
                .setLabelsFormat(new DecimalFormat("##'M'")); // 라벨 포맷

        mChart.show(); // chart loading
                //.show(new Animation().setDuration(2500)
                //        .setEasing(new AccelerateInterpolator())
                //        .setEndAction(action));
    }
}
