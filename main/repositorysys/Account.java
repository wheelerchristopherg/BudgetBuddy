package main.repositorysys;

import java.util.*;
import main.repositorysys.Transaction;

public class Account {

  String type;
  double balance;
  double interestRate;
  String name;
  Collection<Transaction> transactions;

  public double getBalance() {
      return balance;
  }

  public boolean isSavings() {
      if(type.equals("savings")) {
          return true;
      }
      return false;
  }

  public Collection<Transaction> getTransactions() {
      return transactions;
  }
}
