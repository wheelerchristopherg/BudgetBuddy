package main.repositorysubsys;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class BankDataInterface {
   public static boolean accountExists(String acctName, File bankFileName)throws FileNotFoundException{
      if(bankFileName.exists() != true){
         throw new FileNotFoundException("Critical Error: Bank file inputted was not found or does not exist.");
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
   
}
