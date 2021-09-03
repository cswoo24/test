package com.example.severalchartguideapp.Hello;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/GoodBadChartActivity.java
public class HelGoodBadActivity extends HelloChartActivity {

    private LineChartView chart;
    private LineChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helgoodbad);

        chart = (LineChartView)findViewById(R.id.hel_goodbad);

        generateData();

        chart.setLineChartData(data);

        Axis axisX = new Axis(); // X축
        axisX.setHasTiltedLabels(true);  // X축 라벨 글자 기울이기
//	    axisX.setTextColor(Color.WHITE);  //
        axisX.setTextColor(Color.parseColor("#D6D6D9")); // 글자 색

        axisX.setName("");  // X축 제목
        axisX.setTextSize(15); // X축 글자 크기
        axisX.setMaxLabelChars(7); // X축의 최대 좌표
        data.setAxisXBottom(axisX); //x축 하단
//	    data.setAxisXTop(axisX);  //x축 상단
        axisX.setHasLines(true); // X축 그리드 line


        Axis axisY = new Axis();  //Y축
        axisY.setName("");//y축 제목
        axisY.setTextSize(15);//글자 크기
        data.setAxisYLeft(axisY);  // Y축 왼쪽
        //data.setAxisYRight(axisY);  //y축 오른쪽

        chart.setInteractive(true); // 화면 움직이기 속성 설정
        chart.setZoomType(ZoomType.HORIZONTAL);  //수평 이동
        chart.setMaxZoom((float) 3);//화면 비율
        chart.setLineChartData(data);  // chart에 라벨 설정까지 된 data insert
        chart.setVisibility(View.VISIBLE); // 화면 보이기/안 보이기

        Viewport v = new Viewport(chart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        chart.setCurrentViewport(v);

    }

    private void generateData() {

        // Generate data, every line has 3 points to form filled triangle. Point radius is set to 1 to be almost
        // invisible but it has to be there because without points there is not labels. Area transparency is set to
        // 255(full opacity).

        // Important note. This example uses negative values, to properly fill area below 0 chart base value have to
        // be set to 0. That is default base value but if you want to be sure you can call data.setBaseValue(0)
        // method.

        Line line;
        List<PointValue> values;
        List<Line> lines = new ArrayList<Line>();

        // First good triangle
        values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 0).setLabel("".toCharArray()));
        values.add(new PointValue(1, 1).setLabel("Very Good:)".toCharArray())); // label 생성
        values.add(new PointValue(2, 0).setLabel("".toCharArray()));

        line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN); // 섹
        line.setAreaTransparency(255); // 투명도
        line.setFilled(true); // 채우기 여부
        line.setPointRadius(1); // data 지점에 point 크기
        line.setHasLabels(true); // 라벨 보이기 여부("Very Good:)")
        lines.add(line);

        // Second good triangle
        values = new ArrayList<PointValue>();
        values.add(new PointValue(3, 0).setLabel("".toCharArray()));
        values.add(new PointValue(4, 0.5f).setLabel("Good Enough".toCharArray()));
        values.add(new PointValue(5, 0).setLabel("".toCharArray()));

        line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN);
        line.setAreaTransparency(255);
        line.setFilled(true);
        line.setPointRadius(1);
        line.setHasLabels(true);
        lines.add(line);

        // Bad triangle
        values = new ArrayList<PointValue>();
        values.add(new PointValue(1, 0).setLabel("".toCharArray()));
        values.add(new PointValue(2, -1).setLabel("Very Bad".toCharArray()));
        values.add(new PointValue(3, 0).setLabel("".toCharArray()));

        line = new Line(values);
        line.setColor(ChartUtils.COLOR_RED);
        line.setAreaTransparency(255);
        line.setFilled(true);
        line.setPointRadius(1);
        line.setHasLabels(true);
        lines.add(line);

        data = new LineChartData(lines);

        // *** Important, set base value to 0 to fill negative part of chart.
        // data.setBaseValue(0);

        //data.setLines(lines); // data에 lines(List) insert

    }
}
