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

        UIManager.put("OptionPane.minimumSize",new Dimension(800,300));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 40));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Arial",Font.PLAIN,35)));

        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        JOptionPane.showMessageDialog(form, "Value of assets: $"+ formatter.format(assetSum));

    } // DisplayValueOfAssetsController()

} // DisplayValueOfAssetsController
