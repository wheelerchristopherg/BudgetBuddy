package main.repositorysys;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BillPayReminder {

    private String name;
    private double amount;
    private Date reminderDate; // MM-dd-yyyy Format

    public BillPayReminder(String name, double amount, String reminderDate) {
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            Date date = format.parse(reminderDate);
            this.reminderDate = date;
        } catch (ParseException e) {
            // WRONG FORMAT
        }
        this.name = name;
        this.amount = amount;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }
    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getReminderDate() {
        return reminderDate;
    }
    
    public String getDateString() {
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(reminderDate);
    }

}
