package main.assetsubsys;
import java.util.Date;

public class AssetSystem {

    private static SavingsNetWorthValueController savNetWorthController;

    public static void createSavingsNetWorthController(String userChoice, Date startDate, SavingsNetworthValueForm formIn) {
        savNetWorthController = new SavingsNetWorthController(userChoice, startDate, formIn);
    }

}
