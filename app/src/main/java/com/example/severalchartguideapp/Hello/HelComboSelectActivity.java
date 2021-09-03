package com.example.severalchartguideapp.Hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

public class HelComboSelectActivity extends HelloChartActivity implements View.OnClickListener {

    private Button btnHelloLineColumnComboChart;
    private Button btnHelloLineColumnDependencyChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helcomboselect);

        btnHelloLineColumnComboChart = (Button) findViewById(R.id.hellocombolinecolumn);
        btnHelloLineColumnComboChart.setOnClickListener(this);

        btnHelloLineColumnDependencyChart = (Button) findViewById(R.id.hellolincoldepen);
        btnHelloLineColumnDependencyChart.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {

            case R.id.hellocombolinecolumn:
                intent = new Intent(HelComboSelectActivity.this, HelComboActivity.class);
                startActivity(intent);
                break;

            case R.id.hellolincoldepen:
                intent = new Intent(HelComboSelectActivity.this, HelLinColDependencyActivity.class);
                startActivity(intent);
                break;


        }
    }
}
