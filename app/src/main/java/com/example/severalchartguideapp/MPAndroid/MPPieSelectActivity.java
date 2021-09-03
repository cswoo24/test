package com.example.severalchartguideapp.MPAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

public class MPPieSelectActivity extends MPAndroidChartActivity implements View.OnClickListener{

    private Button btnPieChart;
    private Button btnHalfPieChart;
    private Button btnPiePolyLineChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mppieselect);

        btnPieChart = (Button) findViewById(R.id.MPPieChart);
        btnPieChart.setOnClickListener(this);

        btnHalfPieChart = (Button) findViewById(R.id.MPHalfPieChart);
        btnHalfPieChart.setOnClickListener(this);

        btnPiePolyLineChart = (Button) findViewById(R.id.MPPiePolylineChart);
        btnPiePolyLineChart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            // PieChart 버튼 눌렀을 때
            case R.id.MPPieChart:
                intent = new Intent(MPPieSelectActivity.this, MPPieActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPHalfPieChart:
                intent = new Intent(MPPieSelectActivity.this, MPHalfPieActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPPiePolylineChart:
                intent = new Intent(MPPieSelectActivity.this, MPPiePolylineActivity.class);
                startActivity(intent);
                break;
        }
    }
}
