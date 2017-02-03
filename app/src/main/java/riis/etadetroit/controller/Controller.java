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

    public Cursor getCompanyNames(){
        ETADetroitDatabaseHelper ETADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
        Cursor companyNamesCursor = ETADetroitDatabaseHelper.getCompanyNames();
        return companyNamesCursor;
    }

    public int getCompanyListSize(){
        CompanyData companyData = new CompanyData(getCompanyNames());
        return companyData.getCompanyListSize();
    }

    public Company getCompany(int position){
        CompanyData companyData = new CompanyData(getCompanyNames());
        return companyData.getCompany(position);
    }

    public String getCompanyName(int position){
        return getCompany(position).getName();
    }

    public int getCompanyImageResourceId(Context context, int positon){
        return getCompany(positon).getImageResourceId(context);
    }

    public Cursor getRoutes(String company) {
        ETADetroitDatabaseHelper ETADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
        Cursor routeCursor = ETADetroitDatabaseHelper.getRoutes(company);
        return routeCursor;
    }

    public Cursor getRouteDetails(String route){
        ETADetroitDatabaseHelper ETADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
        Cursor routeDetailsCursor = ETADetroitDatabaseHelper.getRouteDetails(route);
        return routeDetailsCursor;
    }

    public Cursor getRouteStops(String route_id){
        ETADetroitDatabaseHelper ETADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
        Cursor routeStopsCursor = ETADetroitDatabaseHelper.getRouteStops(route_id);
        return routeStopsCursor;
    }
}
