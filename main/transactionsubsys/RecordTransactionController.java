package main.transactionsubsys;

import main.repositorysys.Transaction;
import java.util.ArrayList;

public class RecordTransactionController {
    private ArrayList<Transaction> billReminders = new ArrayList<Transaction>();
    TransactionSystem tsys = new TransactionSystem();

    public void recordTransaction(Transaction trans) {
        tsys.loadTransactions();
        tsys.addTransaction(trans);
        tsys.saveTransactions();
    }

}
