package main;

//compile javac main/Main.java
//java main.Main

import main.repositorysys.BillPayReminder;
import main.transactionsubsys.BankDataInterface;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;

public class Main {
    public static void main(String[] args) {

        // Controllers

        //Create Bank Interface and generate transactions
        BankDataInterface bank = new BankDataInterface();
        bank.generateTransactions(1000);

        BillPayReminderController billReminderController = new BillPayReminderController();

        billReminderController.loadBillReminders();
        billReminderController.checkDate();
        
        // start window
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new Window();
                    }
                });

        // Testing
        //BillPayReminder test1 = new BillPayReminder("Test4", 10, "10-12-2019");
        //BillPayReminder test2 = new BillPayReminder("Test5", 200, "12-2-2019");
        //BillPayReminder test3 = new BillPayReminder("Test6", 340, "01-20-2029");

    }

}
