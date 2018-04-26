package main.repositorysys;

import java.util.*;

public class Asset {

  String type;
  String name;
  double value;
  Date date;

  public boolean isBefore(Date dateIn) {
      return date.before(dateIn);
  }

  public double getValue() {
      return value;
  }
}
