package main.repositorysys;
import java.util.*;

public class Asset {

    private String name;
    private String type;
    private double value;
    private Date date;

    public void Asset(String name, String type, double value, Date date) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.date = date;
    } // Asset()

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }


} // Asset
