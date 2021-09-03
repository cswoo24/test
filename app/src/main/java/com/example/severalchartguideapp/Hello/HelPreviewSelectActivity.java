package com.example.severalchartguideapp.Hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

public class HelPreviewSelectActivity extends HelloChartActivity implements View.OnClickListener {

    private Button btnHelloPreviewLineChart;
    private Button btnHelloPreviewColumnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpreviewselect);

        btnHelloPreviewLineChart = (Button) findViewById(R.id.hellopreviewline);
        btnHelloPreviewLineChart.setOnClickListener(this);

        btnHelloPreviewColumnChart = (Button) findViewById(R.id.hellopreviewcolumn);
        btnHelloPreviewColumnChart.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.hellopreviewcolumn:
                intent = new Intent(HelPreviewSelectActivity.this, HelPreviewColumnActivity.class);
                startActivity(intent);
                break;

            case R.id.hellopreviewline:
                intent = new Intent(HelPreviewSelectActivity.this, HelPreviewLineActivity.class);
                startActivity(intent);
                break;


        }
    }
}
