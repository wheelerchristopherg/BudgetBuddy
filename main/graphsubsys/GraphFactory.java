package main.graphsubsys;

import java.util.Date;

public class GraphFactory {
    public static Graph createLineGraph(double[] x, double[] y, Date startDate, Date endDate ) {
        Graph lineGraph = new Graph(x, y, startDate, endDate);
        return lineGraph;
    }
    
    
    public static Graph createPieChart(double[] values, String[] labels) {
        Graph pieChart = new Graph(values, labels);
        return pieChart;
    }
    
    public static Graph createAmortizationCalendar(double maxHeight, double[] stepHeights) {
        Graph amCal = new Graph(maxHeight, stepHeights);
        return amCal;
    }
}

