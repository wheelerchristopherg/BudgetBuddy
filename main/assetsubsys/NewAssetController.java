package main.assetsubsys;

import main.userinterface.Form;
import main.repositorysys.Repository;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NewAssetController {
    
    private Form form;
    
    public NewAssetController(Form form) {
        this.form = form;
    }
    
    public void validate() {
        String name = form.getTextFromInput("name");
        String type = form.getTextFromInput("type");
        String valueString = form.getTextFromInput("value");
        String dateString = form.getTextFromInput("date");
        
        double value = 0;
        Date date = new Date();
        
        String error = "";
        
        if (name.equals("")) {
            error += "name cannot be blank\n";
        }
        if (type.equals("")) {
            error += "type cannot be blank\n";
        }
        try {
            value = Double.parseDouble(valueString);
        } catch (Exception e) {
            error += "value must be a number\n";
        }
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
            date = format.parse(dateString);
        } catch (ParseException e) {
            error += "date format incorrect";
        }
        
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(form, error);
        } else {
            Repository.createAsset(name, type, value, date);
            addToFile(name + "," + type + "," + valueString + "," + dateString);
            JOptionPane.showMessageDialog(form, "Asset added!");
            form.goBack();
        }
        
    }
    
    private void addToFile(String output) {
        BufferedWriter bw = null;

        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter("main/data/assets.csv", true));
            bw.write(output);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {                       // always close the file
            if (bw != null) try {
            bw.close();
            } catch (IOException ioe2) {
                // just ignore it
            }
        } // end try/catch/finally
    }

}
