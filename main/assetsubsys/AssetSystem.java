package main.assetsubsys;

import java.util.Date;
import main.repositorysys.Repository;

import java.util.*;
import java.io.*;

import main.userinterface.SavingsNetworthValueForm;
import main.userinterface.AmortizationCalendarForm;
import main.userinterface.Form;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;


public class AssetSystem {

    private static SavingsNetWorthValueController savNetWorthController;
    private static AmCalController amCalController;
    private static NewAssetController newAssetController;

    public static void createSavingsNetWorthValueController(String userChoice, Date startDate, SavingsNetworthValueForm formIn) {
        savNetWorthController = new SavingsNetWorthValueController(userChoice, startDate, formIn);
    }

    public static void createAmCalController(AmortizationCalendarForm formIn, String loanNameIn) {
        amCalController = new AmCalController(formIn, loanNameIn);
    }

    public static void createNewAssetController(Form form) {
        newAssetController = new NewAssetController(form);
    }

    public static NewAssetController getNewAssetController() {
        return newAssetController;
    }

    public static void parseAssetCSV() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("main/data/assets.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] dat = line.split(",");
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");

                try {
                    Date date = format.parse(dat[3]);
                    Repository.createAsset(dat[0], dat[1], Double.parseDouble(dat[2]), date);
                 } catch (ParseException e) {
                     System.out.println("Incorrect date format");
                 } // catch
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        } // catch
    } // parseAssetCSV()

}
