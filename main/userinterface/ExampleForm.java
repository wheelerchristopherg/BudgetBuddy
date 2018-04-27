package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExampleForm extends Form {
    
    public ExampleForm(Window parent) {
        super(parent);
        
        setGridLayout(1, 1);
        
        double[] x = {1, 2, 3, 4};
        double[] y = {8000, 8000.75, 8000.25, 8001};
        
        Date startDate = (new GregorianCalendar(2018, 4, 1)).getTime();
        Date endDate = (new GregorianCalendar(2018, 4, 30)).getTime();
        
        Graph amorCal = GraphFactory.createAmortizationCalendar(1000.0, steps);
        Graph lineGraph = GraphFactory.createLineGraph(x, y, startDate, endDate);

        add(amorCal);
        add(lineGraph);
        addButton("back", "Back");

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