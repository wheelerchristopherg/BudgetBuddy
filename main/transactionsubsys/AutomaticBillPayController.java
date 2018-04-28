package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Transaction;
import main.repositorysys.Repository;
import main.userinterface.Form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AutomaticBillPayController {
    
    private Form form;
    private BillPayReminder reminder;

    // Save BillReminders
    
    public AutomaticBillPayController(Form form) {
        this.form = form;
    }

    public void setAutomaticBillPay(String name, double value, String dueDateString) {
        //TransactionSystem.loadBillOnAutoPay();
        reminder = Repository.createAutomaticBillPayReminder(name, value, dueDateString);
        TransactionSystem.saveBillsOnAutoPay();

    } // setAutomaticBillPay()


    public void checkBillDates() {

        Date today = new Date();

        for (BillPayReminder b : Repository.getAutomaticBillPayReminders()) {
            if (b.getReminderDate().before(today)) {
                //sendNotification(reminder);
                System.out.println("Bill payed: " + b.getName());
                Repository.getAccount("cash").createTransaction(b.getName(), b.getAmount() * -1, b.getDateString());
                
                //Repository.getAutomaticBillPayReminders().remove(b);
            }
        }
        
        TransactionSystem.saveBillsOnAutoPay();
    }

    public void checkSingleDate() {
        Date today = new Date();
        if(reminder.getReminderDate().before(today)) {
            //sendNotification(reminder);
            System.out.println("Bill payed: " + reminder.getName());
            Repository.getAccount("cash").createTransaction(reminder.getName(), reminder.getAmount() * -1, reminder.getDateString());
            
            //Repository.getAutomaticBillPayReminders().remove(reminder);
        }
        
        TransactionSystem.saveBillsOnAutoPay();
    }

    public void sendNotification(BillPayReminder bill) {
        JOptionPane.showMessageDialog((JPanel)form, "Pay Bill: "+ bill.getName() + "!");
    }

} // AutomaticBillPay
