package com.example.severalchartguideapp.MPAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;

public class MPBarSelectActivity extends MPAndroidChartActivity implements View.OnClickListener{

    private Button btnMPBarChart;
    private Button btnMPGourpBarChart;
    private Button btnMPStackBarChart;
    private Button btnMPBarPosNegChart;
    private Button btnHorizontalBarChart;
    private Button btnHorizontalNegChart;
    private Button btnMPBarSinusChart;
    private Button btnMPBarSinCosChart;
    private Button btnMPStackNegChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mpbarselect);

        btnMPBarChart = (Button) findViewById(R.id.MPBarChart);
        btnMPBarChart.setOnClickListener(this);

        btnMPGourpBarChart = (Button) findViewById(R.id.MPGroupBarChart);
        btnMPGourpBarChart.setOnClickListener(this);

        btnMPStackBarChart = (Button) findViewById(R.id.MPStackBarChart);
        btnMPStackBarChart.setOnClickListener(this);

        btnMPBarPosNegChart = (Button) findViewById(R.id.MPBarPosNegChart);
        btnMPBarPosNegChart.setOnClickListener(this);

        btnHorizontalBarChart = (Button) findViewById(R.id.MPHorizontalBarChart);
        btnHorizontalBarChart.setOnClickListener(this);

        btnHorizontalNegChart = (Button) findViewById(R.id.MPHorizontalNegChart);
        btnHorizontalNegChart.setOnClickListener(this);

        btnMPBarSinusChart = (Button) findViewById(R.id.MPBarSinusChart);
        btnMPBarSinusChart.setOnClickListener(this);

        btnMPStackNegChart = (Button) findViewById(R.id.MPStackNegChart);
        btnMPStackNegChart.setOnClickListener(this);

        btnMPBarSinCosChart = (Button) findViewById(R.id.MPBarSinCosChart);
        btnMPBarSinCosChart.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            // LineChart 버튼 눌렀을 때
            case R.id.MPBarChart:
                intent = new Intent(MPBarSelectActivity.this, MPBarActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.MPGroupBarChart:
                intent = new Intent(MPBarSelectActivity.this, MPGroupBarActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.MPStackBarChart:
                intent = new Intent(MPBarSelectActivity.this, MPStackBarActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.MPBarPosNegChart:
                intent = new Intent(MPBarSelectActivity.this, MPBarPosNegActivity.class);
                startActivity(intent);
                break;

            // HorizontalBarChart 버튼 눌렀을 때
            case R.id.MPHorizontalBarChart:
                intent = new Intent(MPBarSelectActivity.this, MPHorizontalBarActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPHorizontalNegChart:
                intent = new Intent(MPBarSelectActivity.this, MPHorizontalNegActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPBarSinusChart:
                intent = new Intent(MPBarSelectActivity.this, MPBarSinusActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPStackNegChart:
                intent = new Intent(MPBarSelectActivity.this, MPStackedNegActivity.class);
                startActivity(intent);
                break;

            // BubbleChart 버튼 눌렀을 때
            case R.id.MPBarSinCosChart:
                intent = new Intent(MPBarSelectActivity.this, MPBarSineCosineActivity.class);
                startActivity(intent);
                break;
        }
    }
}