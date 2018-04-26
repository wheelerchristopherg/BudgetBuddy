package main.userinterface;

import main.graphsubsys.GraphFactory;
import main.graphsubsys.Graph;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

public class SavingsNetworthValueForm extends Form {
    
    public SavingsNetworthValueForm(Window parent) {
        super(parent);
        
        setGridLayout(1, 2);
        
        addPlaceholder();
        addLabel("Savings or Networth Over Time");
        addPlaceholder();
        addButton("savings", "Show Savings");
        addPlaceholder();
        addButton("networth", "Show Networth");
        addTextField("month", "month");
        addTextField("day", "day");
        addTextField("year", "year");
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "savings":
                
        }
    }
}