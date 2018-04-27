package main.assetsubsys;
import java.util.Date;
import main.repositorysys.SavingsNetWorthValueController;

public class AssetSystem {

    private static SavingsNetWorthValueController savNetWorthController;

    public static void createSavingsNetWorthValueController(String userChoice, Date startDate, SavingsNetworthValueForm formIn) {
        savNetWorthController = new SavingsNetWorthValueController(userChoice, startDate, formIn);
    }

}
