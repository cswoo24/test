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
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

// 기존 라이브러리에 Column Chart 5개 종류가 있어 하나씩 빼서 만듬
//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/ColumnChartActivity.java
public class HelSubColumnActivity extends HelloChartActivity {

    private ColumnChartView subcolumnchart;
    private ColumnChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helsubcolumn);

        subcolumnchart = (ColumnChartView)findViewById(R.id.hel_subcolumn);

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

        subcolumnchart.setInteractive(true); // 화면 움직이기 속성 설정
        subcolumnchart.setZoomType(ZoomType.HORIZONTAL);  //수평 이동
        subcolumnchart.setMaxZoom((float) 3);//화면 비율
        subcolumnchart.setColumnChartData(data); // chart에 라벨 설정까지 된 data insert
        subcolumnchart.setVisibility(View.VISIBLE); // 화면 보이기/안 보이기

        /*Viewport v = new Viewport(subcolumnchart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        subcolumnchart.setCurrentViewport(v);*/
    }

    private void generateData() {
        int numSubcolumns = 4;
        int numColumns = 4;
        // Column can have many subcolumns, here I use 4 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.COLORS[j]));
            }

            Column column = new Column();
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(false);
            column.setValues(values);
            columns.add(column);

            data = new ColumnChartData(columns);
            data.setColumns(columns);
        }
    }
}