package main;

//compile javac main/Main.java
//java main.Main

import main.repositorysys.BillPayReminder;
import main.userinterface.Window;
import javax.swing.SwingUtilities;
import main.transactionsubsys.BillPayReminderController;

public class Main {
    public static void main(String[] args) {

        // Program startup check


        SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    new Window();
                }
            });

        BillPayReminderController test = new BillPayReminderController();
        test.checkDate();
    }
}
