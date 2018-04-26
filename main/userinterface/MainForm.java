package main.userinterface;

import java.awt.event.ActionEvent;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        setGridLayout(3, 3);
        
        addPlaceholder();
        addLabel("Main Form");
        addPlaceholders(2);
        addButton("BillPayReminder_Button", "BillPayReminderForm");
        addButton("button1", "Example Form");

        addPlaceholders(3);
        
    }
    
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        
        switch (name) {
            case "button1":
                changeForm(new ExampleForm(this.getParent()));
                break;
            case "BillPayReminder_Button":
                changeForm(new BillPayReminderForm(this.getParent()));
                break;
        }
    }
}