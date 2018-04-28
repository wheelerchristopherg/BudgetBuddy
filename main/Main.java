package main;

//compile javac main/Main.java
//java main.Main

import main.transactionsubsys.BankDataInterface;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;
import main.repositorysys.Repository;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Controllers

        //Create Bank Interface and generate transactions
        BankDataInterface bank = new BankDataInterface();
        //bank.generateTransactions(1000); // Comment out after first run
        BillPayReminderController billReminderController = new BillPayReminderController();
        billReminderController.loadBillReminders();
        Repository.init();
        Repository.createLoan("test", 10000.0, 0.005, 2000.0, new Date());
        
        System.out.println(Repository.getLoan("test"));
        
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
