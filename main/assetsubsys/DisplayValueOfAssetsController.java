package main.assetsubsys;
import main.userinterface.Form;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

public class DisplayValueOfAssetsController {

    public DisplayValueOfAssetsController(Form form) {

        double assetSum = 0;
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("main/data/assets.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] rmdline = line.split(",");
                assetSum += Double.parseDouble(rmdline[2]);
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        } // catch

        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        
        //Clean up font, text size, etc.
        UIManager.put("OptionPane.minimumSize",new Dimension(800,300));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 40));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Arial",Font.PLAIN,35)));
        
        JOptionPane.showMessageDialog(form, "Value of assets: $"+ formatter.format(assetSum));

    } // DisplayValueOfAssetsController()

} // DisplayValueOfAssetsController
