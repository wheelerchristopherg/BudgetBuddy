package main.assetsubsys;
import java.util.Date;

public class AssetSystem {

    private static SavingsNetWorthValueController savNetWorthController;

    public static void createNetWorthSavingsController(String userChoice, Date startDate, Form formIn) {
        savNetWorthController = new SavingsNetWorthController(userChoice, startDate, formIn);
    }

}
