package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public final class BillPayReminderController {
    private ArrayList<BillPayReminder> billReminders = new ArrayList<BillPayReminder>();
    //private int currentState;
    //private Form form;

    public BillPayReminderController() {
        //Form
    }

    //Loads Bill
    public void loadBillReminders() {
        String csvFile = "billreminders.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                double amount = Double.parseDouble(rmdline[1]);
                BillPayReminder temprmd = new BillPayReminder(rmdline[0], amount, rmdline[2]);
                addBillPayReminder(temprmd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save BillReminders
    public void saveBillReminders() {
        try {
            PrintWriter pw = new PrintWriter(new File("billreminders.csv"));
            for (BillPayReminder r : billReminders) {
                StringBuilder sb = new StringBuilder();
                sb.append(r.getName());
                sb.append(',');
                sb.append(r.getAmount());
                sb.append(',');
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                sb.append(sdf.format(r.getReminderDate()));
                sb.append('\n');
                pw.write(sb.toString());
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("billreminders.csv Not Found");
        }
    }


    // Adds BillPayReminder to arraylist
    public void addBillPayReminder(BillPayReminder billPayReminder) {
        billReminders.add(billPayReminder);
    }

    // Checks to see if any reminder dates have been reached
    public void checkDate() {
        Date today = new Date();
        for (BillPayReminder r : billReminders) {
            if (r.getReminderDate().before(today)) {
                sendNotification(r);
                //billReminders.remove(r);
            }
        }
    }

    // Sends BillPay Notification to user
    public void sendNotification(BillPayReminder rmdr) {
        JOptionPane.showMessageDialog(null, "Pay Bill: "+ rmdr.getName() + "!");
    }

}
