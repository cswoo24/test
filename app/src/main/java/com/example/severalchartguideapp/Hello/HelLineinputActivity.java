package com.example.severalchartguideapp.Hello;

import android.graphics.Color;
import android.os.Bundle;;
import android.view.View;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

//기존 라이브러리 참고해 새로 만듬
//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/LineChartActivity.java
public class HelLineinputActivity extends HelloChartActivity {

    private LineChartView lineChart;

    String[] date = {"5-23","5-22","6-22","5-23","5-22","2-22","5-22","4-22","9-22","10-22","11-22","12-22","1-22","6-22","5-23","5-22","2-22","5-22","4-22","9-22","10-22","11-22","12-22","4-22","9-22","10-22","11-22","zxc"}; //X축 label
    int[] score= {74,22,18,79,20,74,20,74,42,90,74,42,90,50,42,90,33,10,74,22,18,79,20,74,22,18,79,20}; // data value
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helline);

        lineChart = (LineChartView)findViewById(R.id.hel_line_chart);
        getAxisXLables(); // X축 라벨(date)
        getAxisPoints(); // Y축(score)
        initLineChart(); // chart 생성
    }

    private void initLineChart(){
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  // line 색
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE); // 그래프의 데이터 점 모양 (SQUARE CIRCLE DIAMOND）
        line.setCubic(false); // line 부드럽게
	    line.setStrokeWidth(3); // line 너비
        line.setFilled(false); // 채우기
        line.setHasLabels(true); // data label 표시
		line.setHasLabelsOnlyForSelected(false); // 클릭할 때만 라벨 표시
        line.setHasLines(true); // 직선 표시
        line.setHasPoints(true); // data point 표시
        lines.add(line); // list에 line 추가
        LineChartData data = new LineChartData(); // chart data 선언
        data.setLines(lines); // data에 lines(List) insert


        Axis axisX = new Axis(); // X축
        axisX.setHasTiltedLabels(true);  // X축 라벨 글자 기울이기
//	    axisX.setTextColor(Color.WHITE);  //
        axisX.setTextColor(Color.parseColor("#D6D6D9")); // 글자 색

	    axisX.setName("");  // X축 제목
        axisX.setTextSize(11); // X축 글자 크기
        axisX.setMaxLabelChars(7); // X축의 최대 좌표
        axisX.setValues(mAxisXValues);  // X축 label insert
        data.setAxisXBottom(axisX); //x축 하단
//	    data.setAxisXTop(axisX);  //x축 상단
        axisX.setHasLines(true); // X축 그리드 line


        Axis axisY = new Axis();  //Y축
        axisY.setName("");//y축 제목
        axisY.setTextSize(11);//글자 크기
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


    private void getAxisXLables(){ // Arraylist mAxisXValues에 배열 date insert
        for (int i = 0; i < date.length; i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }

    private void getAxisPoints(){  // Arraylist mPointValues에 배열 score insert
        for (int i = 0; i < score.length; i++) {
            mPointValues.add(new PointValue(i, score[i]));
        }
    }
}
