package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;

public class ExampleForm extends Form {
    
    public ExampleForm(Window parent) {
        super(parent);
        
        setGridLayout(1, 1);
        
        double[] x = {1, 2, 3, 5, 6, 7};
        double[] y = {10, 13, 5, 20, 12, 12};
        
        Graph lineGraph = GraphFactory.createLineGraph(x, y, "", "");
        
        add(lineGraph);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            
        }
    }
}