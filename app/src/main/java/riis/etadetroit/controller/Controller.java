package riis.etadetroit.controller;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import riis.etadetroit.model.ETADetroitDatabaseHelper;

/**
 * Created by bmarshall on 1/31/17.
 */

public class Controller extends Application {
    private ETADetroitDatabaseHelper eTADetroitDatabaseHelper;

    @Override
    public void onCreate() {
        eTADetroitDatabaseHelper = new ETADetroitDatabaseHelper(this);
    }

    public int getCompanyListSize() {
        return eTADetroitDatabaseHelper.getCompanyListSize();
    }

    public String getCompanyName(int position) {
        return eTADetroitDatabaseHelper.getCompanyName(position);
    }

    public int getCompanyImageResourceId(Context context, int position) {
        return eTADetroitDatabaseHelper.getCompanyImageResourceId(context, position);
    }

    public Cursor getRoutes(String company) {
        return eTADetroitDatabaseHelper.getRoutes(company);
    }

    public Cursor getRouteDetails(String route) {
        return eTADetroitDatabaseHelper.getRouteDetails(route);
    }

    public Cursor getRouteStops(String route_id) {
        return eTADetroitDatabaseHelper.getRouteStops(route_id);
    }
}
