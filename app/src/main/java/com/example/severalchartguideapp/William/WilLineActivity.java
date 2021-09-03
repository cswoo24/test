package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.model.Point;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.view.LineChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/linechart/LineCardTwo.java
public class WilLineActivity extends WilliamChartActivity {

    private LineChartView mChart;

    private final String[] mLabels = // label
            {"", "", "", "", "START", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                    "", "", "", "", "", "", "", "", "", "", "", "", "", "", "FINISH", "", "", "",
                    ""};

    private final float[][] mValues = // data value
            {{35f, 37f, 47f, 49f, 43f, 46f, 80f, 83f, 65f, 68f, 28f, 55f, 58f, 50f, 53f, 53f, 57f,
                    48f, 50f, 53f, 54f, 25f, 27f, 35f, 37f, 35f, 80f, 82f, 55f, 59f, 85f, 82f, 60f,
                    55f, 63f, 65f, 58f, 60f, 63f, 60f},
                    {85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f,
                            85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f,
                            85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f, 85f}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_willine);

        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음
        // 또한 패키지에서 가져온 animation.java - annotations 문제로 인해 동작X

        initView();
    }
    private void initView() {
        mChart = (LineChartView) findViewById(R.id.chart);

        LineSet dataset = new LineSet(mLabels, mValues[0]);  // data insert
        dataset.setColor(Color.parseColor("#004f7f"))
                .setThickness(Tools.fromDpToPx(3)) // 라인 두께 : 3
                .setSmooth(true) // 라인 부드럽게
                .beginAt(4)  // dataset begin 시점(label) 배열 index
                .endAt(36); // dataset end 시점(label) 배열 index
        for (int i = 0; i < mLabels.length; i += 5) { // 5의 배수 data에 point 생성
            Point point = (Point) dataset.getEntry(i);
            point.setColor(Color.parseColor("#ffffff"));
            point.setStrokeColor(Color.parseColor("#0290c3"));
            if (i == 30 || i == 10) point.setRadius(Tools.fromDpToPx(6)); // data label : 10,30인 데이터의 포인터 설정(반지름:6)
        }
        mChart.addData(dataset);

        LineSet dataset1 = new LineSet(mLabels, mValues[1]);
        dataset1.setColor(Color.parseColor("#004f7f"))
                .setThickness(Tools.fromDpToPx(3))
                .setSmooth(true)
                .beginAt(4)
                .endAt(36);
        for (int i = 0; i < mLabels.length; i += 5) {
            Point point = (Point) dataset1.getEntry(i);
            point.setColor(Color.parseColor("#ffffff"));
            point.setStrokeColor(Color.parseColor("#0290c3"));
            if (i == 30 || i == 10) point.setRadius(Tools.fromDpToPx(6));
        }
        mChart.addData(dataset1);

        Paint thresPaint = new Paint(); // setValueThreshold paint 속성
        thresPaint.setColor(Color.RED);//(Color.parseColor("#0079ae"));
        thresPaint.setStyle(Paint.Style.STROKE); // 모양(채우기, 천, 채우기+선)
        thresPaint.setAntiAlias(true); // 안티에일리어싱(가장자리 부드럽게)
        thresPaint.setStrokeWidth(Tools.fromDpToPx(.75f)); // 선 두께
        thresPaint.setPathEffect(new DashPathEffect(new float[] {10, 10}, 0)); // 경로 효과 개체를 설정(간격 – ON 및 OFF 거리의 배열, 위상 – 간격 배열로 간격띄우기)

        Paint gridPaint = new Paint(); // setGrid paint 속성
        gridPaint.setColor(Color.parseColor("#ffffff")); // default : black, 배경색
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setAntiAlias(true);
        gridPaint.setStrokeWidth(Tools.fromDpToPx(35f));

        mChart.setBorderSpacing(Tools.fromDpToPx(0.1f)) // ?
                .setXLabels(AxisRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치
                .setLabelsColor(Color.parseColor("#304a00")) // X,Y축 라벨 색
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE) // Y축 라벨 위치
                .setXAxis(true) // X축
                .setYAxis(true) // Y축
                .setGrid(2, 7, gridPaint) // chart에 그리드(막대) 추가(row,column,paint 형식)
                .setValueThreshold(80f, 80f, thresPaint) // 임계값. 80f의 점선
                .setAxisBorderValues(0, 110); // Y축 최소~최대


        mChart.show();
    }


}
