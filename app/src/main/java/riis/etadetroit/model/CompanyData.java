package riis.etadetroit.model;

import java.util.ArrayList;

public class CompanyData {

    public static String[] placeNameArray = {"SmartBus", "DDOT", "RefleX"};

    public static ArrayList<Company> placeList() {
        ArrayList<Company> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            Company company = new Company();
            company.name = placeNameArray[i];
            company.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();

            list.add(company);
        }
        return (list);
    }
}
