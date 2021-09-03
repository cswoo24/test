package com.example.severalchartguideapp.William;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

public class WilBarSelectActivity extends WilliamChartActivity implements View.OnClickListener {

    private Button btnWilBarOneChart;
    private Button btnWilBarTwoChart;
    private Button btnWilBarThreeChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilbarselect);

        btnWilBarOneChart = (Button) findViewById(R.id.wilgroupbar);
        btnWilBarOneChart.setOnClickListener(this);
        btnWilBarTwoChart = (Button) findViewById(R.id.wilhorizontalbar);
        btnWilBarTwoChart.setOnClickListener(this);
        btnWilBarThreeChart = (Button) findViewById(R.id.wilbar);
        btnWilBarThreeChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

           // BarChart 버튼 눌렀을 때
            case R.id.wilgroupbar:
                intent = new Intent(WilBarSelectActivity.this, WilGroupBarActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.wilhorizontalbar:
                intent = new Intent(WilBarSelectActivity.this, WilHorizontalBarActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.wilbar:
                intent = new Intent(WilBarSelectActivity.this, WilBarActivity.class);
                startActivity(intent);
                break;

        }
    }
}
