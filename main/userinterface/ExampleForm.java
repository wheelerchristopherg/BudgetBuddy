package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExampleForm extends Form {
    
    public ExampleForm(Window parent) {
        super(parent);
        
        setGridLayout(2, 2);
        
        String[] labels = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh"};
        
        double[] steps = {50, 110, 220, 370, 530, 720, 950};
        
        double[] x = {1, 2, 3, 4, 5, 6, 7, 8};
        double[] y = {10, 20, 30, 30, 50, -30, 70, 80};
        
        
        Date startDate = (new GregorianCalendar(2018, 4, 1)).getTime();
        Date endDate = (new GregorianCalendar(2018, 4, 30)).getTime();
        
        Graph amorCal = GraphFactory.createAmortizationCalendar(1000.0, steps);
        Graph lineGraph = GraphFactory.createLineGraph(x, y, startDate, endDate);
        Graph piechart = GraphFactory.createPieChart(steps, labels);
        
        add(amorCal);
        add(lineGraph);
        addButton("back", "Back");
        add(piechart);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "back":
                goBack();
                break;
        }
    }
}