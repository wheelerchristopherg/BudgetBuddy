package main.transactionsubsys;

import java.io.*;
import main.repositorysys.Transaction;
import main.transactionsubsys.BankDataInterface;

public class BankDataController {
   
   public static Transaction parseAndMakeTransactions(String acctName, File bankFileName){
      BankDataInterface handler = new BankDataInterface();
      try {
         String[] transactions = handler.getTransactions(acctName);
      }
      catch(FileNotFoundException e){
         System.out.println(e + "File Not found.");
      }
       return null;
   }
}
