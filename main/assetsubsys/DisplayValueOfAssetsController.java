package main.assetsubsys;
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
import java.text.DecimalFormat;

public class DisplayValueOfAssetsController {

    public DisplayValueOfAssetsController(Form form) {

        System.out.println("in con");

        double assetSum = 0;
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("main/data/assets.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(",");
                assetSum += Double.parseDouble(rmdline[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        JOptionPane.showMessageDialog(form, "Value of assets: $"+ formatter.format(assetSum));

    } // DisplayValueOfAssetsController()


} // DisplayValueOfAssetsController
