package main.userinterface;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Transaction;
import main.transactionsubsys.BillPayReminderController;
import main.transactionsubsys.RecordTransactionController;

import java.awt.event.ActionEvent;

public class RecordTransactionForm extends Form {

    public RecordTransactionForm(Window parent) {
        super(parent);

        setGridLayout(4, 2);

        addLabel("Record Transaction");
        addPlaceholder();
        addTextField("transaction_type", "Transaction Name");
        addTextField("transaction_value", "Transaction Amount (numbers only)");
        addTextField("transaction_date", "Transaction Date (mm-dd-yyyy)");
        addButton("submit", "Add Transaction");
        addButton("back", "Back");
    }

    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);
        switch (name) {
            case "submit":
                String transaction_type = getTextFromInput("transaction_type");
                double transaction_value = Double.parseDouble(getTextFromInput("transaction_value"));
                String transaction_date = getTextFromInput("transaction_date");
                RecordTransactionController rTrans = new RecordTransactionController();
                Transaction t = new Transaction(transaction_type, transaction_value, transaction_date);
                rTrans.recordTransaction(t);
                break;
            case "back":
                goBack();
                break;

        }
    }

}
