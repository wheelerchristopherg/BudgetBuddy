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

        // Controllers


        //Create Bank Interface and generate transactions

        BankDataInterface bank = new BankDataInterface();


        //bank.generateTransactions(1000); // Comment out after first run
        BillPayReminderController billReminderController = new BillPayReminderController();
        billReminderController.loadBillReminders();
        Repository.init();

        // start window
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new Window();
                    }
                });


        // Check Dates
        billReminderController.checkDate();



    }

}
