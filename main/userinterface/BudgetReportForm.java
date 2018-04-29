package main.userinterface;

import main.graphsubsys.Graph;
import main.budgetsubsys.BudgetSystem;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class BudgetReportForm extends Form {
    
    private JPanel graphPanel;
    
    public BudgetReportForm(Window parent) {
        super(parent);
        
        setGridLayout(2, 3);
        
        
        graphPanel = new JPanel();
        add(graphPanel);
        
        addTextArea("report", 300, 50, false);
        addTextField("budget", "Enter a budget name");
        addButton("back", "Back");
        addButton("export", "Export Report");
        addButton("submit", "Generate Report");
        BudgetSystem.createBudgetReportController(this);
    }
    
    public void setGraph(Graph graph) {
        graphPanel.add(graph);
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "submit":
                BudgetSystem.getBudgetReportController().generateReport();
                BudgetSystem.getBudgetReportController().outputReport();
                break;
            case "export":
                BudgetSystem.getBudgetReportController().exportReport();
            case "back":
                goBack();
                break;
        }
    }
}