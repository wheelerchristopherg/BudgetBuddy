package main.transactionsubsys;

import main.repositorysys.Transaction;
import main.repositorysys.Repository;
import java.util.ArrayList;
import main.userinterface.Form;

public class RecordTransactionController {

    private Form form;

    public RecordTransactionController(Form form) {
        this.form = form;
        getTransactions();
    }
    
    public void recordTransaction(String category, double value, String transDate) {
        Repository.getAccount("cash").createTransaction(category, value, transDate);
        TransactionSystem.saveTransactions();
    }
    
    public void getTransactions() {
        //TransactionSystem.loadCashTransactions();
        String transactionList = "";
        if(!Repository.getAccount("cash").getTransactions().isEmpty()) {
            for (Transaction t : Repository.getAccount("cash").getTransactions()) {
                transactionList += t.getCategory() + ",\t" + t.getValue() + ",\t" + t.getDateString() + "\n";
            }
        }
        form.setText("TransactionList", transactionList);
        //TransactionSystem.saveTransactions();
    }

}
