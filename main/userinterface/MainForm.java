package main.userinterface;

import java.awt.event.ActionEvent;

public class MainForm extends Form {
    
    public MainForm(Window parent) {
        super(parent);
        setGridLayout(6, 3);

        //addPlaceholder();
        //addLabel("Budget Buddy");
        //addPlaceholder();
        addButton("BillPayReminder_Button", "Add a Bill Reminder");
        addButton("RecordTransaction_Button", "Add a Transaction");

        addButton("Test1", "Test1");
        addButton("Test2", "Test2");
        addButton("Test3", "Test3");
        addButton("Test4", "Test4");
        addButton("Test5", "Test5");
        addButton("Test6", "Test6");
        addButton("Test7", "Test7");
        addButton("Test8", "Test8");
        addButton("Test9", "Test9");
        addButton("Test10", "Test10");

        //addPlaceholders(3);
        
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