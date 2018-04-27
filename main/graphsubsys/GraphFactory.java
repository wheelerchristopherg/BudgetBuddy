package main.graphsubsys;


import java.util.Date;

public class GraphFactory {
    public static Graph createLineGraph(double[] x, double[] y, String xaxisLabel, String yaxisLabel) {
        Graph lineGraph = new Graph(Graph.LINEGRAPH, x, y);
        lineGraph.addLabels(xaxisLabel, yaxisLabel);
        return lineGraph;
    }
    
    
    public static Graph createPieChart(double[] percentages, String[] labels) {
        Graph pieChart = new Graph(percentages, labels);
        return pieChart;
    }
    
    public static Graph createAmortizationCalendar(double maxHeight, double[] stepHeights, String xaxisLabel, String yaxisLabel) {
        Graph amCal = new Graph(maxHeight, stepHeights);
        amCal.addLabels(xaxisLabel, yaxisLabel);
        return amCal;
    }
}