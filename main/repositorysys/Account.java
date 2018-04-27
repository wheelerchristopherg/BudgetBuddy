package main.repositorysys;

public class Account {

  private String type;
  private double balance;
  private double interestRate;
  private String name;
  private Collection<Transaction> transactionCollection;

  public Account() {

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

  public Collection<Transaction> getTransactions() {
      return transactions;
  }
}
