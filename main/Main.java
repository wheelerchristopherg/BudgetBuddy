package main;

//compile javac main/Main.java
//java main.Main

import main.repositorysys.BillPayReminder;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;

public class Main {
    public static void main(String[] args) {

        // Controllers
        BillPayReminderController billReminderController = new BillPayReminderController();


        // Program startup check
        billReminderController.loadBillReminders();

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
