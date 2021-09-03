package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.Any.AnyRadarActivity;
import com.example.severalchartguideapp.Any.AnyRangeActivity;
import com.example.severalchartguideapp.Any.AnyResourceActivity;
import com.example.severalchartguideapp.Any.AnyScatterActivity;
import com.example.severalchartguideapp.Any.AnySunburstActivity;
import com.example.severalchartguideapp.Any.AnyTagcloudActivity;
import com.example.severalchartguideapp.Any.AnyThermometerActivity;
import com.example.severalchartguideapp.Any.AnyTreemapActivity;
import com.example.severalchartguideapp.Any.AnyTwoPiesActivity;
import com.example.severalchartguideapp.Any.AnyVennDiagramActivity;
import com.example.severalchartguideapp.Any.AnyVerticalActivity;
import com.example.severalchartguideapp.Any.AnyWaterfallActivity;
import com.example.severalchartguideapp.Any.AnyWinddirectionActivity;
import com.example.severalchartguideapp.Any.AnyWindspeedActivity;

public class AnyRtoZActivity extends AnyChartActivity implements View.OnClickListener{

    private Button btnAnyRadarChart;
    private Button btnAnyRangeChart;
    private Button btnAnyResourceChart;
    private Button btnAnyScatterChart;
    private Button btnAnySunburstChart;
    private Button btnAnyTagCloudChart;
    private Button btnAnyThermometerChart;
    private Button btnAnyTreeMapChart;
    private Button btnAnyTwopiesChart;
    private Button btnAnyVenDiagramChart;
    private Button btnAnyVerticalChart;
    private Button btnAnyWaterfallChart;
    private Button btnAnyWindDirectionChart;
    private Button btnAnyWindSpeedChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyrtoz);

        btnAnyRadarChart = (Button) findViewById(R.id.anyradarchart);
        btnAnyRadarChart.setOnClickListener(this);
        btnAnyRangeChart = (Button) findViewById(R.id.anyrangechart);
        btnAnyRangeChart.setOnClickListener(this);
        btnAnyResourceChart = (Button) findViewById(R.id.anyresourcechart);
        btnAnyResourceChart.setOnClickListener(this);
        btnAnyScatterChart = (Button) findViewById(R.id.anyscatterchart);
        btnAnyScatterChart.setOnClickListener(this);
        btnAnySunburstChart = (Button) findViewById(R.id.anysunburstchart);
        btnAnySunburstChart.setOnClickListener(this);
        btnAnyTagCloudChart = (Button) findViewById(R.id.anytagcloud);
        btnAnyTagCloudChart.setOnClickListener(this);
        btnAnyThermometerChart = (Button) findViewById(R.id.anythermometer);
        btnAnyThermometerChart.setOnClickListener(this);
        btnAnyTreeMapChart = (Button) findViewById(R.id.anytreemapchart);
        btnAnyTreeMapChart.setOnClickListener(this);
        btnAnyTwopiesChart = (Button) findViewById(R.id.anytwopieschart);
        btnAnyTwopiesChart.setOnClickListener(this);
        btnAnyVenDiagramChart = (Button) findViewById(R.id.anyvenndiagram);
        btnAnyVenDiagramChart.setOnClickListener(this);
        btnAnyVerticalChart = (Button) findViewById(R.id.anyverticalchart);
        btnAnyVerticalChart.setOnClickListener(this);
        btnAnyWaterfallChart = (Button) findViewById(R.id.anywaterfallchart);
        btnAnyWaterfallChart.setOnClickListener(this);
        btnAnyWindDirectionChart = (Button) findViewById(R.id.anywinddirection);
        btnAnyWindDirectionChart.setOnClickListener(this);
        btnAnyWindSpeedChart = (Button) findViewById(R.id.anywindspeed);
        btnAnyWindSpeedChart.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.anyradarchart:
                intent = new Intent(AnyRtoZActivity.this, AnyRadarActivity.class);
                startActivity(intent);
                break;

            case R.id.anyrangechart:
                intent = new Intent(AnyRtoZActivity.this, AnyRangeActivity.class);
                startActivity(intent);
                break;

            case R.id.anyresourcechart:
                intent = new Intent(AnyRtoZActivity.this, AnyResourceActivity.class);
                startActivity(intent);
                break;

            case R.id.anyscatterchart:
                intent = new Intent(AnyRtoZActivity.this, AnyScatterActivity.class);
                startActivity(intent);
                break;

            case R.id.anysunburstchart:
                intent = new Intent(AnyRtoZActivity.this, AnySunburstActivity.class);
                startActivity(intent);
                break;

            case R.id.anytagcloud:
                intent = new Intent(AnyRtoZActivity.this, AnyTagcloudActivity.class);
                startActivity(intent);
                break;

            case R.id.anythermometer:
                intent = new Intent(AnyRtoZActivity.this, AnyThermometerActivity.class);
                startActivity(intent);
                break;

            case R.id.anytreemapchart:
                intent = new Intent(AnyRtoZActivity.this, AnyTreemapActivity.class);
                startActivity(intent);
                break;

            case R.id.anytwopieschart:
                intent = new Intent(AnyRtoZActivity.this, AnyTwoPiesActivity.class);
                startActivity(intent);
                break;

            case R.id.anyvenndiagram:
                intent = new Intent(AnyRtoZActivity.this, AnyVennDiagramActivity.class);
                startActivity(intent);
                break;

            case R.id.anyverticalchart:
                intent = new Intent(AnyRtoZActivity.this, AnyVerticalActivity.class);
                startActivity(intent);
                break;

            case R.id.anywaterfallchart:
                intent = new Intent(AnyRtoZActivity.this, AnyWaterfallActivity.class);
                startActivity(intent);
                break;

            case R.id.anywinddirection:
                intent = new Intent(AnyRtoZActivity.this, AnyWinddirectionActivity.class);
                startActivity(intent);
                break;

            case R.id.anywindspeed:
                intent = new Intent(AnyRtoZActivity.this, AnyWindspeedActivity.class);
                startActivity(intent);
                break;
        }
    }
}
