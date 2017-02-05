package riis.etadetroit.model;

import android.database.Cursor;

import java.util.ArrayList;

public class CompanyData {


    private final ArrayList<Company> companyList;

    public CompanyData(Cursor companyNames) {

        companyList = new ArrayList<>();

        while (companyNames.moveToNext()) {
            Company company = new Company();
            company.setName(companyNames.getString(0));
            company.setImageName(companyNames.getString(0).replaceAll("\\s+", "").toLowerCase());

            companyList.add(company);
        }
    }

    public Company getCompany(int position) {
        return companyList.get(position);
    }

    public int getCompanyListSize() {
        return companyList.size();
    }
}
