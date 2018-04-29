package main.assetsubsys;
import main.userinterface.Form;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.text.DecimalFormat;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;
import main.repositorysys.Asset;
import main.repositorysys.Repository;

public class DisplayValueOfAssetsController {

    public DisplayValueOfAssetsController(Form form) {

        double assetSum = 0;
        String line = "";

        for (Asset a : Repository.getAssets())
            assetSum += a.getValue();

        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        JOptionPane.showMessageDialog(form, "Value of assets: $"+ formatter.format(assetSum));

    } // DisplayValueOfAssetsController()

} // DisplayValueOfAssetsController
