package main.transactionsubsys;

import java.io.*;
import main.respositorysubsys.Transaction;
import BankDataInterface;

public class BankDataController {
   
   public static Transaction parseAndMakeTransactions(String acctName, File bankFileName){
      BankDataInterface handler = new BankDataInterface();
      String[] transactions = handler.getTransactions(acctName);
      
   }
}
