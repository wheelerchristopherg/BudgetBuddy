package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import main.userinterface.Form;
import main.userinterface.Window;
import main.assetsubsys.AssetSystem;

public class SavingsNetworthValueForm extends Form {
    
    private JPanel graphPlaceholder;
    
    public SavingsNetworthValueForm(Window parent) {
        super(parent);
        
        setGridLayout(4, 3);
        
        addButton("back", "Back");
        addLabel("Savings or Networth Over Time");
        addPlaceholder();
        addButton("savings", "Show Savings");
        addPlaceholder();
        addButton("networth", "Show Networth");
        addTextField("month", "4");
        addTextField("day", "26");
        addTextField("year", "2018");
        
        graphPlaceholder = new JPanel();
        add(graphPlaceholder);
        
    }
    
    public void setGraph(Graph graph) {
        remove(graphPlaceholder);
        add(graph);
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
                AssetSystem.createSavingsNetWorthValueController("savings", cal.getTime(), this);
                break;
            case "networth":
                AssetSystem.createSavingsNetWorthValueController("net worth", cal.getTime(), this);
                break;
            case "back":
                goBack();
                break;
        }
    }
}