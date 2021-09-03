package com.example.severalchartguideapp.Hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.severalchartguideapp.HelloChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.listener.ViewportChangeListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PreviewLineChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/PreviewLineChartActivity.java
public class HelPreviewLineActivity extends HelloChartActivity {

    private LineChartView chart;
    private PreviewLineChartView previewChart;
    private LineChartData data;
    /**
     * Deep copy of data.
     */
    private LineChartData previewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpreviewline);

        chart = (LineChartView) findViewById(R.id.hel_line);
        previewChart = (PreviewLineChartView) findViewById(R.id.hel_previewline);

        // Generate data for previewed chart and copy of that data for preview chart.
        generateData();

        Button previewx = (Button) findViewById(R.id.lpreviewX);
        previewx.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewX(true);
            }
        });

        Button previewy = (Button) findViewById(R.id.lpreviewY);
        previewy.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewY();
            }
        });

        Button previewxy = (Button) findViewById(R.id.lpreviewXY);
        previewxy.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewXY();
            }
        });

         chart.setLineChartData(data);
        // Disable zoom/scroll for previewed chart, visible chart ranges depends on preview chart viewport so
        // zoom/scroll is unnecessary.
        chart.setZoomEnabled(false);
        chart.setScrollEnabled(false);

        previewChart.setLineChartData(previewData);
        previewChart.setViewportChangeListener(new ViewportListener());

        previewX(true);
    }

    private void generateData() {
        int numValues = 50;

        List<PointValue> values = new ArrayList<PointValue>();
        for (int i = 0; i < numValues; ++i) { // random data 생성
            values.add(new PointValue(i, (float) Math.random() * 100f));
        }

        Line line = new Line(values);
        line.setColor(ChartUtils.COLOR_GREEN); // linechart 색
        line.setHasPoints(false);// too many values so don't draw points.
        line.setHasLabels(true);
        line.setHasLabelsOnlyForSelected(true);

        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        data = new LineChartData(lines);
        data.setAxisXBottom(new Axis()); // X축
        data.setAxisYLeft(new Axis().setHasLines(true)); // 왼쪽 Y축 line표시

        // prepare preview data, is better to use separate deep copy for preview chart.
        // Set color to grey to make preview area more visible.
        previewData = new LineChartData(data);  // preview chart : line chart 복사
        previewData.getLines().get(0).setColor(ChartUtils.DEFAULT_DARKEN_COLOR); // chart 색

    }

    private void previewY() { // preview chart focus Y
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        float dy = tempViewport.height() / 4;
        tempViewport.inset(0, dy);
        previewChart.setCurrentViewportWithAnimation(tempViewport);
        previewChart.setZoomType(ZoomType.VERTICAL);
    }

    private void previewX(boolean animate) { // preview chart focus X
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        float dx = tempViewport.width() / 4; // 이동 범위
        tempViewport.inset(dx, 0);
        if (animate) {
            previewChart.setCurrentViewportWithAnimation(tempViewport);
        } else {
            previewChart.setCurrentViewport(tempViewport);
        }
        previewChart.setZoomType(ZoomType.HORIZONTAL); // 가로 확대만 가능
    }

    private void previewXY() { // preview chart focus XY
        // Better to not modify viewport of any chart directly so create a copy.
        Viewport tempViewport = new Viewport(chart.getMaximumViewport());
        // Make temp viewport smaller.
        float dx = tempViewport.width() / 4;
        float dy = tempViewport.height() / 4;
        tempViewport.inset(dx, dy);
        previewChart.setCurrentViewportWithAnimation(tempViewport);
    }

    private class ViewportListener implements ViewportChangeListener {

        @Override
        public void onViewportChanged(Viewport newViewport) {
            // don't use animation, it is unnecessary when using preview chart.
            chart.setCurrentViewport(newViewport);
        }
    }
}
