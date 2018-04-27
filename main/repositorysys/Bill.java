package main.repositorysys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bill {

    private String name;
    private String type;
    private double value;
    private Date dueDate;
    private boolean recurrance;
    private Account desiredAccount;

    public Bill(String name, double value, String dueDate) {
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            Date date = format.parse(dueDate);
            this.dueDate = date;
        } catch (ParseException e) {
            // WRONG FORMAT
        }
        this.name = name;
        this.value = value;
    }



    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean recurrance() {
        return recurrance;
    }

    public Account getDesiredAccount() {
        return desiredAccount;
    }

    public boolean equals(Bill bill) {
        return this.name == bill.name &&
            this.value == bill.value &&
            this.dueDate == bill.dueDate;
    } // compareTo

}
