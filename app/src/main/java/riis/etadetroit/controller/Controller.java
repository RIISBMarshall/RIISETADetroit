package riis.etadetroit.controller;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.model.Company;
import riis.etadetroit.model.CompanyData;
import riis.etadetroit.model.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 1/31/17.
 */

public class Controller extends Application {
    private ETADetroitDatabaseHelper eTADetroitDatabaseHelper;

    @Override
    public void onCreate(){
        eTADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
    }

    private Cursor getCompanyNames() {
        return eTADetroitDatabaseHelper.getCompanyNames();
    }

    public int getCompanyListSize() {
        CompanyData companyData = new CompanyData(getCompanyNames());
        return companyData.getCompanyListSize();
    }

    private Company getCompany(int position) {
        CompanyData companyData = new CompanyData(getCompanyNames());
        return companyData.getCompany(position);
    }

    public String getCompanyName(int position) {
        return getCompany(position).getName();
    }

    public int getCompanyImageResourceId(Context context, int positon) {
        return getCompany(positon).getImageResourceId(context);
    }

    public Cursor getRoutes(String company) {
        return eTADetroitDatabaseHelper.getRoutes(company);
    }

    public Cursor getRouteDetails(String route) {
        Cursor routeDetailsCursor = eTADetroitDatabaseHelper.getRouteDetails(route);
        return routeDetailsCursor;
    }

    public Cursor getRouteStops(String route_id) {
        Cursor routeStopsCursor = eTADetroitDatabaseHelper.getRouteStops(route_id);
        return routeStopsCursor;
    }
}
