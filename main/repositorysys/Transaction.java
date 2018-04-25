package main.repositorysys;

import java.util.*;

public class Transaction {

  private String type;
  private double value;
  private Date date;
  
  public String getType(){
      return type;
  }
  
  public double getValue(){
      return value;
  }
  
  public Date getDate(){
      return date;
  }
  
  public void setType(String type){
      this.type = type;
  }
  
  public void setValue(double value){
      this.value = value;
  }
  
  public void setDate(Date date){
      this.date = date;
  }
  
}
