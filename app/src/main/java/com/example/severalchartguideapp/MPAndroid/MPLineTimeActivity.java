package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/LineChartTime.java
public class MPLineTimeActivity extends MPAndroidChartActivity implements OnSeekBarChangeListener{

    private LineChart mplinetimechart;

    private SeekBar seekBarX;
    private TextView tvX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplinetime);

        tvX = findViewById(R.id.tvValueCount);
        seekBarX = findViewById(R.id.seekbarValues);
        seekBarX.setOnSeekBarChangeListener(this);

        mplinetimechart = findViewById(R.id.line_time_chart);

        mplinetimechart.getDescription().setEnabled(false);

        // enable touch gestures
        mplinetimechart.setTouchEnabled(true);

        mplinetimechart.setDragDecelerationFrictionCoef(0.9f); // 감속마찰계수. 높은 값은 속도가 느리게 감소함을 나타냄(0~1) 0이면 정지, 1은 무효값-> 0.999f로 자동 변환(time mplinetimechart관련 추정)

        // enable scaling and dragging
        mplinetimechart.setDragEnabled(true);
        mplinetimechart.setScaleEnabled(true);
        mplinetimechart.setDrawGridBackground(false);
        mplinetimechart.setHighlightPerDragEnabled(true);

        // set an alternative background color
        mplinetimechart.setBackgroundColor(Color.WHITE); // 차트 배경색
        mplinetimechart.setViewPortOffsets(15f, 0f, 0f, 0f); // 차트 위치 설정

        // add data
        seekBarX.setProgress(100);

        setData(10,100);


        // get the legend (only possible after setting data)
        Legend l = mplinetimechart.getLegend(); //범례
        l.setEnabled(false);

        XAxis xAxis = mplinetimechart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE); // X축 위치
        xAxis.setTextSize(10f); // X축 글자 크기
        xAxis.setTextColor(Color.BLACK); // 글자 색
        xAxis.setDrawAxisLine(false); // X축 표시 여부
        xAxis.setDrawGridLines(true); // X축 그리드 라인 표시 여부
        //xAxis.setTextColor(Color.rgb(255, 192, 56));
        xAxis.setCenterAxisLabels(true);
        xAxis.setGranularity(1f); // one hour
        xAxis.setValueFormatter(new ValueFormatter() {

            private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM HH:mm", Locale.ENGLISH);

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                long millis = TimeUnit.HOURS.toMillis((long) value);
                return mFormat.format(new Date(millis));
            }
        });

        YAxis leftAxis = mplinetimechart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART); // Y축 위치(차트 안/밖)
        //leftAxis.setTextColor(ColorTemplate.getHoloBlue()); // Y축 글자색
        leftAxis.setDrawGridLines(true); // 그리드 라인 표시 여부
        leftAxis.setGranularityEnabled(false);
        leftAxis.setAxisMinimum(0f); // 최소값
        leftAxis.setAxisMaximum(170f); // 최대값
        leftAxis.setYOffset(-9f); // Y축 offset
        leftAxis.setTextColor(Color.rgb(255, 192, 56));

        YAxis rightAxis = mplinetimechart.getAxisRight();
        rightAxis.setEnabled(false); // 오른쪽 Y축 표시 여부


    }

    private void setData(int count, float range) {

        // now in hours
        long now = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());

        ArrayList<Entry> values = new ArrayList<>();

        // count = hours
        float to = now + count;

        // increment by 1 hour
        for (float x = now; x < to; x++) {

            float y = getRandom(range, 25);
            values.add(new Entry(x, y)); // add one entry per hour
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "DataSet 1");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(Color.RED);//(ColorTemplate.getHoloBlue());  // 차트 선 색
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f); // 선 너비
        set1.setDrawCircles(false); // 데이터 위치 원 표시
        set1.setDrawValues(true); // value값 표시
        set1.setDrawFilled(true); // 데이터 밑 채우기
        set1.setFillAlpha(65); // 투명도
        set1.setFillColor(ColorTemplate.getHoloBlue()); // 채우기 색
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setHighlightLineWidth(1.5f); // highlight 선 너비
        set1.setDrawHighlightIndicators(true); // highlight 표시
        set1.setDrawCircleHole(false);

        // create a data object with the data sets
        LineData data = new LineData(set1);
        data.setValueTextColor(Color.BLACK); // value 색
        data.setValueTextSize(12f); // value글자 크기

        // set data
        mplinetimechart.setData(data);
        mplinetimechart.invalidate();
    }

    protected float getRandom(float range, float start) {
        return (float) (Math.random() * range) + start;
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText(String.valueOf(seekBarX.getProgress()));

        setData(seekBarX.getProgress(), 50);

        // redraw
        mplinetimechart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
