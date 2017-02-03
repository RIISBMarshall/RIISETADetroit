package bhouse.travellist_starterproject.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import bhouse.travellist_starterproject.R;
import bhouse.travellist_starterproject.controller.Controller;

public class BusRouteDetailsActivity extends Activity {

    private Cursor routeDetailsCursor;
    public static final String EXTRA_ROUTE = "route";
    private TextView routeDetails;
    private String route;
    String routeId;
    private ListView stopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route_details);
        final Controller aController = (Controller) getApplicationContext();
        Intent intent = getIntent();
        route = intent.getStringExtra(EXTRA_ROUTE);
        routeDetails = (TextView) findViewById(R.id.routeDetails);
        getRouteDetails(aController);
        getRouteStops(aController);
    }

    private void getRouteDetails(Controller aController){
        routeDetailsCursor = aController.getRouteDetails(route);

        if (routeDetailsCursor.moveToFirst()) {
            routeDetails.setText("ROUTE DETAILS" +
                    "\n\nROUTE: " + route +
                    "\nROUTE NUMBER: " + routeDetailsCursor.getString(2) +
                    "\nDIRECTION 1: " + routeDetailsCursor.getString(3) +
                    "\nDIRECTION 2: " + routeDetailsCursor.getString(4) +
                    "\nDAYS ACTIVE: " + routeDetailsCursor.getString(5) +
                    "\n\nSTOPS");

            routeId = routeDetailsCursor.getString(6);
        }
    }

    private void getRouteStops(Controller aController){
        Cursor routeStopsCursor = aController.getRouteStops(routeId);

        CursorAdapter routeStopsCursorAdapter = new SimpleCursorAdapter(this, R.layout.list_white_text, routeStopsCursor, new String[]{"stop_name"},
                new int[]{R.id.list_content}, 0);
        ListView stopList = (ListView) findViewById(R.id.stopList);
        stopList.setAdapter(routeStopsCursorAdapter);
    }
}
