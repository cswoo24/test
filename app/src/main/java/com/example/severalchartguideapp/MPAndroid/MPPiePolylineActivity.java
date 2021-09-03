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

//https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/main/java/com/xxmassdeveloper/mpchartexample/PiePolylineChartActivity.java
public class MPPiePolylineActivity extends MPAndroidChartActivity {

    private PieChart mppiepolylinechart;

    protected final String[] parties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mppiepolyline);

        mppiepolylinechart = findViewById(R.id.pie_polyline_chart);
        mppiepolylinechart.setUsePercentValues(true); // value 퍼센트 표시
        mppiepolylinechart.getDescription().setEnabled(false);
        mppiepolylinechart.setExtraOffsets(5, 10, 5, 5);

        mppiepolylinechart.setDragDecelerationFrictionCoef(0.95f); // ?

        mppiepolylinechart.setCenterText(generateCenterSpannableText()); // 글자 속성(line 137~147)

        mppiepolylinechart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

        mppiepolylinechart.setDrawHoleEnabled(true); // 가운데 hole 만들기
        mppiepolylinechart.setHoleColor(Color.WHITE); // hole 색

        mppiepolylinechart.setTransparentCircleColor(Color.WHITE); // 투명원 색
        mppiepolylinechart.setTransparentCircleAlpha(110); // 투명원 색의 투명도

        mppiepolylinechart.setHoleRadius(58f); // hole 반지름
        mppiepolylinechart.setTransparentCircleRadius(61f); // 투명원 반지름

        mppiepolylinechart.setDrawCenterText(true); // 가운데 글자 생성 여뷰

        mppiepolylinechart.setRotationAngle(0); // 차트 생성 시 회전 각도
        // enable rotation of the chart by touch
        mppiepolylinechart.setRotationEnabled(true); // 차트 회전 여부(손으로)
        mppiepolylinechart.setHighlightPerTapEnabled(true); // 차트(데이터) 클릭 시 hihglight 여부

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        setData(5,15);



        mppiepolylinechart.animateY(1400, Easing.EaseInOutQuad);
        // chart.spin(2000, 0, 360);

        Legend l = mppiepolylinechart.getLegend(); // 범례
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (Math.random() * range) + range / 5, parties[i % parties.length]));
            //entries.add(new PieEntry((float)(Math.random() * range) + 50));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setSliceSpace(3f); // data 간격
        dataSet.setSelectionShift(5f); // 차트 data 클릭됐을 때 차트 중앙에서 전환되는 거리(얼마나 커지는지)

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();  // color 추가

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors); // dataset color 설정
        //dataSet.setSelectionShift(0f);


        dataSet.setValueLinePart1OffsetPercentage(80.0f); // 꺾이는 각도
        dataSet.setValueLinePart1Length(0.2f); // 빠져 나온 선 세로
        dataSet.setValueLinePart2Length(0.4f); // 빠져나온 선 가로 길이

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE); // value 표시 위치

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter()); // 퍼센트 표시 설정
        data.setValueTextSize(11f); // 글자크기
        data.setValueTextColor(Color.BLACK); // 글자색
        mppiepolylinechart.setData(data);

        // undo all highlights
        mppiepolylinechart.highlightValues(null);

        mppiepolylinechart.invalidate();
    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.65f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }
}
