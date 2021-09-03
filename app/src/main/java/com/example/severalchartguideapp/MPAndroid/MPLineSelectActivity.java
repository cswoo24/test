package com.example.severalchartguideapp.MPAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

public class MPLineSelectActivity extends MPAndroidChartActivity implements View.OnClickListener{

    private Button btnMPLineChart;
    private Button btnMPLineChartDual;
    private Button btnFilledLineChart;
    private Button btnInvertedLineChart;
    private Button btnLineColoredChart;
    private Button btnLineTimeChart;
    private Button btnPerformanceLineChart;
    private Button btnRealTimeLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mplineselect);

        btnMPLineChart = (Button) findViewById(R.id.MPLineChart);
        btnMPLineChart.setOnClickListener(this);

        btnMPLineChartDual = (Button) findViewById(R.id.MPLineChartDual);
        btnMPLineChartDual.setOnClickListener(this);

        btnFilledLineChart = (Button) findViewById(R.id.FilledLineChart);
        btnFilledLineChart.setOnClickListener(this);

        btnInvertedLineChart = (Button) findViewById(R.id.InvertedLineChart);
        btnInvertedLineChart.setOnClickListener(this);

        btnLineColoredChart = (Button) findViewById(R.id.LineColoredChart);
        btnLineColoredChart.setOnClickListener(this);

        btnLineTimeChart = (Button) findViewById(R.id.LineTimeChart);
        btnLineTimeChart.setOnClickListener(this);

        btnPerformanceLineChart = (Button) findViewById(R.id.PerformanceLineChart);
        btnPerformanceLineChart.setOnClickListener(this);

        btnRealTimeLineChart = (Button) findViewById(R.id.RealTimeLineChart);
        btnRealTimeLineChart.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            // LineChart 버튼 눌렀을 때
            case R.id.MPLineChart:
                intent = new Intent(MPLineSelectActivity.this, MPLineActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.MPLineChartDual:
                intent = new Intent(MPLineSelectActivity.this, MPMultiLineActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.FilledLineChart:
                intent = new Intent(MPLineSelectActivity.this, MPFilledLineActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.InvertedLineChart:
                intent = new Intent(MPLineSelectActivity.this, MPInvertedLineActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.LineColoredChart:
                intent = new Intent(MPLineSelectActivity.this, MPLineColoredActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.LineTimeChart:
                intent = new Intent(MPLineSelectActivity.this, MPLineTimeActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.PerformanceLineChart:
                intent = new Intent(MPLineSelectActivity.this, MPPerformancelineActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.RealTimeLineChart:
                intent = new Intent(MPLineSelectActivity.this, MPRealTimelineActivity.class);
                startActivity(intent);
                break;


        }
    }
}
