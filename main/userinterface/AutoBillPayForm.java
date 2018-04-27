package main.userinterface;

import java.awt.event.ActionEvent;
import main.repositorysys.Bill;
import main.transactionsubsys.AutomaticBillPayController;

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
    }

    AutomaticBillPayController abp = new AutomaticBillPayController();
    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "submit":
                String reminder_name = getTextFromInput("billpay_name");
                double reminder_amount = Double.parseDouble(getTextFromInput("billpay_amount"));
                String reminder_date = getTextFromInput("billpay_date");

                abp.loadBillOnAutoPay();
                Bill bill = new Bill(reminder_name, reminder_amount, reminder_date);
                abp.setAutomaticBillPay(bill);
                abp.saveBillsOnAutoPay();
                abp.checkSingleDate(bill);
                break;
            case "back":
                goBack();
                break;

        }
    }
}