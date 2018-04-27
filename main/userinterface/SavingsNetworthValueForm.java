package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

public class SavingsNetworthValueForm extends Form {
    
    private JPanel graphPlaceholder;
    
    public SavingsNetworthValueForm(Window parent) {
        super(parent);
        
        setGridLayout(3, 3);
        
        addLabel("Savings or Networth Over Time");
        addButton("savings", "Show Savings");
        addButton("networth", "Show Networth");
        addTextField("month", "4");
        addTextField("day", "26");
        addTextField("year", "2018");
        addButton("back", "Back");
        
        graphPlaceholder = new JPanel();
        add(graphPlaceholder);
        
    }
    
    public void setGraph(Graph graph) {
        graphPlaceholder.add(graph);
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        int year = Integer.parseInt(getTextFromInput("year"));
        int month = Integer.parseInt(getTextFromInput("month"));
        int day = Integer.parseInt(getTextFromInput("day"));
        
        GregorianCalendar cal = new GregorianCalendar(year, month, day); 
        
        switch (name) {
            case "savings":
                //call the savingsnetworthcontroller here
                break;
            case "networth":
                //call the savingsnetworthcontroller here
                break;
            case "back":
                goBack();
                break;
        }
    }
}