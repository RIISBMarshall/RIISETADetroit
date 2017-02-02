package bhouse.travellist_starterproject;

import android.app.Application;
import android.database.Cursor;

/**
 * Created by bmarshall on 1/31/17.
 */

public class Controller extends Application {

    public Cursor getRoutes(String company) {
        TravelListDatabaseHelper travelListDatabaseHelper = new TravelListDatabaseHelper(this);
        Cursor routeCursor = travelListDatabaseHelper.getRoutes(company);
        return routeCursor;
    }

    public Cursor getRouteDetails(String route){
        TravelListDatabaseHelper travelListDatabaseHelper = new TravelListDatabaseHelper(this);
        Cursor routeDetailsCursor = travelListDatabaseHelper.getRouteDetails(route);
        return routeDetailsCursor;
    }
}
