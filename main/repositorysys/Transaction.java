package main.repositorysys;

import java.util.*;

public class Transaction {
    private String type;
    private double value;
    private Date date;

    public String getType(){
        return this.type;
    }
    public double getValue(){
        return this.value;
    }
    public Date getDate(){
        return this.date;
    }

}