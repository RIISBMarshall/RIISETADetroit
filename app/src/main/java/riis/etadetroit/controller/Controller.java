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
        return eTADetroitDatabaseHelper.getCompanyNames().getCount();
    }

    public String getCompanyName(int position) {
        Cursor companyNames = eTADetroitDatabaseHelper.getCompanyNames();

        if (companyNames.moveToPosition(position)) {
            return companyNames.getString(0);
        }
        return null;
    }

    public int getCompanyImageResourceId(Context context, int position) {
        Cursor companyNames = eTADetroitDatabaseHelper.getCompanyNames();
        String imageName;
        if (companyNames.moveToPosition(position)) {
            imageName = companyNames.getString(0).toLowerCase();
            return context.getResources().getIdentifier(imageName, "drawable",
                    context.getPackageName());
        }
        return 0;
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
