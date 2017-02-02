package bhouse.travellist_starterproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.IOException;

/**
 * Created by bmarshall on 1/31/17.
 */

public class TravelListDatabaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "ETADetroitDatabase.db";

    private final Context myContext;

    private SQLiteDatabase db;

    public TravelListDatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getRoutes(String company) {
        try {
            db = getReadableDatabase();
            Cursor routeCursor = db.query("routes", new String[]{"_id", "route_name"},
                    "company = ?", new String[]{company}, null, null, null);
            return routeCursor;
        } catch (SQLiteException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public Cursor getRouteDetails(String route){
        try{
            db = getReadableDatabase();
            Cursor routeDetailsCursor = db.query("routes", new String[]{"_id",
                    "company", "route_number", "direction1", "direction2", "days_active"},
                    "route_name = ?", new String[]{route}, null, null, null);
            return routeDetailsCursor;
        } catch (SQLiteException e){
            System.out.println(e.toString());
            return null;
        }
    }
}