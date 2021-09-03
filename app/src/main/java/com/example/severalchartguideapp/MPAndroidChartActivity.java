package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.MPAndroid.MPBarSelectActivity;
import com.example.severalchartguideapp.MPAndroid.MPBarSineCosineActivity;
import com.example.severalchartguideapp.MPAndroid.MPBubbleActivity;
import com.example.severalchartguideapp.MPAndroid.MPCandleStickActivity;
import com.example.severalchartguideapp.MPAndroid.MPCombinedActivity;
import com.example.severalchartguideapp.MPAndroid.MPDrawActivity;
import com.example.severalchartguideapp.MPAndroid.MPDynamicAddLineActivity;
import com.example.severalchartguideapp.MPAndroid.MPLineSelectActivity;
import com.example.severalchartguideapp.MPAndroid.MPPerformancelineActivity;
import com.example.severalchartguideapp.MPAndroid.MPPieSelectActivity;
import com.example.severalchartguideapp.MPAndroid.MPRadarActivity;
import com.example.severalchartguideapp.MPAndroid.MPScatterActivity;
import com.example.severalchartguideapp.MPAndroid.MPScrollViewActivity;

//https://github.com/PhilJay/MPAndroidChart
public class MPAndroidChartActivity extends MainActivity implements View.OnClickListener{

    private Button btnLineChart;
    private Button btnBarChart;
    private Button btnPieChart;
    private Button btnCombinedChart;
    private Button btnRaderChart;
    private Button btnScatterChart;
    private Button btnCandleStickChart;
    private Button btnBubbleChart;
    private Button btnScrollViewChart;
    private Button btnDynamicAddChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroidchart);

        btnLineChart = (Button) findViewById(R.id.LineChart);
        btnLineChart.setOnClickListener(this);

        btnBarChart = (Button) findViewById(R.id.BarChart);
        btnBarChart.setOnClickListener(this);

        btnPieChart = (Button) findViewById(R.id.PieChart);
        btnPieChart.setOnClickListener(this);

        btnCombinedChart = (Button) findViewById(R.id.CombinedChart);
        btnCombinedChart.setOnClickListener(this);

        btnRaderChart = (Button) findViewById(R.id.RadarChart);
        btnRaderChart.setOnClickListener(this);

        btnScatterChart = (Button) findViewById(R.id.ScatterChart);
        btnScatterChart.setOnClickListener(this);

        btnCandleStickChart = (Button) findViewById(R.id.CandleStickChart);
        btnCandleStickChart.setOnClickListener(this);

        btnBubbleChart = (Button) findViewById(R.id.BubbleChart);
        btnBubbleChart.setOnClickListener(this);

        btnScrollViewChart = (Button) findViewById(R.id.ScrollViewChart);
        btnScrollViewChart.setOnClickListener(this);

        btnDynamicAddChart = (Button) findViewById(R.id.DynamicAddChart);
        btnDynamicAddChart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            // LineChart 버튼 눌렀을 때
            case R.id.LineChart:
                intent = new Intent(MPAndroidChartActivity.this, MPLineSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.BarChart:
                intent = new Intent(MPAndroidChartActivity.this, MPBarSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.CombinedChart:
                intent = new Intent(MPAndroidChartActivity.this, MPCombinedActivity.class);
                startActivity(intent);
                break;

            case R.id.PieChart:
                intent = new Intent(MPAndroidChartActivity.this, MPPieSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.RadarChart:
                intent = new Intent(MPAndroidChartActivity.this, MPRadarActivity.class);
                startActivity(intent);
                break;

            case R.id.ScatterChart:
                intent = new Intent(MPAndroidChartActivity.this, MPScatterActivity.class);
                startActivity(intent);
                break;

            case R.id.CandleStickChart:
                intent = new Intent(MPAndroidChartActivity.this, MPCandleStickActivity.class);
                startActivity(intent);
                break;

            case R.id.BubbleChart:
                intent = new Intent(MPAndroidChartActivity.this, MPBubbleActivity.class);
                startActivity(intent);
                break;

            case R.id.ScrollViewChart:
                intent = new Intent(MPAndroidChartActivity.this, MPScrollViewActivity.class);
                startActivity(intent);
                break;

            case R.id.DynamicAddChart:
                intent = new Intent(MPAndroidChartActivity.this, MPDynamicAddLineActivity.class);
                startActivity(intent);
                break;
        }
    }
}
