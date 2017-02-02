package bhouse.travellist_starterproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class RouteDetailsActivity extends Activity {

    private Cursor routeDetailsCursor;
    public static final String EXTRA_ROUTE = "route";
    private TextView route_name;
    private TextView route_number;
    private TextView direction1;
    private TextView direction2;
    private TextView days_active;
    private String route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        final Controller aController = (Controller) getApplicationContext();
        Intent intent = getIntent();
        route = intent.getStringExtra(EXTRA_ROUTE);
        route_name = (TextView) findViewById(R.id.route_name);
        route_number = (TextView) findViewById(R.id.route_number);
        direction1 = (TextView) findViewById(R.id.direction1);
        direction2 = (TextView) findViewById(R.id.direction2);
        days_active = (TextView) findViewById(R.id.days_active);
        getRouteDetails(aController);
    }

    private void getRouteDetails(Controller aController){
        routeDetailsCursor = aController.getRouteDetails(route);

        if (routeDetailsCursor.moveToFirst()) {
            route_name.setText("ROUTE: " + route);
            route_number.setText("ROUTE NUMBER: " + routeDetailsCursor.getString(2));
            direction1.setText("DIRECTION 1: " + routeDetailsCursor.getString(3));
            direction2.setText("DIRECTION 2: " + routeDetailsCursor.getString(4));
            days_active.setText("DAYS ACTIVE: " + routeDetailsCursor.getString(5));
        }
    }
}
