package com.example.severalchartguideapp.Any;

import android.os.Bundle;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.PertDataEntry;
import com.anychart.charts.Pert;
import com.anychart.core.pert.Milestones;
import com.anychart.core.pert.Tasks;
import com.anychart.core.ui.Tooltip;
import com.anychart.enums.TreeFillingMethod;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/PertChartActivity.java
public class AnyPertActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anypert);

        Toast.makeText(AnyPertActivity.this, "가로로 전환해 주세요", Toast.LENGTH_LONG).show();

        // 화면 커서 default 가로로 설정함
        // dataset 구성이 독특함. 1-3.4-13으로 구분지어 볼 수 있음
        // 1-3 : 갈라지는 tree , 4-13 : tree 별로 되어 있는 것이 아닌 위line -중간line - 아래line 순서로 data 들어감.
        // duration은 걸리는 시간, 4-13 name은 화살표 이름, String[]으로 받은 게 원 label

        AnyChartView anyChartView = findViewById(R.id.any_pert_chart);

        Pert pert = AnyChart.pert();

        pert.data(data(), TreeFillingMethod.AS_TABLE); // dataset을 linaer array로

        pert.padding(25d, 30d, 0d, 50d); // chart 위치

        pert.title().enabled(true);
        pert.title().useHtml(true);
        pert.title()
                .padding(new Double[]{ 0d, 30d, 25d, 0d }) // top right bottom left
                .text("Airplane Design Process with PERT Chart");

        Tasks tasks = pert.tasks();
        tasks.upperLabels().format( // upperLabels 포맷 설정
                "function() {\n" +
                        "    return this.item.get('fullName');\n" +
                        "  }");

        tasks.lowerLabels().format("{%duration} days"); // lowerLabels 포맷 설정

        Tooltip tooltip = tasks.tooltip();
        tooltip.separator(true)
                .titleFormat(
                        "function() {\n" +
                                "      return this.item.get('fullName');\n" + // tooltip 타이틀 포맷(dataset의 fullname 가져오기)
                                "    }");
        tooltip.title().useHtml(true);

        Milestones milestones = pert.milestones();
        milestones.color("#2C81D5")
                .size("4.5%"); // 원 사이즈
        milestones.hovered().fill("#2C81D5", 0.75d);
        milestones.tooltip().format("" + // tooltip 포맷
                "function() {\n" +
                "  var result = '';\n" +
                "  var i = 0;\n" +
                "  if (this['successors'] && this['successors'].length) {\n" +
                "    result += 'Successors:';\n" +
                "    for (i = 0; i < this['successors'].length; i++) {\n" +
                "      result += '\\n - ' + this['successors'][i].get('fullName');\n" +
                "    }\n" +
                "    if (this['predecessors'] && this['predecessors'].length)\n" +
                "      result += '\\n\\n';\n" +
                "  }\n" +
                "  if (this['predecessors'] && this['predecessors'].length) {\n" +
                "    result += 'Predecessors:';\n" +
                "    for (i = 0; i < this['predecessors'].length; i++) {\n" +
                "      result += '\\n - ' + this['predecessors'][i].get('fullName');\n" +
                "    }\n" +
                "  }\n" +
                "  return result;\n" +
                "}");

        Milestones critMilestones = pert.criticalPath().milestones(); // 첫번째 줄
        critMilestones.labels().format(
                "function() {\n" +
                        "    return this['creator'] ? this['creator'].get('name') : this['isStart'] ? 'Start' : 'Finish';\n" +
                        "  }");
        critMilestones.color("#E24B26");



        anyChartView.setChart(pert);
    }

    private List<DataEntry> data() {
        List<DataEntry> data = new ArrayList<>();

        data.add(new CustomPertDataEntry("1", 30, "1", "Aerodinamics"));
        data.add(new CustomPertDataEntry("2", 50, "2", "Build & Test Model"));
        data.add(new CustomPertDataEntry("3", 35, "3", "Structure"));
        data.add(new CustomPertDataEntry("4", 50, "4", new String[]{"1"}, "Propulsion"));
        data.add(new CustomPertDataEntry("5", 60, "5", new String[]{"2"}, "Build Prototype"));
        data.add(new CustomPertDataEntry("6", 40, "6", new String[]{"3"}, "Control & Stability"));
        data.add(new CustomPertDataEntry("7", 20, "7", new String[]{"4"}, "Wind Tunnel"));
        data.add(new CustomPertDataEntry("8", 20, "8", new String[]{"6"}, "Computation"));
        data.add(new CustomPertDataEntry("9", 45, "9", new String[]{"7"}, "Review"));
        data.add(new CustomPertDataEntry("10", 30, "10", new String[]{"8"}, "Flight Simulation"));
        data.add(new CustomPertDataEntry("11", 50, "11", new String[]{"9"}, "Research flights"));
        data.add(new CustomPertDataEntry("12", 45, "12", new String[]{"10"}, "Revise & Review"));
        data.add(new CustomPertDataEntry("13", 25, "13", new String[]{"5"}, "Finalize"));


        return data;
    }

    private class CustomPertDataEntry extends PertDataEntry {
        CustomPertDataEntry(String id, int duration, String name, String fullName) {
            super(id, name, fullName);
            setValue("duration", duration);
        }

        CustomPertDataEntry(String id, int duration, String name, String[] dependsOn, String fullName) {
            super(id, name, fullName, dependsOn);
            setValue("duration", duration);
        }
    }
}
