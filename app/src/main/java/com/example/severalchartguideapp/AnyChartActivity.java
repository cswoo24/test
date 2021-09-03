package com.example.severalchartguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//
//https://github.com/AnyChart/AnyChart-Android
// 인터넷에서 지도 link 필요한 BubbleMap, ChoroplethMap, ConnectorMap Activity의 경우
// 라이브러리에 있는 url로 열 수 없고 자체 홈페이지(https://www.anychart.com/products/anymap/overview/)에서
// 제공하는 Map Gallery 에서 링크 가져와서 사용해야 함
//


public class AnyChartActivity extends MainActivity implements View.OnClickListener {

    private Button btnAnyPieChart;
    private Button btnAnyRadarChart;
    private Button btnAnyScatterChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anychart);

        btnAnyPieChart = (Button) findViewById(R.id.anyatof);
        btnAnyPieChart.setOnClickListener(this);
        btnAnyRadarChart = (Button) findViewById(R.id.anygtoq);
        btnAnyRadarChart.setOnClickListener(this);
        btnAnyScatterChart = (Button) findViewById(R.id.anyrtoz);
        btnAnyScatterChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            // BarChart 버튼 눌렀을 때
            case R.id.anyatof:
                intent = new Intent(AnyChartActivity.this, AnyAtoFActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.anygtoq:
                intent = new Intent(AnyChartActivity.this, AnyGtoQActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.anyrtoz:
                intent = new Intent(AnyChartActivity.this, AnyRtoZActivity.class);
                startActivity(intent);
                break;
        }
    }
}
