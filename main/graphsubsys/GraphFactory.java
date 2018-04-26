package main.graphsubsys;

public class GraphFactory {
    public static Graph createLineGraph(double[] x, double[] y, String xaxisLabel, String yaxisLabel) {
        Graph lineGraph = new Graph("line graph", x, y);
        lineGraph.addLabels(xaxisLabel, yaxisLabel);
        return lineGraph;
    }
    
    public static Graph createBarGraph(double[] x, double[] y, String xaxisLabel, String yaxisLabel) {
        Graph barGraph = new Graph("bar graph", x, y);
        barGraph.addLabels(xaxisLabel, yaxisLabel);
        return barGraph;
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