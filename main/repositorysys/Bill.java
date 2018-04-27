package main.repositorysys;

import java.util.*;

public class Bill {

    private String name;
    private String type;
    private double value;
    private Date dueDate;
    private boolean recurrance;
    private Account desiredAccount;

    public Bill(String name, double value, Date dueDate) {
        this.name = name;
        this.value = value;
        this.dueDate = dueDate;
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
