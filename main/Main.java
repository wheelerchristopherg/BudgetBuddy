package main;

import java.io.*;
//compile javac main/Main.java
//java main.Main

import main.transactionsubsys.BankDataInterface;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;
import main.repositorysys.Repository;
import java.util.Date;
import main.transactionsubsys.TransactionSystem;

public class Main {
    public static void main(String[] args)throws FileNotFoundException{
        String acctName = "account1";
        File bankFile = new File("Bank.txt");
        Repository.createAccount("cash", "cash", 0.0, 0.0);
        // Controllers

        //Create Bank Interface and generate transactions
        //BankDataInterface bank = new BankDataInterface();
        //bank.generateTransactions(1000); // Comment out after first run
        
        TransactionSystem.loadCashTransactions();
        TransactionSystem.loadBillOnAutoPay();
        TransactionSystem.createAutomaticBillPayController(null);
        
        // Check Dates
        TransactionSystem.getAutomaticBillPayController().checkBillDates();
        
        // start window
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new Window();
                    }
                });
                
        
                
    }

}
