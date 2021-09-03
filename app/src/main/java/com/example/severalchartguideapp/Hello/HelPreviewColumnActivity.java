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
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.PreviewColumnChartView;

//https://github.com/lecho/hellocharts-android/blob/master/hellocharts-samples/src/lecho/lib/hellocharts/samples/PreviewColumnChartActivity.java
public class HelPreviewColumnActivity extends HelloChartActivity {

    private ColumnChartView chart;
    private PreviewColumnChartView previewChart;
    private ColumnChartData data;
    /**
     * Deep copy of data.
     */
    private ColumnChartData previewData;

    private Button previewx;
    private Button previewy;
    private Button previewxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpreviewcolumn);

        chart = (ColumnChartView)findViewById(R.id.hel_column);
        previewChart = (PreviewColumnChartView)findViewById(R.id.hel_previewcolumn);

        // Generate data for previewed chart and copy of that data for preview chart.
        generateData();

        previewx = (Button) findViewById(R.id.cpreviewX);
        previewx.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewX(true);
            }
        });

        previewy = (Button) findViewById(R.id.cpreviewY);
        previewy.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewY();
            }
        });

        previewxy = (Button) findViewById(R.id.cpreviewXY);
        previewxy.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                previewXY();
            }
        });

        chart.setColumnChartData(data);
        // Disable zoom/scroll for previewed chart, visible chart ranges depends on preview chart viewport so
        // zoom/scroll is unnecessary.
        chart.setZoomEnabled(false); // column chart 확대 X
        chart.setScrollEnabled(false); //  column chart 스크롤 X

        previewChart.setColumnChartData(previewData);
        previewChart.setViewportChangeListener(new ViewportListener()); // preview chart 변할때 동작


        previewX(false);
    }


    private void generateData() {
        int numSubcolumns = 1;
        int numColumns = 50; // data : 50개
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
            }

            Column column = new Column(values);
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(true);
            columns.add(column);
        }

        data = new ColumnChartData(columns);
        data.setAxisXBottom(new Axis()); // X축
        data.setAxisYLeft(new Axis().setHasLines(true)); // 왼쪽 Y축 line표시

        // prepare preview data, is better to use separate deep copy for preview chart.
        // set color to grey to make preview area more visible.
        previewData = new ColumnChartData(data); // preview chart : column chart 복사
        for (Column column : previewData.getColumns()) {
            for (SubcolumnValue value : column.getValues()) {
                value.setColor(ChartUtils.DEFAULT_DARKEN_COLOR); // chart 색
            }
        }

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
            // don't use animation, it is unnecessary when using preview chart because usually viewport changes
            // happens to often.
            chart.setCurrentViewport(newViewport);
        }

    }

}
