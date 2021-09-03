package com.example.severalchartguideapp.Any;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Resource;
import com.anychart.enums.AvailabilityPeriod;
import com.anychart.enums.TimeTrackingMode;
import com.anychart.scales.calendar.Availability;
import com.example.severalchartguideapp.AnyChartActivity;
import com.example.severalchartguideapp.R;

import java.util.ArrayList;
import java.util.List;

//https://github.com/AnyChart/AnyChart-Android/blob/master/sample/src/main/java/com/anychart/sample/charts/ResourceChartActivity.java
public class AnyResourceActivity extends AnyChartActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyresource);

        AnyChartView anyChartView = findViewById(R.id.any_resource_chart);

        Resource resource = AnyChart.resource();

        // 차트가 많이 크기 때문에 가로로 보는 것을 권장함함

       resource.zoomLevel(1d) // 확대 축소 수준에 맞게 설정
                .timeTrackingMode(TimeTrackingMode.ACTIVITY_PER_CHART) // row height 설정. 달력에서 사용할 수 있는 최대 시간에 따라 결정. 모든 리소스들의 최대 높이
                .currentStartDate("2016-09-30"); // 차트 켜질 따 처음 로딩되는 날짜

        resource.resourceListWidth(120); // resource list 너비. 현재 왼쪽에 있는 사람 이름 컬럼

        resource.calendar().availabilities(new Availability[] {
                new Availability(AvailabilityPeriod.DAY, (Double) null, 10d, true, (Double) null, (Double) null, 18d),
                new Availability(AvailabilityPeriod.DAY, (Double) null, 14d, false, (Double) null, (Double) null, 15d),
                new Availability(AvailabilityPeriod.WEEK, (Double) null, (Double) null, false, 5d, (Double) null, 18d),
                new Availability(AvailabilityPeriod.WEEK, (Double) null, (Double) null, false, 6d, (Double) null, 18d)
        }); // 이전 값보다 다음 값의 우선순위가 높음. calendar에서 availabilities를 Array로 Set

        List<DataEntry> data = new ArrayList<>();

        // -117 : data create(데이터 생성하면서 라벨도 같이)
        data.add(new ResourceDataEntry( // ResourceDataEntry 밑에서 정의( String name, String description, String image, Activity[] activities)
                "Romario",
                "Developer",
                "http://cdn.anychart.com/images/resource-chart/developer-romario.png",
                new Activity[]{
                        new Activity( // Activity 정의 (String name, Interval[] intervals, String fill)
                                "Gantt timeline",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-11", 120) // minutesPerDay : 하루에 사용하는 시간(분단위)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Gantt Connectors events/removal + UI customization",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-04", 180)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Chart Facebook sharing",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-04", 120)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Chart animation problems",
                                new Interval[]{
                                        new Interval("2016-10-05", "2016-10-09", 300)
                                },
                                "#62BEC1"),
                        new Activity(
                                "iPad touch problems",
                                new Interval[]{
                                        new Interval("2016-10-12", "2016-10-16", 300),
                                        new Interval("2016-10-17", "2016-10-21", 60)
                                },
                                "#62BEC1"),
                        new Activity(
                                "Some improvements for chart labels",
                                new Interval[]{
                                        new Interval("2016-10-17", "2016-10-22", 240),
                                        new Interval("2016-10-22", "2016-10-26", 240)
                                },
                                "#62BEC1")
                }));
        data.add(new ResourceDataEntry(
                "Antonio",
                "Developer",
                "http://cdn.anychart.com/images/resource-chart/developer-antonio.png",
                new Activity[]{
                        new Activity(
                                "Gantt resource list",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-01", 120) // 밑에서 정의
                                },
                                "#EA526F"),
                        new Activity(
                                "Pareto Chart",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-05", 240)
                                },
                                "#EA526F"),
                        new Activity(
                                "Chart bug fixes",
                                new Interval[]{
                                        new Interval("2016-10-08", "2016-10-25", 180)
                                },
                                "#EA526F"),
                        new Activity(
                                "Chart legend",
                                new Interval[]{
                                        new Interval("2016-10-06", "2016-10-12", 120)
                                },
                                "#EA526F")
                }));
        data.add(new ResourceDataEntry(
                "Alejandro",
                "Developer",
                "http://cdn.anychart.com/images/resource-chart/developer-alejandro.png",
                new Activity[]{
                        new Activity(
                                "Pie chart improvement",
                                new Interval[]{
                                        new Interval("2016-09-25", "2016-10-02", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Pie chart labels problems",
                                new Interval[]{
                                        new Interval("2016-10-05", "2016-11-01", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Stock chart minor bugs",
                                new Interval[]{
                                        new Interval("2016-10-01", "2016-10-10", 120)
                                },
                                "#8789C0"),
                        new Activity(
                                "Chart minor bug fixes",
                                new Interval[]{
                                        new Interval("2016-10-20", "2016-11-05", 120)
                                },
                                "#8789C0")
                }));
        data.add(new ResourceDataEntry(
                "Sergio",
                "Developer",
                "http://cdn.anychart.com/images/resource-chart/developer-sergio.png",
                new Activity[]{
                        new Activity(
                                "Gantt logo",
                                new Interval[]{
                                        new Interval("2016-09-30", "2016-10-03", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Tooltip bug fix",
                                new Interval[]{
                                        new Interval("2016-10-04", "2016-10-10", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Chart label",
                                new Interval[]{
                                        new Interval("2016-10-11", "2016-10-15", 300)
                                },
                                "#E06D06"),
                        new Activity(
                                "Map series labels improvement",
                                new Interval[]{
                                        new Interval("2016-10-16", "2016-11-03", 300)
                                },
                                "#E06D06")
                }));

        resource.data(data);

        anyChartView.setChart(resource);
    }

    private class ResourceDataEntry extends DataEntry {
        ResourceDataEntry(String name, String description, String image, Activity[] activities) {
            setValue("name", name);
            setValue("description", description);
            setValue("image", image);
            setValue("activities", activities);
        }
    }

    private class Activity extends DataEntry {
        Activity(String name, Interval[] intervals, String fill) {
            setValue("name", name);
            setValue("intervals", intervals);
            setValue("fill", fill);
        }
    }

    private class Interval extends DataEntry {
        Interval(String start, String end, Integer minutesPerDay) {
            setValue("start", start);
            setValue("end", end);
            setValue("minutesPerDay", minutesPerDay);
        }
    }
}
