package riis.etadetroit.model;

import java.util.ArrayList;

public class BusCompanyData {

  public static String[] placeNameArray = {"SmartBus", "DDOT", "RefleX"};

  public static ArrayList<BusCompany> placeList() {
    ArrayList<BusCompany> list = new ArrayList<>();
    for (int i = 0; i < placeNameArray.length; i++) {
      BusCompany busCompany = new BusCompany();
      busCompany.name = placeNameArray[i];
      busCompany.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
      if (i == 2 || i == 5) {
        busCompany.isFav = true;
      }
      list.add(busCompany);
    }
    return (list);
  }
}
