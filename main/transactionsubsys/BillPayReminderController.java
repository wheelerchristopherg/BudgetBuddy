package main.transactionsubsys;

import main.userinterface.*;
import main.repositorysys.BillPayReminder;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class BillPayReminderController {
    private ArrayList<BillPayReminder> billReminders;
    //private int currentState;
    //private Form form;

    public BillPayReminderController() {
        //Form
    }

    public void addBillPayReminder(BillPayReminder billPayReminder) {
        BillPayReminder testReminder = new BillPayReminder("Test", 20, "08-27-1996");
        billReminders.add(testReminder);
    }

    public void checkDate() {
        Date today = new Date();
        for (BillPayReminder r : billReminders) {
            System.out.println("test");
            //if (r.getReminderDate().before(today)) {
            //    sendNotification();
            //}
        }
    }

    public void sendNotification() {
        //send notification
        JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
    }

}
