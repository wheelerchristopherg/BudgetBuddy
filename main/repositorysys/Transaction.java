package main.repositorysys;

import java.util.*;

public class Transaction {
    private String category;
    private double value;
    private Date date;
    private String vendor;

    public String getCategory(){
        return this.category;
    }
    public double getValue(){
        return this.value;
    }
    public Date getDate(){
        return this.date;
    }
    public String getVendor(){
        return this.vendor;
    }

}