package com.example.severalchartguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.William.WilBarSelectActivity;
import com.example.severalchartguideapp.William.WilLineSelectActivity;
import com.example.severalchartguideapp.William.WilStackBarSelectActivity;

//
// 제작자가 Kotlin으로 제작하여 Java 로 된 SourceCode 찾아서 만듬
// https://github.com/abhirocks1211/WilliamChart
//

public class WilliamChartActivity extends MainActivity implements View.OnClickListener {

    private Button btnWilLineChart;
    private Button btnWilBarChart;
    private Button btnWilStackBarChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_william);

        btnWilLineChart = (Button) findViewById(R.id.willine);
        btnWilLineChart.setOnClickListener(this);
        btnWilBarChart = (Button) findViewById(R.id.wilbar);
        btnWilBarChart.setOnClickListener(this);
        btnWilStackBarChart = (Button) findViewById(R.id.wilstacked);
        btnWilStackBarChart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            // BarChart 버튼 눌렀을 때
            case R.id.willine:
                intent = new Intent(WilliamChartActivity.this, WilLineSelectActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.wilbar:
                intent = new Intent(WilliamChartActivity.this, WilBarSelectActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.wilstacked:
                intent = new Intent(WilliamChartActivity.this, WilStackBarSelectActivity.class);
                startActivity(intent);
                break;

        }


    }


}
