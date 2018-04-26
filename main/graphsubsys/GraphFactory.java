package main.graphsubsys;

import java.awt.geom.Point2D;

public class GraphFactory {
    public static Graph createLineGraph(double[] x, double[] y) {
        Graph lineGraph = new Graph("lineGraph", double[] x, double[] y);
    }
    
    public static Graph createBarGraph() {
        
    }
}