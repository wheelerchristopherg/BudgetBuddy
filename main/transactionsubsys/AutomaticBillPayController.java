package main.transactionsubsys;

import main.repositorysys.Bill;
import main.repositorysys.BillPayReminder;
import main.repositorysys.Repository;
import main.repositorysys.Transaction;
import main.userinterface.Form;

import java.util.Collection;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


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

        Collection<BillPayReminder> rmdr = Repository.getAutomaticBillPayReminders();
        for (BillPayReminder b : rmdr) {
            if (b.getReminderDate().before(today)) {
                sendNotification(b);
                //System.out.println("Bill payed: " + b.getName());
                Repository.getAccount("cash").createTransaction(b.getName(), b.getAmount() * -1, b.getDateString());
                //Repository.removeAutomaticBillPay(b);
                Repository.getAutomaticBillPayReminders().remove(rmdr);
            }
        }

        TransactionSystem.saveBillsOnAutoPay();
    }

    public void checkSingleDate() {
        Date today = new Date();
        if(reminder.getReminderDate().before(today)) {
            sendNotification(reminder);
            //System.out.println("Bill payed: " + reminder.getName());
            Repository.getAccount("cash").createTransaction(reminder.getName(), reminder.getAmount() * -1, reminder.getDateString());
            Repository.removeAutomaticBillPay(reminder);
        }
        
        TransactionSystem.saveBillsOnAutoPay();
    }

    public void sendNotification(BillPayReminder rmdr) {
        JOptionPane.showMessageDialog(null, "Bill: "+ rmdr.getName() + " payed!");
    }

} // AutomaticBillPay
