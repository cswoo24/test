package com.example.severalchartguideapp.Hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

public class HelLineSelectActivity extends HelloChartActivity implements View.OnClickListener {

    private Button btnHelloLineinputChart;
    private Button btnHelloLineforChart;
    private Button btnHelloMultiChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellineselect);

        btnHelloLineinputChart = (Button) findViewById(R.id.hellolineinput);
        btnHelloLineinputChart.setOnClickListener(this);

        btnHelloLineforChart = (Button) findViewById(R.id.hellolinefor);
        btnHelloLineforChart.setOnClickListener(this);

        btnHelloMultiChart = (Button) findViewById(R.id.hellomulti);
        btnHelloMultiChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.hellolineinput:
                intent = new Intent(HelLineSelectActivity.this, HelLineinputActivity.class);
                startActivity(intent);
                break;

            case R.id.hellolinefor:
                intent = new Intent(HelLineSelectActivity.this, HelLineforActivity.class);
                startActivity(intent);
                break;

            case R.id.hellomulti:
                intent = new Intent(HelLineSelectActivity.this, HelMultiLineActivity.class);
                startActivity(intent);
                break;

        }
    }
}
