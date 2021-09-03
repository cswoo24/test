package com.example.severalchartguideapp.William;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

public class WilStackBarSelectActivity extends WilliamChartActivity implements View.OnClickListener{

    private Button btnWilStackBarOneChart;
    private Button btnWilStackBarTwoChart;
    private Button btnWilStackBarThreeChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilstackbarselect);

        btnWilStackBarOneChart = (Button) findViewById(R.id.wilstackbar);
        btnWilStackBarOneChart.setOnClickListener(this);
        btnWilStackBarTwoChart = (Button) findViewById(R.id.wilhorizontalstack1);
        btnWilStackBarTwoChart.setOnClickListener(this);
        btnWilStackBarThreeChart = (Button) findViewById(R.id.wilhorizontalstack2);
        btnWilStackBarThreeChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.wilstackbar:
                intent = new Intent(WilStackBarSelectActivity.this, WilStackBarActivity.class);
                startActivity(intent);
                break;

            case R.id.wilhorizontalstack1:
                intent = new Intent(WilStackBarSelectActivity.this, WilHorizontalStackBarOneActivity.class);
                startActivity(intent);
                break;

            case R.id.wilhorizontalstack2:
                intent = new Intent(WilStackBarSelectActivity.this, WilHorizontalStackBarTwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
