package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.Hello.HelBubbleActivity;
import com.example.severalchartguideapp.Hello.HelColumnSelectActivity;

import com.example.severalchartguideapp.Hello.HelComboSelectActivity;
import com.example.severalchartguideapp.Hello.HelGoodBadActivity;

import com.example.severalchartguideapp.Hello.HelLineSelectActivity;
import com.example.severalchartguideapp.Hello.HelPieActivity;
import com.example.severalchartguideapp.Hello.HelPreviewSelectActivity;
import com.example.severalchartguideapp.Hello.HelSpeedActivity;
import com.example.severalchartguideapp.Hello.HelTempoActivity;

//https://github.com/lecho/hellocharts-android
public class HelloChartActivity extends MainActivity implements View.OnClickListener{

    private Button btnHelloLineChart;
    private Button btnHelloColumnChart;
    private Button btnHelloComboChart;
    private Button btnHelloGoodBadChart;
    private Button btnHelloPieChart;
    private Button btnHelloPreviewChart;
    private Button btnHelloSpeedChart;
    private Button btnHelloTempoChart;
    private Button btnHelloBubbleChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helchart);

        btnHelloLineChart = (Button) findViewById(R.id.helloline);
        btnHelloLineChart.setOnClickListener(this);

        btnHelloColumnChart = (Button) findViewById(R.id.hellocolumn);
        btnHelloColumnChart.setOnClickListener(this);

        btnHelloComboChart = (Button) findViewById(R.id.hellocombo);
        btnHelloComboChart.setOnClickListener(this);

        btnHelloGoodBadChart = (Button) findViewById(R.id.hellogoodbad);
        btnHelloGoodBadChart.setOnClickListener(this);


        btnHelloPieChart = (Button) findViewById(R.id.hellopie);
        btnHelloPieChart.setOnClickListener(this);

        btnHelloPreviewChart = (Button) findViewById(R.id.hellopreview);
        btnHelloPreviewChart.setOnClickListener(this);

        btnHelloSpeedChart = (Button) findViewById(R.id.hellospeed);
        btnHelloSpeedChart.setOnClickListener(this);

        btnHelloTempoChart = (Button) findViewById(R.id.hellotempo);
        btnHelloTempoChart.setOnClickListener(this);

        btnHelloBubbleChart = (Button) findViewById(R.id.hellobubble);
        btnHelloBubbleChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.helloline:
                intent = new Intent(HelloChartActivity.this, HelLineSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.hellocolumn:
                intent = new Intent(HelloChartActivity.this, HelColumnSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.hellocombo:
                intent = new Intent(HelloChartActivity.this, HelComboSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.hellogoodbad:
                intent = new Intent(HelloChartActivity.this, HelGoodBadActivity.class);
                startActivity(intent);
                break;

            case R.id.hellopie:
                intent = new Intent(HelloChartActivity.this, HelPieActivity.class);
                startActivity(intent);
                break;

            case R.id.hellopreview:
                intent = new Intent(HelloChartActivity.this, HelPreviewSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.hellospeed:
                intent = new Intent(HelloChartActivity.this, HelSpeedActivity.class);
                startActivity(intent);
                break;

            case R.id.hellotempo:
                intent = new Intent(HelloChartActivity.this, HelTempoActivity.class);
                startActivity(intent);
                break;

            case R.id.hellobubble:
                intent = new Intent(HelloChartActivity.this, HelBubbleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
