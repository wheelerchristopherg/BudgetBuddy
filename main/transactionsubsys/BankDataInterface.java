package main.transactionsubsys;

import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class BankDataInterface {
   private static String bankFileDirectory = "C:/Users/black/Desktop/BankTest/BudgetBuddy/main/transactionsubsys/Bank.txt";
   private static String dataDirectory = "C:/Users/black/Desktop/BankTest/BudgetBuddy/main/transactionsubsys/";
   
   public static boolean accountExists(String acctName)throws FileNotFoundException{
      File bankFile = new File(bankFileDirectory);
      if(bankFile.exists() != true){
         return false;
      }
      if(bankFile.canRead() != true){
         return false;
      }
      
      Scanner bankScan = new Scanner(bankFile);
      String line = bankScan.nextLine();
      System.out.println(acctName);
      System.out.println(line);
      while(bankScan.hasNextLine()){
         if(line.equals(acctName)){
            return true;
         }
         line = bankScan.nextLine();
      }
      return false;
   }
   
   public static boolean loanExists(String acctName, String bankFileName, String loanName)throws FileNotFoundException{
      if(accountExists(acctName) != true){
         return false;
      }
      File acctFile = new File(dataDirectory + loanName + ".txt");
      Scanner loanScan = new Scanner(acctFile);
      String line = loanScan.next();
      while(loanScan.hasNextLine()){
         if(line == loanName){
            return true;
         }
      }
      return false;
   }
   
   public static String[] getTransactions(String acctName)throws FileNotFoundException{
      if(accountExists(acctName) != true){
         throw new FileNotFoundException("Account Not Found.");
      }
      File acctTransFile = new File(dataDirectory + acctName + "Transactions.txt");
      Scanner transScan = new Scanner(acctTransFile);
      int num = getNumOfTransactions(acctName);
      
      String line = null;
      String[] transactions = new String[num];
      int index = 0;
      while(transScan.hasNextLine()){
         transactions[index] = line;
         line = transScan.nextLine();
         index++;
      }
      
      return transactions;
   }
   
   public static int getNumOfTransactions(String acctName){
      int numOfTransactions = 0;
      File acctTransFile1 = new File(dataDirectory + acctName + "Transactions.txt");
      Scanner transScan1 = null;
      try {
         transScan1 = new Scanner(acctTransFile1);
         }
      catch(FileNotFoundException e){
         System.out.println("Transactions file not found.");
      }
      String line = null;
      while(transScan1.hasNextLine()){
         numOfTransactions++;
         line = transScan1.nextLine();
      }
      return numOfTransactions;
   }
   
}
