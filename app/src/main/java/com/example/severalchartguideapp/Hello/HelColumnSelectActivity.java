package com.example.severalchartguideapp.Hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

public class HelColumnSelectActivity extends HelloChartActivity implements View.OnClickListener{

    private Button btnHelloColumnChart;
    private Button btnHelloSubColumnChart;
    private Button btnHelloStackedChart;
    private Button btnHelloNegSubColumnChart;
    private Button btnHelloNegStackedChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helcolumnselect);

        btnHelloColumnChart = (Button) findViewById(R.id.helcolumn);
        btnHelloColumnChart.setOnClickListener(this);

        btnHelloSubColumnChart = (Button) findViewById(R.id.helsubcolumn);
        btnHelloSubColumnChart.setOnClickListener(this);

        btnHelloStackedChart = (Button) findViewById(R.id.helstacked);
        btnHelloStackedChart.setOnClickListener(this);

        btnHelloNegSubColumnChart = (Button) findViewById(R.id.helnegsubcolumn);
        btnHelloNegSubColumnChart.setOnClickListener(this);

        btnHelloNegStackedChart = (Button) findViewById(R.id.helnegstacked);
        btnHelloNegStackedChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.helcolumn:
                intent = new Intent(HelColumnSelectActivity.this, HelColumnActivity.class);
                startActivity(intent);
                break;

            case R.id.helsubcolumn:
                intent = new Intent(HelColumnSelectActivity.this, HelSubColumnActivity.class);
                startActivity(intent);
                break;

            case R.id.helstacked:
                intent = new Intent(HelColumnSelectActivity.this, HelStackedActivity.class);
                startActivity(intent);
                break;

            case R.id.helnegsubcolumn:
                intent = new Intent(HelColumnSelectActivity.this, HelNegSubColumnActivity.class);
                startActivity(intent);
                break;

            case R.id.helnegstacked:
                intent = new Intent(HelColumnSelectActivity.this, HelNegStackedActivity.class);
                startActivity(intent);
                break;

        }
    }
}