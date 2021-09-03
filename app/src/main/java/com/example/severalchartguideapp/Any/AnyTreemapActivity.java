package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.TreeDataEntry;
import com.anychart.charts.TreeMap;
import com.anychart.core.ui.Title;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.anychart.enums.Orientation;
import com.anychart.enums.SelectionMode;
import com.anychart.enums.TreeFillingMethod;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/TreeMapChartActivity.java
public class AnyTreemapActivity extends AnyChartActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anytreemap);

        AnyChartView anyChartView = findViewById(R.id.any_treemap_chart);

        TreeMap treeMap = AnyChart.treeMap();

        treeMap.data(data(), TreeFillingMethod.AS_TABLE); // data를 array list 형태로 insert

        Title title = treeMap.title(); // 차트 제목
        title.enabled(true);
        title.useHtml(true);
        title.padding(0d, 0d, 20d, 0d);
        title.text("Top ACME Products by Revenue<br/>' +\n" +
                "      '<span style=\"color:#212121; font-size: 13px;\">(average sales during the year, in $)</span>");

        treeMap.colorScale().ranges(new String[]{ // data 범위
                "{ less: 25000 }",
                "{ from: 25000, to: 30000 }",
                "{ from: 30000, to: 40000 }",
                "{ from: 40000, to: 50000 }",
                "{ from: 50000, to: 100000 }",
                "{ greater: 100000 }"
        });

        treeMap.colorScale().colors(new String[]{ // 색 지정
                "#ffee58", "#fbc02d", "#f57f17", "#c0ca33", "#689f38", "#2e7d32"
        });

        treeMap.padding(10d, 10d, 10d, 20d);
        treeMap.maxDepth(2d); // 레벨 헤드라인 수(어느 정도 하위 속성까지 보여줄지)
        treeMap.hovered().fill("#bdbdbd", 1d); // 클릭했을 때 색, 불투명도
        treeMap.selectionMode(SelectionMode.NONE); // ?

        treeMap.legend().enabled(true);
        treeMap.legend() //범례 설정
                .padding(0d, 0d, 0d, 20d) // 범례 위치
                .position(Orientation.RIGHT)
                .align(Align.TOP) // 정렬 위치
                .itemsLayout(LegendLayout.VERTICAL); // 범례 가로세로

        treeMap.labels().useHtml(true);
        treeMap.labels().fontColor("#212121");
        treeMap.labels().fontSize(12d);
        treeMap.labels().format( // treemap 라벨 포맷
                "function() {\n" +
                        "      return this.getData('product');\n" +
                        "    }");

        treeMap.headers().format( // treemap 헤더 포맷
                "function() {\n" +
                        "    return this.getData('product');\n" +
                        "  }");

        treeMap.tooltip() // tooltip 포맷
                .useHtml(true)
                .titleFormat("{%product}")
                .format("function() {\n" +
                        "      return '<span style=\"color: #bfbfbf\">Revenue: </span>$' +\n" +
                        "        anychart.format.number(this.value, {\n" +
                        "          groupsSeparator: ' '\n" +
                        "        });\n" +
                        "    }");

        anyChartView.setChart(treeMap);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomTreeDataEntry("Products by Revenue", null, "Products by Revenue"));
        data.add(new CustomTreeDataEntry("Fruits", "Products by Revenue", "Fruits", 692000));
        data.add(new CustomTreeDataEntry("Vegetables", "Products by Revenue", "Vegetables", 597000));
        data.add(new CustomTreeDataEntry("Dairy", "Products by Revenue", "Dairy", 1359000));
        data.add(new CustomTreeDataEntry("Meat", "Products by Revenue", "Meat", 596000));
        data.add(new CustomTreeDataEntry("Apples", "Fruits", "Apples", 138000));
        data.add(new CustomTreeDataEntry("Oranges", "Fruits", "Oranges", 22000));
        data.add(new CustomTreeDataEntry("Bananas", "Fruits", "Bananas", 88000));
        data.add(new CustomTreeDataEntry("Melons", "Fruits", "Melons", 77000));
        data.add(new CustomTreeDataEntry("Apricots", "Fruits", "Apricots", 48000));
        data.add(new CustomTreeDataEntry("Plums", "Fruits", "Plums", 48000));
        data.add(new CustomTreeDataEntry("Pineapples", "Fruits", "Pineapples", 41000));
        data.add(new CustomTreeDataEntry("Cherries", "Fruits", "Cherries", 39000));
        data.add(new CustomTreeDataEntry("Tangerines", "Fruits", "Tangerines", 32000));
        data.add(new CustomTreeDataEntry("Potato", "Vegetables", "Potato", 189000));
        data.add(new CustomTreeDataEntry("Eggplants", "Vegetables", "Eggplants", 94000));
        data.add(new CustomTreeDataEntry("Tomatoes", "Vegetables", "Tomatoes", 63000));
        data.add(new CustomTreeDataEntry("Cucumbers", "Vegetables", "Cucumbers", 43000));
        data.add(new CustomTreeDataEntry("Cabbage", "Vegetables", "Cabbage", 30000));
        data.add(new CustomTreeDataEntry("Carrot", "Vegetables", "Carrot", 29000));
        data.add(new CustomTreeDataEntry("Squash", "Vegetables", "Squash", 26000));
        data.add(new CustomTreeDataEntry("Capsicums", "Vegetables", "Capsicums", 23000));
        data.add(new CustomTreeDataEntry("Milk", "Dairy", "Milk", 154000));
        data.add(new CustomTreeDataEntry("Curd", "Dairy", "Curd", 142000));
        data.add(new CustomTreeDataEntry("Cheese", "Dairy", "Cheese", 43000));
        data.add(new CustomTreeDataEntry("Yogurt", "Dairy", "Yogurt", 38000));
        data.add(new CustomTreeDataEntry("Kefir", "Dairy", "Kefir", 32000));
        data.add(new CustomTreeDataEntry("Mutton", "Meat", "Mutton", 154000));
        data.add(new CustomTreeDataEntry("Beef", "Meat", "Beef", 142000));
        data.add(new CustomTreeDataEntry("Pork", "Meat", "Pork", 43000));
        data.add(new CustomTreeDataEntry("Veal", "Meat", "Veal", 38000));

        return data;
    }

    private class CustomTreeDataEntry extends TreeDataEntry {
        CustomTreeDataEntry(String id, String parent, String product, Integer value) {
            super(id, parent, value);
            setValue("product", product);
        }

        CustomTreeDataEntry(String id, String parent, String product) {
            super(id, parent);
            setValue("product", product);
        }
    }
}
