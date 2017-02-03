package bhouse.travellist_starterproject.controller;

import android.app.Application;
import android.database.Cursor;

import bhouse.travellist_starterproject.model.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 1/31/17.
 */

public class Controller extends Application {

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
}
