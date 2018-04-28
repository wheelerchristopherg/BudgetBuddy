package main.userinterface;

import java.awt.event.ActionEvent;
import main.repositorysys.FinancialReport;
import main.transactionsubsys.FinancialReportController;
import javax.swing.JOptionPane;

public class FinancialReportForm extends Form {
    public FinancialReportForm(Window parent){
        super (parent);

        setGridLayout(3, 1); // Set grid
        addLabel("Financial Reporting");// add label
        addPlaceholder(); // + placeholder
        // Add button/buttons
        addButton("submit", "Generate Financial Report");
        addTextArea("finRepArea",40,200,false);
        addButton("back","Back");
        addButton("export", "Export Financial Report");

    }


    public void actionPerformed(ActionEvent event) {
        FinancialReportController frc = new FinancialReportController();
        String name = buttonPressed(event);
        switch (name) {
            case "submit":
                frc.displayFinancialReport(this,"finRepArea");
                break;
            case "export":
                frc.exportReportToTextFile();
                JOptionPane.showMessageDialog(this, "Report Exported!");
                break;
            case "back":
                goBack();
                break;
        }
    }
}
