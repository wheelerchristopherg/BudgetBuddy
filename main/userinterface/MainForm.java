package main.userinterface;

import java.awt.event.ActionEvent;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        setGridLayout(3, 3);
        
        addPlaceholder();
        addLabel("Budget Buddy");
        addPlaceholders(1);
        addButton("BillPayReminder_Button", "Add a Bill Reminder");
        addButton("RecordTransaction_Button", "Add a Transaction");

        addPlaceholders(3);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "BillPayReminder_Button":
                changeForm(new BillPayReminderForm(this.getParent()));
                break;
            case "RecordTransaction_Button":
                changeForm(new RecordTransactionForm(this.getParent()));
                break;
        }
    }
}