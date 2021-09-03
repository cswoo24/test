package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.Any.AnyGanttActivity;
import com.example.severalchartguideapp.Any.AnyHeatMapActivity;
import com.example.severalchartguideapp.Any.AnyHiloActivity;
import com.example.severalchartguideapp.Any.AnyLineActivity;
import com.example.severalchartguideapp.Any.AnyLinearColorScaleActivity;
import com.example.severalchartguideapp.Any.AnyMekkoActivity;
import com.example.severalchartguideapp.Any.AnyMosaicActivity;
import com.example.severalchartguideapp.Any.AnyOHLCActivity;
import com.example.severalchartguideapp.Any.AnyParetoActivity;
import com.example.severalchartguideapp.Any.AnyPertActivity;
import com.example.severalchartguideapp.Any.AnyPieActivity;
import com.example.severalchartguideapp.Any.AnyPointMapActivity;
import com.example.severalchartguideapp.Any.AnyPolarActivity;
import com.example.severalchartguideapp.Any.AnyPyramidActivity;
import com.example.severalchartguideapp.Any.AnyQuadrantActivity;


public class AnyGtoQActivity extends AnyChartActivity implements View.OnClickListener{

    private Button btnAnyGanttChart;
    private Button btnAnyHeatMap;
    private Button btnAnyHiloChart;
    private Button btnAnyLineChart;
    private Button btnAnyLinearColorScale;
    private Button btnAnyMekkoChart;
    private Button btnAnyMosaicChart;
    private Button btnAnyOHLCChart;
    private Button btnAnyParetoChart;
    private Button btnAnyPertChart;
    private Button btnAnyPieChart;
    private Button btnAnyPointMap;
    private Button btnAnyPolarChart;
    private Button btnAnyPyramid;
    private Button btnAnyQuadrantChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anygtoq);

        btnAnyGanttChart = (Button) findViewById(R.id.anyganttchart);
        btnAnyGanttChart.setOnClickListener(this);
        btnAnyHeatMap = (Button) findViewById(R.id.anyheatmapchart);
        btnAnyHeatMap.setOnClickListener(this);
        btnAnyHiloChart = (Button) findViewById(R.id.anyhilochart);
        btnAnyHiloChart.setOnClickListener(this);
        btnAnyLineChart = (Button) findViewById(R.id.anylinechart);
        btnAnyLineChart.setOnClickListener(this);
        btnAnyLinearColorScale = (Button) findViewById(R.id.anylinearcolorscale);
        btnAnyLinearColorScale.setOnClickListener(this);
        btnAnyMekkoChart = (Button) findViewById(R.id.anymekkochart);
        btnAnyMekkoChart.setOnClickListener(this);
        btnAnyMosaicChart = (Button) findViewById(R.id.anymosaicchart);
        btnAnyMosaicChart.setOnClickListener(this);
        btnAnyOHLCChart = (Button) findViewById(R.id.anyohlcchart);
        btnAnyOHLCChart.setOnClickListener(this);
        btnAnyParetoChart = (Button) findViewById(R.id.anyparetochart);
        btnAnyParetoChart.setOnClickListener(this);
        btnAnyPertChart = (Button) findViewById(R.id.anypertchart);
        btnAnyPertChart.setOnClickListener(this);
        btnAnyPieChart = (Button) findViewById(R.id.anypiechart);
        btnAnyPieChart.setOnClickListener(this);
        btnAnyPointMap = (Button) findViewById(R.id.anypointmap);
        btnAnyPointMap.setOnClickListener(this);
        btnAnyPolarChart = (Button) findViewById(R.id.anypolarchart);
        btnAnyPolarChart.setOnClickListener(this);
        btnAnyPyramid = (Button) findViewById(R.id.anypyramid);
        btnAnyPyramid.setOnClickListener(this);
        btnAnyQuadrantChart = (Button) findViewById(R.id.anyquadrantchart);
        btnAnyQuadrantChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.anyganttchart:
                intent = new Intent(AnyGtoQActivity.this, AnyGanttActivity.class);
                startActivity(intent);
                break;

            case R.id.anyheatmapchart:
                intent = new Intent(AnyGtoQActivity.this, AnyHeatMapActivity.class);
                startActivity(intent);
                break;

            case R.id.anyhilochart:
                intent = new Intent(AnyGtoQActivity.this, AnyHiloActivity.class);
                startActivity(intent);
                break;

            // LineChart 버튼 눌렀을 때
            case R.id.anylinechart:
                intent = new Intent(AnyGtoQActivity.this, AnyLineActivity.class);
                startActivity(intent);
                break;

            case R.id.anylinearcolorscale:
                intent = new Intent(AnyGtoQActivity.this, AnyLinearColorScaleActivity.class);
                startActivity(intent);
                break;

            case R.id.anymekkochart:
                intent = new Intent(AnyGtoQActivity.this, AnyMekkoActivity.class);
                startActivity(intent);
                break;

            case R.id.anymosaicchart:
                intent = new Intent(AnyGtoQActivity.this, AnyMosaicActivity.class);
                startActivity(intent);
                break;

            case R.id.anyohlcchart:
                intent = new Intent(AnyGtoQActivity.this, AnyOHLCActivity.class);
                startActivity(intent);
                break;

            case R.id.anyparetochart:
                intent = new Intent(AnyGtoQActivity.this, AnyParetoActivity.class);
                startActivity(intent);
                break;

            case R.id.anypertchart:
                intent = new Intent(AnyGtoQActivity.this, AnyPertActivity.class);
                startActivity(intent);
                break;

            case R.id.anypiechart:
                intent = new Intent(AnyGtoQActivity.this, AnyPieActivity.class);
                startActivity(intent);
                break;

            case R.id.anypointmap:
                intent = new Intent(AnyGtoQActivity.this, AnyPointMapActivity.class);
                startActivity(intent);
                break;

            case R.id.anypolarchart:
                intent = new Intent(AnyGtoQActivity.this, AnyPolarActivity.class);
                startActivity(intent);
                break;

            case R.id.anypyramid:
                intent = new Intent(AnyGtoQActivity.this, AnyPyramidActivity.class);
                startActivity(intent);
                break;

            case R.id.anyquadrantchart:
                intent = new Intent(AnyGtoQActivity.this, AnyQuadrantActivity.class);
                startActivity(intent);
                break;
        }
    }
}
