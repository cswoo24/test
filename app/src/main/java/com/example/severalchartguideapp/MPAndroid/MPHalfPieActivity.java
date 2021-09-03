package com.example.severalchartguideapp.MPAndroid;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.example.severalchartguideapp.MPAndroidChartActivity;
import com.example.severalchartguideapp.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/HalfPieChartActivity.java
public class MPHalfPieActivity extends MPAndroidChartActivity {

    private PieChart mphalfpiechart;

    protected final String[] parties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mphalfpie);

        // dataset : random
        mphalfpiechart = findViewById(R.id.half_pie_chart);
        mphalfpiechart.setBackgroundColor(Color.LTGRAY); //chart 배경색

        mphalfpiechart.setUsePercentValues(true); // value 값 %표시 사용 여부
        mphalfpiechart.getDescription().setEnabled(false);

        mphalfpiechart.setCenterText(generateCenterSpannableText()); // chart 중앙 문구 처리(line 104~114)

        mphalfpiechart.setDrawHoleEnabled(true); // 중앙 hole 사용 여부
        mphalfpiechart.setHoleColor(Color.WHITE); // 중앙 hole색

        mphalfpiechart.setTransparentCircleColor(Color.BLACK); // data와 hole 사이의 투명 원 색
        mphalfpiechart.setTransparentCircleAlpha(255); // 투명 원 투명도

        mphalfpiechart.setHoleRadius(58f); // hole 반지름
        mphalfpiechart.setTransparentCircleRadius(61f); // 투명원 반지름 hole 반지름보다 커야 보임. 너무 크면 이쁘지 않음

        mphalfpiechart.setDrawCenterText(true);

        mphalfpiechart.setRotationEnabled(false); // chart 회전 여부
        mphalfpiechart.setHighlightPerTapEnabled(true); // data 클릭할 때 focus 집중 위해 차트 변화 여부

        mphalfpiechart.setMaxAngle(180f); // HALF CHART
        mphalfpiechart.setRotationAngle(180f); // chart 시작 rotation 설정
        mphalfpiechart.setCenterTextOffset(0, -20); // 글자 위치

        setData(4, 100); // dataset

        mphalfpiechart.animateY(1400, Easing.EaseInOutQuad); // animation 시간, 동작 설정

        Legend l = mphalfpiechart.getLegend(); // 범례
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); // 세로 위치
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER); // 가로 위치
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL); // 정렬방식
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mphalfpiechart.setEntryLabelColor(Color.WHITE);
        mphalfpiechart.setEntryLabelTextSize(12f);
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            values.add(new PieEntry((float) ((Math.random() * range) + range / 5), parties[i % parties.length]));
            //float val = (float) (Math.random() * range) + 50;
            //values.add(new PieEntry((float)(Math.random() * range) + 50));
        }

        PieDataSet dataSet = new PieDataSet(values, "Election Results");
        dataSet.setSliceSpace(3f); // data 간격
        dataSet.setSelectionShift(5f); // 차트 data 클릭됐을 때 차트 중앙에서 전환되는 거리(얼마나 커지는지)

        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter()); // value값을 % 값으로 바꿔 value 표시
        data.setValueTextSize(20f); // 글자 크기
        data.setValueTextColor(Color.WHITE);
        mphalfpiechart.setData(data);

        mphalfpiechart.invalidate();
    }

    private SpannableString generateCenterSpannableText() { // 차트 중앙의 글자 속성

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }
}
