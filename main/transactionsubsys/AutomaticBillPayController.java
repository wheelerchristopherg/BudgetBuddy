package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Repository;
import main.userinterface.Form;
import java.util.Collection;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class AutomaticBillPayController {

    private Form form;
    private BillPayReminder reminder;

    public AutomaticBillPayController(Form form) {
        this.form = form;
    }

    public void setAutomaticBillPay(String name, double value, String dueDateString) {
        reminder = Repository.createAutomaticBillPayReminder(name, value, dueDateString);
        TransactionSystem.saveBillsOnAutoPay();

    }

    public void checkBillDates() {
        Date today = new Date();
        Collection<BillPayReminder> rmdr = new ArrayList<>();
        for (BillPayReminder b : Repository.getAutomaticBillPayReminders()) {
            if (b.getReminderDate().before(today)) {
                sendNotification(b);
                ((ArrayList<BillPayReminder>) rmdr).add(b);
                Repository.getAccount("cash").createTransaction(b.getName(), b.getAmount() * -1, b.getDateString());
            }
        }
        Repository.getAutomaticBillPayReminders().removeAll(rmdr);
        TransactionSystem.saveBillsOnAutoPay();
    }

    public void checkSingleDate() {
        Date today = new Date();
        if(reminder.getReminderDate().before(today)) {
            sendNotification(reminder);
            Repository.getAccount("cash").createTransaction(reminder.getName(), reminder.getAmount() * -1, reminder.getDateString());
            Repository.removeAutomaticBillPay(reminder);
        }

        TransactionSystem.saveBillsOnAutoPay();
    }

    public void sendNotification(BillPayReminder rmdr) {
        JOptionPane.showMessageDialog(null, "Bill: "+ rmdr.getName() + " payed!");
    }

}
