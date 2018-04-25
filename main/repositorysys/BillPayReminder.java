package main.repositorysys;

import java.util.Date;

public class BillPayReminder {

    private String name;
    private double amount;
    private Date reminderDate; // MM-dd-yyyy Format



    public BillPayReminder(String name, double amount, Date reminderDate) {
        this.name = name;
        this.amount = amount;
        this.reminderDate = reminderDate;
    }
    
}
