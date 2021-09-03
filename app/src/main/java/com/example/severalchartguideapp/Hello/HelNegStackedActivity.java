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
public class HelNegStackedActivity extends HelloChartActivity {

    private ColumnChartView negstackedchart;
    private ColumnChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helnegstacked);

        negstackedchart = (ColumnChartView)findViewById(R.id.hel_neg_stacked);

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

        negstackedchart.setInteractive(true); // 화면 움직이기 속성 설정
        negstackedchart.setZoomType(ZoomType.HORIZONTAL);  //수평 이동
        negstackedchart.setMaxZoom((float) 3);//화면 비율
        negstackedchart.setColumnChartData(data); // chart에 라벨 설정까지 된 data insert
        negstackedchart.setVisibility(View.VISIBLE); // 화면 보이기/안 보이기
/*
        Viewport v = new Viewport(negstackedchart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        negstackedchart.setCurrentViewport(v);*/
    }

    private void generateData() {
        int numSubcolumns = 4; // 1개의 Xlabel 에 속한 column 개수
        int numColumns = 8; // 전체 X축 Label 개수
        // Column can have many stacked subcolumns, here I use 4 stacke subcolumn in each of 4 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                int sign = getSign();
                values.add(new SubcolumnValue((float) Math.random() * 20f * sign + 5 * sign, ChartUtils.COLORS[j]));
            }

            Column column = new Column(values);
            column.setHasLabels(true); // label 볼 지 여부
            column.setHasLabelsOnlyForSelected(false); // 선택될 때만 value값 보일지
            columns.add(column);

            data = new ColumnChartData(columns);
            data.setColumns(columns);
            data.setStacked(true);
        }
    }

    private int getSign() { // data +/- 생성 위한 메서드
        int[] sign = new int[]{-1, 1};
        return sign[Math.round((float) Math.random())];
    }
}
