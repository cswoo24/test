package com.example.severalchartguideapp.William;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

public class WilLineSelectActivity extends WilliamChartActivity implements View.OnClickListener {

    private Button btnWilLineOneChart;
    private Button btnWilLineTwoChart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_willineselect);

        btnWilLineOneChart = (Button) findViewById(R.id.wilmultiline);
        btnWilLineOneChart.setOnClickListener(this);
        btnWilLineTwoChart = (Button) findViewById(R.id.willine);
        btnWilLineTwoChart.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            // BarChart 버튼 눌렀을 때
            case R.id.wilmultiline:
                intent = new Intent(WilLineSelectActivity.this, WilMultiLineActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.willine:
                intent = new Intent(WilLineSelectActivity.this, WilLineActivity.class);
                startActivity(intent);
                break;

        }


    }
}
