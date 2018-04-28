package main.assetsubsys;

import java.util.Date;
import main.userinterface.SavingsNetworthValueForm;
import main.userinterface.AmortizationCalendarForm;
import main.userinterface.Form;

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

}
