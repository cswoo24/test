package com.example.severalchartguideapp.Hello;

import android.graphics.Color;
import android.os.Bundle;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/SpeedChartActivity.java
public class HelSpeedActivity extends HelloChartActivity {

    private LineChartView chart;
    private LineChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helspeed);

        chart = (LineChartView)findViewById(R.id.hel_speed);

        generateSpeedData();
    }

    private void generateSpeedData() {
        // I got speed in range (0-55) and height in meters in range(200 - 300). I want this chart to display both
        // information. Differences between speed and height values are large and chart doesn't look good so I need
        // to modify height values to be in range of speed values.

        float speedRange = 55; // 속도  max
        float minHeight = 200; // 최소 높이
        float maxHeight = 300; // 최대 높이

        float scale = speedRange / maxHeight;
        float sub = (minHeight * scale) / 2;

        int numValues = 52; // data 개수

        Line line;
        List<PointValue> values;
        List<Line> lines = new ArrayList<Line>();

        // Height line, add it as first line to be drawn in the background.
        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random height values, add +200 to make line a little more natural
            float rawHeight = (float) (Math.random() * 100 + 200); // 최소값 200 추가
            float normalizedHeight = rawHeight * scale - sub;
            values.add(new PointValue(i, normalizedHeight));
        }

        line = new Line(values);
        line.setColor(Color.GRAY); // line chart 색
        line.setHasPoints(false); // data value point 생성
        line.setFilled(true); // 채우기색
        line.setStrokeWidth(1); // line 굵기
        lines.add(line);

        // Speed line
        values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) {
            // Some random speed values, add +20 to make line a little more natural.
            values.add(new PointValue(i, (float) Math.random() * 30 + 20));
        }

        line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN); // line 색
        line.setHasPoints(false); // data value point 생성
        line.setStrokeWidth(3); // line 굵기
        lines.add(line);

        // Data and axes
        data = new LineChartData(lines);

        // Distance axis(bottom X) with formatter that will ad [km] to values, remember to modify max label charts
        // value.
        Axis distanceAxis = new Axis();
        distanceAxis.setName("Distance"); // X축 이름
        distanceAxis.setTextColor(ChartUtils.COLOR_ORANGE); // X축 색
        distanceAxis.setMaxLabelChars(4);
        distanceAxis.setFormatter(new SimpleAxisValueFormatter().setAppendedText("km".toCharArray())); // X축 라벨에 "km" 추가
        distanceAxis.setHasLines(true); // 그리드 X축 line
        distanceAxis.setInside(true); // chart 안에 label 생성
        data.setAxisXBottom(distanceAxis);

        // Speed axis
        data.setAxisYLeft(new Axis().setName("Speed [km/h]").setHasLines(true).setMaxLabelChars(3) // 왼쪽 Y축 이름,그리드 Y축 line
                .setTextColor(ChartUtils.COLOR_RED).setInside(true)); // 색, chart 안쪽

        // Height axis, this axis need custom formatter that will translate values back to real height values.
        data.setAxisYRight(new Axis().setName("Height [m]").setMaxLabelChars(3).setTextColor(ChartUtils.COLOR_BLUE)// 오른쪽Y축 이름, 글자색
                .setFormatter(new HeightValueFormatter(scale, sub, 0)).setInside(true));

        // Set data
        chart.setLineChartData(data);

        // Important: adjust viewport, you could skip this step but in this case it will looks better with custom
        // viewport. Set
        // viewport with Y range 0-55;
        Viewport v = chart.getMaximumViewport();
        v.set(v.left, speedRange, v.right, 0);
        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);

    }

    private static class HeightValueFormatter extends SimpleAxisValueFormatter { // height format & calculate

        private float scale;
        private float sub;
        private int decimalDigits;

        public HeightValueFormatter(float scale, float sub, int decimalDigits) {
            this.scale = scale;
            this.sub = sub;
            this.decimalDigits = decimalDigits;
        }

        @Override
        public int formatValueForAutoGeneratedAxis(char[] formattedValue, float value, int autoDecimalDigits) {
            float scaledValue = (value + sub) / scale;
            return super.formatValueForAutoGeneratedAxis(formattedValue, scaledValue, this.decimalDigits);
        }
    }
}
