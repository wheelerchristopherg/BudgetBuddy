package main.repositorysys;
import java.util.*;

public class Account {

  private String name;
  private String type;
  private double balance;
  private double interestRate;
  private Collection<Transaction> transactionCollection;

  public Account(String inName, String inType, double inBal, double inRate) {
      transactionCollection = new ArrayList<Transaction>();
      this.name = inName;
      this.type = inType;
      this.balance = inBal;
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
  
  public Transaction createTransaction(String inCat, double inVal, String inDate){
    Transaction zTransaction = new Transaction(inCat, inVal, inDate);
    transactionCollection.add(zTransaction);
    return zTransaction;
  }

  public boolean isSavings() {
      if(type.equals("savings")) {
          return true;
      }
      return false;
  }

    public boolean isCredit() {
        if(type.equals("credit")) {
            return true;
        }
        return false;
    }

}
