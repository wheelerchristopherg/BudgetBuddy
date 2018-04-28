package main.userinterface;

import java.awt.event.ActionEvent;
import main.repositorysys.Repository;
import main.transactionsubsys.AutomaticBillPayController;
import main.transactionsubsys.TransactionSystem;

public class AutoBillPayForm extends Form {
    
    public AutoBillPayForm(Window parent) {
        super(parent);

        setGridLayout(4, 2);

        addLabel("Automatic Bill Pay");
        addPlaceholder();
        addTextField("billpay_name", "Bill Name");
        addTextField("billpay_amount", "Bill Amount (numbers only)");
        addTextField("billpay_date", "Bill Date (mm-dd-yyyy)");
        addButton("submit", "Add Bill Reminder");
        addButton("back", "Back");
        
        TransactionSystem.createAutomaticBillPayController(this);
    }

    
    public void actionPerformed(ActionEvent event) {
        String reminder_name = "";
        double reminder_amount = 0;
        String reminder_date = "";
        System.out.println("line 29");
        String name = buttonPressed(event);
        switch (name) {
            case "submit":
                
                reminder_name = getTextFromInput("billpay_name");
                reminder_amount = Double.parseDouble(getTextFromInput("billpay_amount"));
                reminder_date = getTextFromInput("billpay_date");

                TransactionSystem.getAutomaticBillPayController().setAutomaticBillPay(reminder_name, reminder_amount, reminder_date);
                TransactionSystem.getAutomaticBillPayController().checkSingleDate();
                break;
            case "back":
                goBack();
                break;

        }
    }
}