package com.example.severalchartguideapp.Hello;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/LineChartActivity.java
public class HelLineforActivity extends HelloChartActivity {

    private LineChartView lineChart;
    private LineChartData data;

    private int maxNumberOfLines = 4;
    private int numberOfPoints = 20;
    private int numberOfLines = 1; // dataset 수

    private boolean pointsHaveDifferentColor;
    private boolean hasGradientToTransparent = false;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellinefor);


        lineChart = (LineChartView)findViewById(R.id.hel_line_chart2);

        generateValues();
        generateData();

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

        lineChart.setInteractive(true); // 화면 움직이기 속성 설정
        lineChart.setZoomType(ZoomType.HORIZONTAL);  //수평 이동
        lineChart.setMaxZoom((float) 3);//화면 비율
        lineChart.setLineChartData(data);  // chart에 라벨 설정까지 된 data insert
        lineChart.setVisibility(View.VISIBLE); // 화면 보이기/안 보이기

        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        lineChart.setCurrentViewport(v);
    }

    private void generateValues() { // Y축 value
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }
    }

    private void generateData() {  // data value

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i + 2]); // line 색 설정
            line.setShape(ValueShape.CIRCLE); // 그래프의 데이터 점 모양 (SQUARE CIRCLE DIAMOND）
            line.setCubic(false); // line 부드럽게?
            line.setFilled(false); // 채우기
            line.setHasLabels(true); // data label 표시
            line.setHasLabelsOnlyForSelected(false); // 클릭할 때만 라벨 표시
            line.setHasLines(true); // 직선 표시
            line.setHasPoints(true); // data point 표시

            lines.add(line);
        }
        data = new LineChartData(lines); // chart data 선언
        data.setLines(lines); // data에 lines(List) insert
    }
}
