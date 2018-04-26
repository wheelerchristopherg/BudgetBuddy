package main.assetsubsys;
import main.repositorysys.Asset;
import main.userinterface.Form;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DisplayValueOfAssetsController {

    private ArrayList<Asset> assets;


    public void DisplayValueOfAssetsController() {

        double assetSum = 0;
        String csvFile = "/data/assets.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(cvsSplitBy);
                assetSum += Double.parseDouble(rmdline[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendNotification(assetSum);

    } // DisplayValueOfAssetsController()

    // Sends BillPay Notification to user
    public void sendNotification(double sum) {
        JOptionPane.showMessageDialog(null, "Value of assets: "+ sum + "!");
    } // sendNotification()


} // DisplayValueOfAssetsController
