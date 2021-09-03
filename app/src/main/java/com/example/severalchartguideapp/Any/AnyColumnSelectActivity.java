package com.example.severalchartguideapp.Any;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;


public class AnyColumnSelectActivity extends AnyChartActivity implements View.OnClickListener{


    private Button btn2d;
    private Button btn3d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anycolumnselect);


        btn2d = (Button) findViewById(R.id.button2D);
        btn2d.setOnClickListener(this);

        btn3d = (Button) findViewById(R.id.button3D);
        btn3d.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            // LineChart 버튼 눌렀을 때
            case R.id.button2D:
                intent = new Intent(AnyColumnSelectActivity.this, AnyColumnActivity.class);
                startActivity(intent);
                break;

            // BarChart 버튼 눌렀을 때
            case R.id.button3D:
                intent = new Intent(AnyColumnSelectActivity.this, AnyColumn3DActivity.class);
                startActivity(intent);
                break;
        }
    }
}
