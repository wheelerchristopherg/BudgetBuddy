package main.userinterface;

import main.graphsubsys.Graph;
import main.graphsubsys.GraphFactory;
import main.assetsubsys.AssetSystem;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.util.Date;
import java.util.GregorianCalendar;

public class AmortizationCalendarForm extends Form {
    
    private JPanel graphPanel;
    
    public AmortizationCalendarForm(Window parent) {
        super(parent);
        
        setGridLayout(3, 2);
        
        addLabel("Amortization Calendar");
        addPlaceholder();
        
        addButton("get graph", "Show Amortization Calendar");
        addTextField("loan", "Loan name");
        addButton("back", "Back");
        graphPanel = new JPanel();
        add(graphPanel);
    }
    
    public void setGraph(Graph graph) {
        graphPanel.add(graph);
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "get graph":
                String loanName = getTextFromInput("loan");
                AssetSystem.createAmCalController(this, loanName);
                break;
            case "back":
                goBack();
                break;
        }
    }
}