package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Transaction;

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


public class AutomaticBillPayController {
    private BillPayReminder reminder;

    // Save BillReminders
    


    public void setAutomaticBillPay(String name, double value, String dueDateString) {

        reminder = Repository.createAutomaticBillPayReminder(name, value, dueDateString);
        TransactionSystem.saveBillsOnAutoPay();

    } // setAutomaticBillPay()


    public void payBill(Bill bill) {
        cancelAutomaticBillPay(bill);
        saveBillsOnAutoPay();
    } // payBIll()


    public void checkBillDates() {

        Date today = new Date();

        for (Bill b : billsOnAutoPay) {
            if (b.getDueDate().before(today)) {
                payBill(b);
            }
        }
    }

    public void checkSingleDate() {
        Date today = new Date();
        if(reminder.getReminderDate().before(today)) {
            sendNotification(bill);
            
            Repository.getAccount("cash").createTransaction(bill.getName(), bill.getValue() * -1, bill.getDateString());
            
           
        }
    }

    public void sendNotification(Bill bill) {
        JOptionPane.showMessageDialog(null, "Pay Bill: "+ bill.getName() + "!");
    }


    public boolean cancelAutomaticBillPay(Bill bill) {

        for (Bill b : billsOnAutoPay) {
            if (b.equals(bill)) {
                billsOnAutoPay.remove(b);
                b = null;
                return true;
            } // if compare
        } // for : b

        return false;
    } // cancelAutomaticBillPay()

} // AutomaticBillPay
