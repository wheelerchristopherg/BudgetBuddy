package main.repositorysys;

import java.util.*;

public class Asset {

  private String type;
  private String name;
  private double value;
  private Date date;

  public boolean isBefore(Date dateIn) {
      return date.before(dateIn);
  }

  public double getValue() {
      return value;
  }
}
