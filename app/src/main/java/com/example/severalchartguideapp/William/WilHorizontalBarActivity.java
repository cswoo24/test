package com.example.severalchartguideapp.William;

import android.graphics.Color;
import android.os.Bundle;

import com.db.chart.Tools;
import com.db.chart.model.Bar;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.renderer.XRenderer;
import com.db.chart.view.HorizontalBarChartView;
import com.example.severalchartguideapp.R;
import com.example.severalchartguideapp.WilliamChartActivity;

//https://github.com/abhirocks1211/WilliamChart/blob/48091db7321ce935c37dedad44a62902126c08cb/mobile/src/main/java/com/db/williamchartdemo/barchart/BarCardTwo.java
public class WilHorizontalBarActivity extends WilliamChartActivity {

    private HorizontalBarChartView mChart;

    private final String[] mLabels = {"Mon", "Tue", "Wed", "Thu", "Fri"}; // 라벨

    private final float[][] mValues = {{23f, 34f, 55f, 71f, 98f}, {17f, 26f, 48f, 63f, 94f}}; // data value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilhorizontalbar);

        // animation : show()에서 설정. layout이 현재 사용하는 방식과 많이 달라 설정하지 않음

        initView();
    }

    private void initView() {
        mChart = (HorizontalBarChartView) findViewById(R.id.chart);

        BarSet barSet = new BarSet();
        Bar bar;
        for (int i = 0; i < mLabels.length; i++) {  // data insert
            bar = new Bar(mLabels[i], mValues[0][i]);
            switch (i) {
                case 0:
                    bar.setColor(Color.parseColor("#77c63d"));
                    break;
                case 1:
                    bar.setColor(Color.parseColor("#27ae60"));
                    break;
                case 2:
                    bar.setColor(Color.parseColor("#47bac1"));
                    break;
                case 3:
                    bar.setColor(Color.parseColor("#16a085"));
                    break;
                case 4:
                    bar.setColor(Color.parseColor("#3498db"));
                    break;
                default:
                    break;
            }
            barSet.addBar(bar);
        }

        mChart.addData(barSet);

        BarSet barSet1 = new BarSet();
        Bar bar1;
        for (int i = 0; i < mLabels.length; i++) {  // data insert
            bar1 = new Bar(mLabels[i], mValues[1][i]);
            switch (i) {
                case 0:
                    bar1.setColor(Color.parseColor("#cd5c5c"));
                    break;
                case 1:
                    bar1.setColor(Color.parseColor("#f08080"));
                    break;
                case 2:
                    bar1.setColor(Color.parseColor("#fa8072"));
                    break;
                case 3:
                    bar1.setColor(Color.parseColor("#e9967a"));
                    break;
                case 4:
                    bar1.setColor(Color.parseColor("#ffa07a"));
                    break;
                default:
                    break;
            }
            barSet1.addBar(bar1);
        }

        mChart.addData(barSet1);

        mChart.setBarSpacing(Tools.fromDpToPx(20)); // X 라벨 기준 바 사이의 간격

        mChart.setBorderSpacing(0) // bar와 차트 사이의 간격. left/right 동시 적용
                .setXAxis(true) // X축 보기
                .setYAxis(true) // Y축 보기
                .setLabelsColor(Color.parseColor("#FF8E8A84")) // 라벨 색
                .setXLabels(XRenderer.LabelPosition.OUTSIDE) // X축 라벨 위치
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE); // Y축 라벨 위치


        mChart.show(); // chart load
    }
}
