package main.repositorysys;

public class Account {

  private String type;
  private double balance;
  private double interestRate;
  private String name;
  
  public String getType(){
      return type;
  }
  
  public double getBalance(){
      return balance;
  }
  
  public double getInterestRate(){
      return interestRate;
  }
  
  public String getName(){
      return name;
  }
  
  public void setType(String type){
      this.type = type;
  }
  
  public void setBalance(double balance){
      this.balance = balance;
  }
  
  public void setInterestRate(double interestRate){
      this.interestRate = interestRate;
  }
  
  public void setInterestRate(String name){
      this.name = name;
  }
}
