package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.Any.AnyAreaSelectActivity;
import com.example.severalchartguideapp.Any.AnyBarSelectActivity;
import com.example.severalchartguideapp.Any.AnyBoxActivity;
import com.example.severalchartguideapp.Any.AnyBubbleActivity;
import com.example.severalchartguideapp.Any.AnyBubbleMapActivity;
import com.example.severalchartguideapp.Any.AnyChoroplethMapActivity;
import com.example.severalchartguideapp.Any.AnyCircularGaugeActivity;
import com.example.severalchartguideapp.Any.AnyColumnSelectActivity;
import com.example.severalchartguideapp.Any.AnyCombinedActivity;
import com.example.severalchartguideapp.Any.AnyConnectorMapActivity;
import com.example.severalchartguideapp.Any.AnyFunnelActivity;


public class AnyAtoFActivity extends AnyChartActivity implements View.OnClickListener{

    private Button btnAnyAreaChart;
    private Button btnAnyBarChart;
    private Button btnAnyBoxChart;
    private Button btnAnyBubbleChart;
    private Button btnAnyBubbleMap;
    private Button btnAnyChoroplethMap;
    private Button btnAnyCircularGauge;
    private Button btnAnyColumnChart;
    private Button btnAnyCombinedChart;
    private Button btnAnyConnectorChart;
    private Button btnAnyFunnelChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyatof);

        btnAnyAreaChart = (Button) findViewById(R.id.anyareachart);
        btnAnyAreaChart.setOnClickListener(this);
        btnAnyBarChart = (Button) findViewById(R.id.anybarchart);
        btnAnyBarChart.setOnClickListener(this);
        btnAnyBoxChart = (Button) findViewById(R.id.anyboxchart);
        btnAnyBoxChart.setOnClickListener(this);
        btnAnyBubbleChart = (Button) findViewById(R.id.anybubblechart);
        btnAnyBubbleChart.setOnClickListener(this);
        btnAnyBubbleMap = (Button) findViewById(R.id.anybubblemap);
        btnAnyBubbleMap.setOnClickListener(this);
        btnAnyChoroplethMap = (Button) findViewById(R.id.anychoroplethmap);
        btnAnyChoroplethMap.setOnClickListener(this);
        btnAnyCircularGauge = (Button) findViewById(R.id.anycirculargauge);
        btnAnyCircularGauge.setOnClickListener(this);
        btnAnyColumnChart = (Button) findViewById(R.id.anycolumnchart);
        btnAnyColumnChart.setOnClickListener(this);
        btnAnyCombinedChart = (Button) findViewById(R.id.anycombinedchart);
        btnAnyCombinedChart.setOnClickListener(this);
        btnAnyConnectorChart = (Button) findViewById(R.id.anyconnectormap);
        btnAnyConnectorChart.setOnClickListener(this);
        btnAnyFunnelChart = (Button) findViewById(R.id.anyfunnelchart);
        btnAnyFunnelChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            // AreaChart 버튼 눌렀을 때
            case R.id.anyareachart:
                intent = new Intent(AnyAtoFActivity.this, AnyAreaSelectActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.anybarchart:
                intent = new Intent(AnyAtoFActivity.this, AnyBarSelectActivity.class);
                startActivity(intent);
                break;

            case R.id.anyboxchart:
                intent = new Intent(AnyAtoFActivity.this, AnyBoxActivity.class);
                startActivity(intent);
                break;

            case R.id.anybubblechart:
                intent = new Intent(AnyAtoFActivity.this, AnyBubbleActivity.class);
                startActivity(intent);
                break;

            case R.id.anybubblemap:
                intent = new Intent(AnyAtoFActivity.this, AnyBubbleMapActivity.class);
                startActivity(intent);
                break;

            case R.id.anychoroplethmap:
                intent = new Intent(AnyAtoFActivity.this, AnyChoroplethMapActivity.class);
                startActivity(intent);
                break;

            case R.id.anycirculargauge:
                intent = new Intent(AnyAtoFActivity.this, AnyCircularGaugeActivity.class);
                startActivity(intent);
                break;

            // ColumnChart 버튼 눌렀을 때
            case R.id.anycolumnchart:
                intent = new Intent(AnyAtoFActivity.this, AnyColumnSelectActivity.class);
                startActivity(intent);
                break;

            // CombinedChart 버튼 눌렀을 때
            case R.id.anycombinedchart:
                intent = new Intent(AnyAtoFActivity.this, AnyCombinedActivity.class);
                startActivity(intent);
                break;

            case R.id.anyconnectormap:
                intent = new Intent(AnyAtoFActivity.this, AnyConnectorMapActivity.class);
                startActivity(intent);
                break;

            case R.id.anyfunnelchart:
                intent = new Intent(AnyAtoFActivity.this, AnyFunnelActivity.class);
                startActivity(intent);
                break;
        }
    }
}
