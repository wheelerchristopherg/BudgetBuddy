package main.repositorysys;
import java.util.*;

public class Account {

  private String name;
  private String type;
  private double balance;
  private double interestRate;
  private Collection<Transaction> transactionCollection;

  public Account() {
    transactionCollection = new ArrayList<Transaction>();
  }

  public Account(String inName, String inType, double inBal, double inRate) {
      this.name = inName;
      this.type = inType;
      this.balance = inbal;
      this.interestRate = inRate;
  }

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
  
  public Collection<Transaction> getTransactions(){
    return transactionCollection;
  }

  public void setName(String name){
    this.name = name;
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

  public Transaction createTransaction(String inCat, double inVal, String inDate, String inVen){
    zTransaction = new Transaction(inCat, inVal, inDate, inVen);
    transactionCollection.add(zTransaction);
    return zTransaction;
  }

}
