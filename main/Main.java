package main;

//compile javac main/Main.java
//java main.Main

import main.transactionsubsys.BankDataInterface;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;

public class Main {
    public static void main(String[] args) {

        // Controllers

        //Create Bank Interface and generate transactions
        BankDataInterface bank = new BankDataInterface();
        bank.generateTransactions(1000); // Comment out after first run
        BillPayReminderController billReminderController = new BillPayReminderController();
        billReminderController.loadBillReminders();


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
