package main.graphsubsys;

import javax.swing.JPanel;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
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
    private double maxX;
    private double minX;
    private double maxY;
    private double minY;
    private HashMap<String, Double> labelToValue;
    
    private double maxHeight;
    
    private Graph() {
        this.setSize(250, 250);
    }
    
    protected Graph(int type, double[] x, double[] y) {
        this();
        this.type = type;
        
        
        xPointData = x.clone();
        yPointData = y.clone();
        
        setMinMax(xPointData, yPointData);
    }
    
    protected Graph(double maxHeight, double[] stepHeights) {
        this();
        this.type = AMORCAL;
        this.maxHeight = maxHeight;
        
        yPointData = stepHeights.clone();
        setMinMax(yPointData);
    }
    
    protected Graph(double[] percentages, String[] labels) {
        this();
        this.type = PIECHART;
        
        labelToValue = new HashMap<String, Double>();
        for (int i = 0; i < percentages.length; i++) {
            labelToValue.put(labels[i], percentages[i]);
        }
    }
    
    private void setMinMax(double[] x, double[] y) {
        minX = x[0];
        maxX = x[x.length-1];
        minY = y[0];
        maxY = y[0];
        for (int i = 1; i < y.length; i++) {
            if (y[i] > maxY) {
                maxY = y[i];
            }
            if (y[i] < minY) {
                minY = y[i];
            }
        }
    }
    
    private void setMinMax(double[] y) {
        minY = y[0];
        maxY = y[0];
        for (int i = 1; i < y.length; i++) {
            if (y[i] > maxY) {
                maxY = y[i];
            }
            if (y[i] < minY) {
                minY = y[i];
            }
        }
        
        System.out.println("maxX: " + maxX);
        System.out.println("minX: " + minX);
        System.out.println("maxY: " + maxY);
        System.out.println("minY: " + minY);
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
    
    private double[] convertPoint(double x, double y) {
        double convertedX = (((x-minX) / (maxX - minX)) * 200.0) + 30.0;
        double convertedY = (((y-minY) / (maxY - minY)) * 200.0);
        convertedY = 210 - convertedY;
        double[] point = new double[2];
        point[0] = convertedX;
        point[1] = convertedY;
        
        System.out.println("x: " + convertedX);
        System.out.println("y: " + convertedY);
        System.out.println();
        
        return point;
    }
    
    private void drawLineGraph(Graphics2D g) {
        drawAxes(g);
        
        double[] point = convertPoint(xPointData[0], yPointData[0]);
        Path2D.Double path = new Path2D.Double();
        
        path.moveTo(point[0], point[1]);
        for (int i = 0; i < xPointData.length; i++) {
            point = convertPoint(xPointData[i], yPointData[i]);
            path.lineTo(point[0], point[1]);
        }
        System.out.println(path);
        
        g.setColor(Color.RED);
        g.draw(path);
        
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
        Path2D.Double axes = new Path2D.Double();
        axes.moveTo(30.0, 10.0);
        axes.lineTo(30.0, 230.0);
        axes.lineTo(230.0, 230.0);
        
        g.setColor(Color.BLACK);
        g.draw(axes);
    }
}