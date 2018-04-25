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

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

}
