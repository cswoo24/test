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
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.ComboLineColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ComboLineColumnChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/ComboLineColumnChartActivity.java
public class HelComboActivity extends HelloChartActivity {

    private ComboLineColumnChartView chart;
    private ComboLineColumnChartData data;
    private int numberOfLines = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 12;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helcombo);

        chart = (ComboLineColumnChartView)findViewById(R.id.hel_combo);

        generateValues();
        generateData();

        Axis axisX = new Axis(); // X축
        axisX.setHasTiltedLabels(true);  // X축 라벨 글자 기울이기
//	    axisX.setTextColor(Color.WHITE);  //
        axisX.setTextColor(Color.parseColor("#D6D6D9")); // 글자 색

        axisX.setName("");  // X축 제목
        axisX.setTextSize(15); // X축 글자 크기
        axisX.setMaxLabelChars(7); // X축의 최대 좌표
        //data.setAxisXBottom(axisX); //x축 하단
	    data.setAxisXTop(axisX);  //x축 상단
        axisX.setHasLines(true); // X축 그리드 line


        Axis axisY = new Axis();  //Y축
        axisY.setName("");//y축 제목
        axisY.setTextSize(15);//글자 크기
        //data.setAxisYLeft(axisY);  // Y축 왼쪽
        data.setAxisYRight(axisY);  //y축 오른쪽

        chart.setInteractive(true); // 화면 움직이기 속성 설정
        chart.setZoomType(ZoomType.HORIZONTAL);  //수평 이동
        chart.setMaxZoom((float) 3);//화면 비율
        //chart.setLineChartData(data);  // chart에 라벨 설정까지 된 data insert
        chart.setVisibility(View.VISIBLE); // 화면 보이기/안 보이기

        chart.setValueSelectionEnabled(true);

        Viewport v = new Viewport(chart.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        chart.setCurrentViewport(v);
    }

    private void generateValues() {
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 40f + 5;
            }
        }
    }

    private void generateData() {
        // Chart looks the best when line data and column data have similar maximum viewports.
        data = new ComboLineColumnChartData(generateColumnData(), generateLineData()); // column data, linedata 합성

        Axis axisX = new Axis();
        Axis axisY = new Axis().setHasLines(true); // Y축 line

        axisX.setName("Axis X"); // X축 제목
        axisY.setName("Axis Y"); // Y축 제목

        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);

        //data.setColumnChartData(generateColumnData());
        //data.setLineChartData(generateLineData());

        chart.setComboLineColumnChartData(data);

    }

    private LineChartData generateLineData() { // line data 생성

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i]); // line 색
            line.setCubic(true); // line 부드럽게 할 건지
            line.setHasLabels(true); // data value 볼건지
            line.setHasLines(true); // line 사용할건지 아닌지
            line.setHasPoints(true); // data 위치에 point 사용할건지
            lines.add(line);
        }

        LineChartData lineChartData = new LineChartData(lines);
        //lineChartData.setLines(lines);

        return lineChartData;

    }

    private ColumnChartData generateColumnData() { // column data 생성
        int numSubcolumns = 1;
        int numColumns = 12;
        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50 + 5, ChartUtils.COLOR_GREEN)); //data value, 색 설정
            }

            Column column = new Column(values);
            column.setHasLabels(true); // data value 보기
            column.setHasLabelsOnlyForSelected(false); // data 값 선택될때만 보이게 할 건지
            columns.add(column);

        }

        ColumnChartData columnChartData = new ColumnChartData(columns);
        //columnChartData.setColumns(columns);
        return columnChartData;
    }
}

