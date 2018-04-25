import java.util.Date;
import java.util.Scanner;
import java.io.File;

public class BankDataInterface {
   String acctName = 

   public static boolean accountExists(String acctName, File bankFileName){
      if(bankFileName.exists() != true){
         System.out.println("Critical Error: Bank file inputted was not found or does not exist.");
      }
      if(bankFileName.canRead() != true){
         System.out.println("Error: The specified file cannot be read.");
      }
      Scanner bankScan = new Scanner(bankFileName);
      String line = bankScan.next();
      while(bankScan.hasNextLine()){
         if(line == acctName){
            return true;
         }
      }
      return false;
   }
   
   public static void updateTransactions(){
      if(accountExists() == true){
      
      }
      else {
      
      }
   }
   
   public static void updateLoans(){
      if(accountExists() == true){
      
      }
      else {
      
      }
   
   }
}