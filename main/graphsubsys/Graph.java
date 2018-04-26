package main.graphsubsys;

import javax.swing.JPanel;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Graph extends JPanel {
    
    protected static final int LINEGRAPH = 0;
    protected static final int BARGRAPH = 1;
    protected static final int PIECHART = 2;
    protected static final int AMORCAL = 3;
    
    private int type;

    private String xAxisLabel;
    private String yAxisLabel;
    
    private double[] xPointData;
    private double[] yPointData;
    private HashMap<String, Double> labelToValue;
    
    private double maxHeight;
    
    private Graph() {
        this.setSize(300, 300);
    }
    
    protected Graph(int type, double[] x, double[] y) {
        this();
        this.type = type;
        
        xPointData = x.clone();
        yPointData = y.clone();
    }
    
    protected Graph(double maxHeight, double[] stepHeights) {
        this();
        this.type = AMORCAL;
        this.maxHeight = maxHeight;
        
        yPointData = stepHeights.clone();
    }
    
    protected Graph(double[] percentages, String[] labels) {
        this();
        this.type = PIECHART;
        
        labelToValue = new HashMap<String, Double>();
        for (int i = 0; i < percentages.length; i++) {
            labelToValue.put(labels[i], percentages[i]);
        }
    }
    
    protected void addLabels(String x, String y) {
        
    }
    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        switch (type) {
            case LINEGRAPH:
                drawLineGraph(g2d);
                break;
            case BARGRAPH:
                drawBarGraph(g2d);
                break;
            case PIECHART:
                drawPieChart(g2d);
                break;
            case AMORCAL:
                drawAmortizationCalendar(g2d);
                break;
        }
    }
    
    private void drawLineGraph(Graphics2D g) {
        drawAxes(g);
    }
    
    private void drawBarGraph(Graphics2D g) {
        drawAxes(g);
    }
    
    private void drawPieChart(Graphics2D g) {
        
    }
    
    private void drawAmortizationCalendar(Graphics2D g) {
        drawAxes(g);
    }
    
    private void drawAxes(Graphics2D g) {
        Path2D axes = new Path2D.Double();
        axes.moveTo(50.0, 50.0);
        axes.lineTo(50.0, 250.0);
        axes.lineTo(250.0, 250.0);
        
        g.draw(axes);
    }
}