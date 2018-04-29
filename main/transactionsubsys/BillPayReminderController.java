package main.transactionsubsys;

import main.repositorysys.BillPayReminder;
import main.repositorysys.Repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.swing.JOptionPane;
import main.userinterface.Form;


public class BillPayReminderController {

    private BillPayReminder reminder;
    private Form form;

    public BillPayReminderController(Form form) {
       this.form = form;
    }

    public void addBillPayReminder(String name, double value, String dueDateString) {
        reminder = Repository.createBillPayReminder(name, value, dueDateString);
        TransactionSystem.saveBillReminders();
    }

    public void checkBillDates() {
        Date today = new Date();
        Collection<BillPayReminder> rmdr = new ArrayList<>();
        for (BillPayReminder b : Repository.getBillPayReminders()) {
            if (b.getReminderDate().before(today)) {
                sendNotification(b);
                ((ArrayList<BillPayReminder>) rmdr).add(b);
            }
        }
        Repository.getBillPayReminders().removeAll(rmdr);
        TransactionSystem.saveBillReminders();
    }

    public void checkSingleDate() {
        Date today = new Date();
        if(reminder.getReminderDate().before(today)) {
            System.out.println("Bill payed: " + reminder.getName());
            sendNotification(reminder);
            Repository.removeBillPayReminder(reminder);
        }
        TransactionSystem.saveBillReminders();
    }

    public void sendNotification(BillPayReminder rmdr) {
        JOptionPane.showMessageDialog(null, "Pay Bill: "+ rmdr.getName() + "!");
    }

}
