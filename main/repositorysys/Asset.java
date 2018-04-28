package main.repositorysys;

import java.util.*;

public class Asset {

  private String type;
  private String name;
  private double value;
  private Date date;

    public Asset(String name, String type, double value, Date date) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isBefore(Date dateIn) {
        return date.before(dateIn);
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }


} // Asset
