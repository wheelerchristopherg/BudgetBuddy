package main.repositorysys;
import java.util.*;


public class Budget {
    String name;
    Date startDate;
    Date endDate;
    double spendingCap;

Budget(String inName, Date inStart, Date inEnd, double inSpend){
    this.name = inName;
    this.startDate = inStart;
    this.endDate = inEnd;
    this.spendingCap = inSpend;
  }
}
