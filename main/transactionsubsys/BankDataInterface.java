package main.transactionsubsys;

import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import main.repositorysys.Transaction;

public class BankDataInterface {
   private static String bankFileDirectory = "C:/Users/black/Desktop/BankTest/BudgetBuddy/main/transactionsubsys/Bank.txt";
   private static String dataDirectory = "C:/Users/black/Desktop/BankTest/BudgetBuddy/main/transactionsubsys/";


   public BankDataInterface() {
       System.out.println("top of bank interface");
       parseBills();
   }

   // this is a helper method for parseBills() and parseAcccounts()
   // inputs: filepath of csv file
   // outputs: 2d list of data in csv file
   public static ArrayList<String[]> parseGenericCSV(String filepath) {
       System.out.println("top of bank parseGeneric");

       String line = "";
       ArrayList<String[]> result();

       try (BufferedReader bra = new BufferedReader(new FileReader(filepath))) {
           while ((line = bra.readLine()) != null) {
               result.add(line.split(","));
           } // while
       } catch (IOException e) {
           e.printStackTrace();
       } // catch

       return result;
   } // parseGenericCSV

//    public Bill(String name, double value, String dueDateString) {

   public static void paseBills() {
       System.out.println("top of bank parse bills");

       String billFilePath = "/main/data/bank/bills.csv";
       ArrayList<String[]>  parsedData = parseGenericCSV(billFilePath);

       for (String[] dat : parsedData) {

           Double value = Double.Double.parseDouble(dat[1]);
           Bill b = new Bill(dat[0], value, dat[2]);
           Repository.addBill(b);

           System.out.println(dat);

       }

   } // paseBills()


   public static void parseAccounts() {
       String accountsFilePath = "/main/data/bank/bills.csv";



   } // getAccounts()






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

    TransactionSystem tsys = new TransactionSystem();
    //RecordTransactionController rtc = new RecordTransactionController();

    // Generate Transactions from bank
    public void generateTransactions(int numOfTransactions) {
        for(int i = 0; i <= numOfTransactions; i++) {

            //Generate Random Type
            String randString = getRandomWord(5); //Replace with categories

            //Generate Random Value
            double upper = 10000;
            double lower = -10000;
            double randValue = Math.round( (Math.random() * (upper - lower) + lower) * 100.0) / 100.0;


            //Generate Random Date
            Random rand = new Random();
            int dateHighm = 12;
            int dateLowm = 1;
            int randDatd_month = rand.nextInt((dateHighm - dateLowm) + 1) + dateLowm;

            int dateHighd = 30;
            int dateLowd = 1;
            int randDatd_day = rand.nextInt((dateHighd - dateLowd) + 1) + dateLowd;

            int dateHighy = 18;
            int dateLowy = 10;
            int randDatd_year = rand.nextInt((dateHighy - dateLowy) + 1) + dateLowy;

            Transaction tempTransaction = new Transaction(randString, randValue,
                    randDatd_month + "-" + randDatd_day + "-20" + randDatd_year);
            tsys.addTransaction(tempTransaction);
        }
        tsys.saveTransactions(); //Save the transactions

    }

   private String getRandomWord(int length) {
        String[] list = {"Food", "Services", "Games", "Item", "Groceries", "Bill"
                , "Gift", "Automotive", "Fuel", "Medical", "Insurance"
                , "Office", "Supplies", "Home", "Pet Care", "Mortgage"
                , "Rent", "Loan", "Personal", "Cable", "Phone", "Reward"
                , "Entertainment", "Recreation"}; //23
        Random rand = new Random();
        int high = 12;
        int low = 1;
        int randN = rand.nextInt((high - low) + 1) + low;
        return list[randN];
    }
}
