package bhouse.travellist_starterproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.transition.Transition;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    public static final String EXTRA_PARAM_ID = "place_id";
    private ListView mList;
    private ImageView mImageView;
    private TextView mTitle;
    private LinearLayout mTitleHolder;
    private LinearLayout mRevealView;
    private BusCompany mBusCompany;
    private Cursor routeCursor;
    private RouteCursorAdapter routeAdapter;
    int defaultColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Controller aController = (Controller) getApplicationContext();

        mBusCompany = BusCompanyData.placeList().get(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        mList = (ListView) findViewById(R.id.list);
        mImageView = (ImageView) findViewById(R.id.busImage);
        mTitle = (TextView) findViewById(R.id.textView);
        mTitleHolder = (LinearLayout) findViewById(R.id.busNameHolder);
        mRevealView = (LinearLayout) findViewById(R.id.llEditTextHolder);
        defaultColor = getResources().getColor(R.color.primary_dark);
        mRevealView.setVisibility(View.INVISIBLE);

        setUpAdapter(aController);
        loadBusCompany();
        windowTransition();
        getPhoto();

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (routeCursor.moveToPosition(position)) {
                    Intent intent = new Intent(DetailActivity.this, RouteDetailsActivity.class);
                    intent.putExtra(RouteDetailsActivity.EXTRA_ROUTE, routeCursor.getString(1));
                    startActivity(intent);
                }
            }
        });
    }

    private void setUpAdapter(Controller aController) {
        routeCursor = aController.getRoutes(mBusCompany.name);
        routeAdapter = new RouteCursorAdapter(this, routeCursor);
        mList.setAdapter(routeAdapter);
    }

    private void loadBusCompany() {
        mTitle.setText(mBusCompany.name);
        mImageView.setImageResource(mBusCompany.getImageResourceId(this));
    }

    private void windowTransition() {
        getWindow().getEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                getWindow().getEnterTransition().removeListener(this);
            }
        });

    }

    private void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(), mBusCompany.getImageResourceId(this));
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        Palette mPalette = Palette.generate(photo);
        applyPalette(mPalette);
    }

    private void applyPalette(Palette mPalette) {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        mTitleHolder.setBackgroundColor(mPalette.getMutedColor(defaultColor));
        mRevealView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
    }

}
