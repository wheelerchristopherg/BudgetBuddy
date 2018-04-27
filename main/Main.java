package main;

import java.io.*;
import main.transactionsubsys.BankDataInterface;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args)throws FileNotFoundException{
        String acctName = "account1";
        File bankFile = new File("Bank.txt");

        BankDataInterface handler = new BankDataInterface();
        try{
            String [] transactions = handler.getTransactions(acctName, bankFile);
        }
        catch(FileNotFoundException e){
            System.out.println(e + "File not found");
        }
    }
}
