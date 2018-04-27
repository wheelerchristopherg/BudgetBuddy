package main.userinterface;

import main.graphsubsys.Graph;
import main.graphsubsys.GraphFactory;
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
    
    public void setGraph() {
        double maxHeight = 1000;
        double[] steps = {50, 110, 220, 370, 530, 720, 950};
        
        Graph amorCal = GraphFactory.createAmortizationCalendar(maxHeight, steps);
        
        graphPanel.add(amorCal);
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "get graph":
                String loanName = getTextFromInput("loan");
                setGraph();
                //call the amortization calendar controller here
                break;
            case "back":
                goBack();
                break;
        }
    }
}