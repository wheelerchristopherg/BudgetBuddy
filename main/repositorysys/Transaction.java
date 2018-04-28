package main.repositorysys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Transaction {

  private String category;
  private double value;
  private Date date;
  private String dateString;
  private String vendor;


  public String getTransactionString() {
      String ret = this.dateString + " " + this.vendor + " " + this.category + " " + this.value;
      return ret;
  }

  public Transaction(String category, double value, String transDate) {
      this.dateString = transDate;
      try {
          DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
          Date date = format.parse(transDate);
          this.date = date;
      } catch (ParseException e) {
          // WRONG FORMAT
      }
      this.category = category;
      this.value = value;
  }

  public String getCategory(){
      return this.category;
  }

  public double getValue() {
      return value;
  }

  public Date getDate() {
      return date;
  }

  public String getDateString() {
      return dateString;
  }

  public String getVendor(){
      return vendor;
  }

}
