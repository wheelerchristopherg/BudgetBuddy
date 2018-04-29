package main.userinterface;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Transaction;
import main.transactionsubsys.BillPayReminderController;
import main.transactionsubsys.RecordTransactionController;
import main.transactionsubsys.TransactionSystem;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordTransactionForm extends Form {

    String transactionList = "";

    public RecordTransactionForm(Window parent) {
        super(parent);

        setGridLayout(4, 2);

        addLabel("<html><center>View/Record </br> Transaction</center></html>");
        addTextArea("TransactionList",100,1,false);
        addTextField("transaction_type", "Transaction Name");
        addTextField("transaction_value", "Transaction Amount (numbers only)");
        addTextField("transaction_date", "Transaction Date (mm-dd-yyyy)");
        addButton("submit", "Add Transaction");
        addButton("back", "Back");

        TransactionSystem.createRecordTransactionController(this);
    }

    public void actionPerformed(ActionEvent event) {
        String name = buttonPressed(event);

        switch (name) {
            case "submit":
                String transaction_type = getTextFromInput("transaction_type");
                double transaction_value = Double.parseDouble(getTextFromInput("transaction_value"));
                String transaction_date = getTextFromInput("transaction_date");
                
                TransactionSystem.getRecordTransactionController().recordTransaction(transaction_type, transaction_value, transaction_date);
                TransactionSystem.getRecordTransactionController().getTransactions();
                break;
            case "back":
                goBack();
                break;

        }
    }

}
