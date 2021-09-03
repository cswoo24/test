package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.view.BarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/barchart/BarCardThree.java
public class WilBarActivity extends WilliamChartActivity {

    private BarChartView mChart;

    /*private final String[] mLabels = // 라벨
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                    "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    private final float[][] mValues = // data value
            {{2.5f, 3.7f, 4f, 8f, 4.5f, 4f, 5f, 7f, 10f, 14f, 12f, 6f, 7f, 8f, 9f, 8f, 9f, 8f, 7f,
                    6f, 5f, 4f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 11f, 12f, 14, 13f, 10f, 9f, 8f, 7f, 5f,
                    4f, 6f},
                    {3.5f, 4.7f, 5f, 9f, 5.5f, 5f, 6f, 8f, 11f, 13f, 11f, 7f, 6f, 7f, 10f, 11f, 12f,
                            9f, 8f, 7f, 6f, 5f, 4f, 3f, 6f, 7f, 8f, 9f, 10f, 12f, 13f, 11, 13f, 10f,
                            8f, 7f, 5f, 4f, 3f, 7f}};*/

    private final String[] mLabels = // 라벨
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    private final float[][] mValues = // data value
            {{2.5f, 3.7f, 4f, 8f, 4.5f, 4f, 5f, 7f, 10f, 14f, 12f, 6f, 7f, 8f, 9f},
                    {3.5f, 4.7f, 5f, 9f, 5.5f, 5f, 6f, 8f, 11f, 13f, 11f, 7f, 6f, 7f, 10f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilbar);

        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음

        initView();
    }

    private void initView() {
        mChart = (BarChartView) findViewById(R.id.chart);

        BarSet dataset = new BarSet(mLabels, mValues[0]);
        dataset.setColor(Color.parseColor("#eb993b")); // dataset 색
        mChart.addData(dataset);

        // Group Bar Chart 만들때 사용 //
       /* BarSet dataset1 = new BarSet(mLabels, mValues[1]);
        dataset1.setColor(Color.parseColor("#1e90ff"));
        mChart.addData(dataset1);*/

        mChart.setBarSpacing(Tools.fromDpToPx(3f)); // 바 간격

        mChart.setXLabels(AxisRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치(라벨 빈 값)
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE) // Y축 라벨 위치
                .setXAxis(true) // X축 보기
                .setYAxis(true); // Y축 보기

        mChart.show(); // chart load
        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음
    }
}
