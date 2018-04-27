package main.graphsubsys;

import javax.swing.JPanel;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

public class Graph extends JPanel {
    
    protected static final int LINEGRAPH = 0;
    protected static final int PIECHART = 1;
    protected static final int AMORCAL = 2;
    
    private int type;

    private Date startDate;
    private Date endDate;
    
    private double[] xPointData;
    private double[] yPointData;
    private double maxX;
    private double minX;
    private double maxY;
    private double minY; 
    private HashMap<String, Double> labelToValue;
    
    private double maxHeight;
    
    private Graph() {
        this.setSize(600, 600);
        this.setPreferredSize(new Dimension(600,600));
    }
    
    protected Graph(double[] x, double[] y, Date startDate, Date endDate) {
        this();
        this.type = LINEGRAPH;
        
        this.startDate = startDate;
        this.endDate = endDate;
        
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
        minY = 0;
        maxY = maxHeight;
        minX = 1.0;
        maxX = y.length + 1;
        
    }
    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        switch (type) {
            case LINEGRAPH:
                drawLineGraph(g2d);
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
        double convertedX = (((x-minX) / (maxX - minX)) * 270.0) + 60.0;
        double convertedY = (((y-minY) / (maxY - minY)) * 270.0);
        convertedY = 300 - convertedY;
        double[] point = new double[2];
        point[0] = convertedX;
        point[1] = convertedY;
        
        return point;
    }
    
    private double[] convertPointAmor(double x, double y) {
        double convertedX = (((x-minX) / (maxX - minX)) * 270.0) + 62.0;
        double convertedY = (((y-minY) / (maxY - minY)) * 290.0);
        convertedY = 300 - convertedY;
        double[] point = new double[2];
        point[0] = convertedX;
        point[1] = convertedY;
        
        return point;
    }
    
    private void drawLineGraph(Graphics2D g) {
        drawAxes(g);
        
        g.drawString("$" + minY, 2, 295);
        g.drawString("$" + maxY, 2, 20);
        
        GregorianCalendar cal = new GregorianCalendar();
        
        cal.setTime(startDate);
        String startString = cal.get(cal.MONTH) + "/" + cal.get(cal.DATE) + "/" + cal.get(cal.YEAR);
        cal.setTime(endDate);
        String endString = cal.get(cal.MONTH) + "/" + cal.get(cal.DATE) + "/" + cal.get(cal.YEAR);
        
        g.drawString(startString, 40, 315);
        g.drawString(endString, 300, 315);
        
        double[] point = convertPoint(xPointData[0], yPointData[0]);
        Path2D.Double path = new Path2D.Double();
        
        path.moveTo(point[0], point[1]);
        for (int i = 1; i < xPointData.length; i++) {
            point = convertPoint(xPointData[i], yPointData[i]);
            path.lineTo(point[0], point[1]);
        }
        
        if (minY < 0) {
            int height = (int)convertPoint(0, 0)[1];
            g.drawString("$0", 40, height + 5);
            g.drawLine(60, height, 330, height);
        }
        
        g.setColor(Color.RED);
        g.draw(path);
        
    }
    
    private void drawPieChart(Graphics2D g) {
        
    }
    
    private void drawAmortizationCalendar(Graphics2D g) {
        double[] point1 = {0, 0};
        double[] point2 = {0, 0};
        double width = (270 / yPointData.length)-2;
        double minPoint = 0;
        double midPoint = 0;
        
        for (int i = 0; i < yPointData.length; i++) {
            point1 = convertPointAmor(i + 1.0, maxHeight);
            point2 = convertPointAmor(i + 1.0, yPointData[i]);
            
            if (i == 0) {
                minPoint = point2[1];
            }
            if (i == (yPointData.length / 2)) {
                midPoint = point2[1];
            }
            
            Rectangle2D.Double bar1 = new Rectangle2D.Double(point1[0], point1[1], width, point2[1]-point1[1]);
            
            Rectangle2D.Double bar2 = new Rectangle2D.Double(point2[0], point2[1], width, 300 - point2[1]);
            
            g.setColor(Color.RED);
            g.fill(bar1);
            g.setColor(Color.BLACK);
            g.fill(bar2);
            
        }
        
        g.setColor(Color.BLACK);
        
        drawAxes(g);
        g.drawString("$" + yPointData[0], 2, (int)minPoint + 5);
        g.drawString("$" + yPointData[yPointData.length / 2], 2, (int)midPoint + 5);
        g.drawString("$" + maxY, 2, 20);
        
    }
    
    private void drawAxes(Graphics2D g) {
        Path2D.Double axes = new Path2D.Double();
        axes.moveTo(60.0, 10.0);
        axes.lineTo(60.0, 300.0);
        axes.lineTo(330.0, 300.0);
        
        g.setColor(Color.BLACK);
        g.draw(axes);
        
    }
}