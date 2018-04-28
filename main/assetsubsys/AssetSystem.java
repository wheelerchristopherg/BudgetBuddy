package main.assetsubsys;

import java.util.Date;
import main.userinterface.SavingsNetworthValueForm;
import main.userinterface.AmortizationCalendarForm;

public class AssetSystem {

    private static SavingsNetWorthValueController savNetWorthController;
    private static AmCalController amCalController;

    public static void createSavingsNetWorthValueController(String userChoice, Date startDate, SavingsNetworthValueForm formIn) {
        savNetWorthController = new SavingsNetWorthValueController(userChoice, startDate, formIn);
    }
    
    public static void createAmCalController(AmortizationCalendarForm formIn, String loanNameIn) {
        amCalController = new AmCalController(formIn, loanNameIn);
    }

}
