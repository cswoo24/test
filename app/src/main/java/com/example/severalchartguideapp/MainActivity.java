package com.example.severalchartguideapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnMPAndroidChart;
    private Button btnHelloCharts;
    private Button btnAnyChart;
    private Button btnwilliamchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMPAndroidChart = (Button) findViewById(R.id.MPAndroidChart);
        btnMPAndroidChart.setOnClickListener(this);

        btnHelloCharts = (Button) findViewById(R.id.HelloCharts);
        btnHelloCharts.setOnClickListener(this);

        btnAnyChart = (Button) findViewById(R.id.AnyChart);
        btnAnyChart.setOnClickListener(this);

        btnwilliamchart = (Button) findViewById(R.id.williamchart);
        btnwilliamchart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            // LineChart 버튼 눌렀을 때
            case R.id.MPAndroidChart:
                intent = new Intent(MainActivity.this, MPAndroidChartActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.HelloCharts:
                intent = new Intent(MainActivity.this, HelloChartActivity.class);
                startActivity(intent);
                break;

            // HorizontalBarChart 버튼 눌렀을 때
            case R.id.AnyChart:
                intent = new Intent(MainActivity.this, AnyChartActivity.class);
                startActivity(intent);
                break;

            // CombinedChart 버튼 눌렀을 때
            case R.id.williamchart:
                intent = new Intent(MainActivity.this, WilliamChartActivity.class);
                startActivity(intent);
                break;
        }
    }
}