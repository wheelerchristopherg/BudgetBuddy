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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class SavingsNetworthValueForm extends Form {
    
    private JPanel graphPlaceholder;
    private Graph currentGraph;
    
    public SavingsNetworthValueForm(Window parent) {
        super(parent);
        
        setGridLayout(3, 3);
        
        addLabel("<html><center> Savings or Net Worth Over Time </center></html>");
        addButton("savings", "Show Savings");
        addButton("networth", "Show Networth");
        addTextField("date", "date to look back to (mm-dd-yyyy)");
        graphPlaceholder = new JPanel();
        add(graphPlaceholder);
        addPlaceholder();
        addButton("back", "Back");
        
        
        
    }
    
    public void setGraph(Graph graph) {
        if (currentGraph != null) {
            graphPlaceholder.remove(currentGraph);
        }
        currentGraph = graph;
        graphPlaceholder.add(currentGraph);
        repaint();
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(getTextFromInput("date"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Incorrect date format");
            return;
        }
        
        
        switch (name) {
            case "savings":
                AssetSystem.createSavingsNetWorthValueController("savings", date, this);
                break;
            case "networth":
                AssetSystem.createSavingsNetWorthValueController("net worth", date, this);
                break;
            case "back":
                goBack();
                break;
        }
    }
}