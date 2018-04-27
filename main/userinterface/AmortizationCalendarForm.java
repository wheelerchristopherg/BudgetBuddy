package main.userinterface;

import main.graphsubsys.Graph;
import main.graphsubsys.GraphFactory;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JScrollPane;

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
        add(new JScrollPane(graphPanel));
    }
    
    public void setGraph() {
        double[] x = {1, 2, 3, 4};
        double[] y = {8000, 8000.75, 8000.25, 8001};
        
        Date start = (new GregorianCalendar(2018, 4, 1)).getTime();
        Date end = (new GregorianCalendar(2018, 4, 30)).getTime();
        
        Graph lineGraph = GraphFactory.createLineGraph(x, y, start, end);
        
        graphPanel.add(lineGraph);
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