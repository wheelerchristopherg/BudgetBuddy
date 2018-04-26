package main.repositorysys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Transaction {

  private String type;
  private double value;
  private Date date;
  private String dateString;

  public Transaction(String type, double value, String transDate) {
      this.dateString = transDate;
      try {
          DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
          Date date = format.parse(transDate);
          this.date = date;
      } catch (ParseException e) {
          // WRONG FORMAT
      }
      this.type = type;
      this.value = value;
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

  public String getDateString() {
      return dateString;
  }

}
