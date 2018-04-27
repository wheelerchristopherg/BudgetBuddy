package main.repositorysys;
import java.util.*;


public class Loan {

  private double amount;
  private double interestRate;
  private Date startDate;
  private Date endDate;


  public Loan(double amount, double interestRate, Date startDate, Date endDate) {
      this.amount = amount;
      this.interestRate = interestRate;
      this.startDate = startDate;
      this.endDate = endDate;
  }

  public double getAmount(){
      return amount;
  }

  public double getInterestRate(){
      return interestRate;
  }

  public Date getStartDate(){
      return startDate;
  }

  public Date getEndDate(){
      return endDate;
  }

  public void setAmount(double amount){
      this.amount = amount;
  }

  public void setInterestRate(double interestRate){
      this.interestRate = interestRate;
  }

  public void setStartDate(Date startDate){
      this.startDate = startDate;
  }

  public void setEndDate(Date endDate){
      this.endDate = endDate;
  }
}
