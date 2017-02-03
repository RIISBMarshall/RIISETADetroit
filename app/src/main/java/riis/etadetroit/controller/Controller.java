package riis.etadetroit.controller;

import android.app.Application;
import android.database.Cursor;

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
