package riis.etadetroit.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by bmarshall on 1/31/17.
 */

public class ETADetroitDatabaseHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "ETADetroitDatabase.db";
    private SQLiteDatabase db;

    public ETADetroitDatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    private Cursor getCompanyNames() {
        try {
            db = getReadableDatabase();
            return db.query(true, "routes", new String[]{"company"},
                    null, null, null, null, null, null);
        } catch (SQLiteException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Cursor getRoutes(String company) {
        try {
            db = getReadableDatabase();
            return db.query("routes", new String[]{"_id", "route_name", "route_number"},
                    "company = ?", new String[]{company}, null, null, "cast(route_number as unsigned)");
        } catch (SQLiteException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Cursor getRouteDetails(String route) {
        try {
            db = getReadableDatabase();
            return db.query("routes", new String[]{"_id",
                            "company", "route_number", "direction1", "direction2", "days_active", "route_id"},
                    "route_name = ?", new String[]{route}, null, null, null);
        } catch (SQLiteException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Cursor getRouteStops(String route_id) {
        try {
            db = getReadableDatabase();
            return db.query("stop_locations", new String[]{"_id", "stop_name"},
                    "route_id = ?", new String[]{route_id}, null, null, null);
        } catch (SQLiteException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String getCompanyName(int position) {
        Cursor companyNames = getCompanyNames();

        if (companyNames != null && companyNames.moveToPosition(position)) {
            return companyNames.getString(0);
        }
        return null;
    }

    public int getCompanyListSize() {
        return getCompanyNames().getCount();
    }

    public int getCompanyImageResourceId(Context context, int position) {
        Cursor companyNames = getCompanyNames();
        String imageName;
        if (companyNames != null && companyNames.moveToPosition(position)) {
            imageName = companyNames.getString(0).toLowerCase();
            return context.getResources().getIdentifier(imageName, "drawable",
                    context.getPackageName());
        }
        return 0;
    }
}
