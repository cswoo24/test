package com.example.severalchartguideapp.Hello;

import android.os.Bundle;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.BubbleChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/BubbleChartActivity.java
public class HelBubbleActivity extends HelloChartActivity {

    private BubbleChartView chart;
    private BubbleChartData data;

    private static final int BUBBLES_NUM = 8; // data 개수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helbubble);

        chart = (BubbleChartView)findViewById(R.id.hel_bubble);

        generateData();
    }

    private void generateData() {

        List<BubbleValue> values = new ArrayList<BubbleValue>();
        for (int i = 0; i < BUBBLES_NUM; ++i) {
            BubbleValue value = new BubbleValue(i, (float) Math.random() * 100, (float) Math.random() * 1000); // Z:크기
            value.setColor(ChartUtils.pickColor()); // 색
            value.setShape(ValueShape.CIRCLE); // data 모양
            values.add(value);
        }

        data = new BubbleChartData(values);
        data.setHasLabels(true); // data 값 보이게 할 건지
        data.setHasLabelsOnlyForSelected(false); // data 값 선택될때만 보이게 할 건지

        Axis axisX = new Axis();
        Axis axisY = new Axis().setHasLines(true);

        axisX.setName("Axis X"); // X축 이름
        axisY.setName("Axis Y"); // Y축 이름

        data.setAxisXBottom(axisX); // X축 위치
        data.setAxisYLeft(axisY); // Y축 위치

        chart.setBubbleChartData(data); // chart setting
    }
}
