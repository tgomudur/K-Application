package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LocateMe extends FragmentActivity implements LocationListener,
		OnMapClickListener, OnMarkerClickListener {

	private static final LatLng AMSTERDAM = new LatLng(52.37518, 4.895439);

	private static final LatLng PARIS = new LatLng(48.856132, 2.352448);
	private static final LatLng FRANKFURT = new LatLng(50.111772, 8.682632);
	private static final LatLng ANNA = new LatLng(13.010964, 80.235404);
	private static final LatLng CHEPAK = new LatLng(13.0628, 80.2794);
	private static final LatLng CURRENT = new LatLng(13.0147462, 80.2385241);

	LocationManager locationmanager;
	String provider;

	public LatLng EventPlace;
	public LatLng UserCurrentLocation = new LatLng(13.010964, 80.235404);
	private static final LatLng CPDE = new LatLng(13.011742, 80.235511);
	public double latitudeSet[] = { 13.011643, 13.011742, 13.012082, 13.012659,
			13.012025, 13.010964, 13.012610, 13.011183, 13.011453, 13.012610,
			13.011545, 13.011399, 13.010369, 13.012565, 13.013280, 13.011840,
			13.011311, 13.010576, 13.012862 };
	public double longitudeSet[] = { 80.236056, 80.235511, 80.235593,
			80.235969, 80.237380, 80.235404, 80.235295, 80.236742, 80.237166,
			80.235295, 80.232923, 80.234492, 80.235887, 80.236438, 80.236364,
			80.234495, 80.232761, 80.237248, 80.236538 };
	private ObjectAnimator animation1;
	private ObjectAnimator animation2;
	private GoogleMap map;
	private LocationClient mLocationClient;
	private LatLng latLng;
	private SupportMapFragment fragment;
	private LatLngBounds latlngBounds;
	private ImageButton bNavigation;
	private Polyline newPolyline;
	private boolean isTravelingToParis = false;
	private int width, height;
	String eventPlace = "Event Location";
	boolean canrun = false;
	private ImageButton checkIn;
	private Button okiebtn;
	private AnimatorSet set;
	private Animation slideup, slideright;
	private FrameLayout myframe1, myframe2;
	private Dialog dialog;
	private LinearLayout naviagteMe;
	double curlati = 0;
	float x1, x2, y1, y2;
	int mapclickcnt = 0;
	double C_LAT = 13.010964, C_LON = 80.235404;
	double placeLatLocation = 13.010964, placeLongLocation = 80.235404;
	double current_latitude = 13.011749, current_longitude = 80.234956;

	int placeImage[] = { R.drawable.vivek_audi, R.drawable.cpde,
			R.drawable.snhhall, R.drawable.cse, R.drawable.maingallery,
			R.drawable.redbuilding, R.drawable.ece, R.drawable.minigallery,
			R.drawable.footballground, R.drawable.ece, R.drawable.tagaudi,
			R.drawable.eee, R.drawable.parkinglotopptosbi, R.drawable.mbaaudi,
			R.drawable.vivek_audi, R.drawable.manu, R.drawable.hmhsll,
			R.drawable.rcc, R.drawable.alumni };

	// myMapIntent.putExtra("LocationLati",1.1);
	// myMapIntent.putExtra("LocationLongi",2.1);
	@SuppressLint("NewApi")
	public void showRoute() {

		try {
			findDirections(C_LAT, C_LON, EventPlace.latitude,
					EventPlace.longitude, GMapV2Direction.MODE_WALKING);
		} catch (NullPointerException e) {
			Toast.makeText(this,
					"Unable To Get Directions...Check Your Network Connection",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void getCurrent() {
		try {
			locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();

			locationmanager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER, 0, 0, this);

			provider = locationmanager.getBestProvider(criteria, true);
			Location mylocation = locationmanager
					.getLastKnownLocation(provider);
			C_LAT = mylocation.getLatitude();
			C_LON = mylocation.getLongitude();
			UserCurrentLocation = new LatLng(C_LAT, C_LON);
		} catch (NullPointerException e) {

		}
	}

	public void showMyDirection(double placeLat, double placeLon) {
		try {
			locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();

			provider = locationmanager.getBestProvider(criteria, true);
			Location mylocation = locationmanager
					.getLastKnownLocation(provider);
			C_LAT = mylocation.getLatitude();
			C_LON = mylocation.getLongitude();
			/*
			 * MarkerOptions M2 = new MarkerOptions().position(new LatLng(
			 * current_latitude, current_longitude)); map.addMarker(M2);
			 * M2.title("Your Location");
			 * 
			 * MarkerOptions M3 = new MarkerOptions().position(new LatLng(
			 * placeLat,placeLon)); map.addMarker(M3);
			 * M3.title("Event Lcoation");
			 */
		} catch (NullPointerException e) {
			Toast.makeText(
					this,
					"Unable To Get Your Location...Check Your Network Connection",
					Toast.LENGTH_SHORT).show();
		}
		/*
		 * findDirections(current_latitude, current_longitude, ANNA.latitude,
		 * ANNA.longitude, GMapV2Direction.MODE_WALKING);
		 */

	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locateme);
		fragment = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map));
		map = fragment.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		TextView mtoast = (TextView) findViewById(R.id.mapToastmsg);
		ImageView ePlace = (ImageView) findViewById(R.id.eventplace);
		Intent myMapIntent = getIntent();
		int mapPlaceId;

		eventPlace = myMapIntent.getStringExtra("Eventname");
		mapPlaceId = myMapIntent.getIntExtra("locatethisplace", 0);
		placeLatLocation = latitudeSet[mapPlaceId];
		placeLongLocation = longitudeSet[mapPlaceId];
		EventPlace = new LatLng(placeLatLocation, placeLongLocation);
		// Toast.makeText(this, "Pos : "+mapPlaceId, Toast.LENGTH_LONG).show();
		ePlace.setBackgroundResource(placeImage[mapPlaceId]);

		try {
			getCurrent();
		} catch (NullPointerException e) {

		}
		mtoast.setText("" + eventPlace);

		MarkerOptions M1 = new MarkerOptions().position(new LatLng(
				placeLatLocation, placeLongLocation));

		MarkerOptions M2 = new MarkerOptions()
				.position(new LatLng(C_LAT, C_LON));
		M1.title(eventPlace);
		M2.title("Your Current Location");
		// MarkerOptions M1=new MarkerOptions().position(new
		// LatLng(13.012082,80.235593));
		// MarkerOptions M2=new MarkerOptions().position(new
		// LatLng(13.011742,80.235511));
		// MarkerOptions M3=new MarkerOptions().position(new
		// LatLng(13.011749,80.234956));
		// MarkerOptions M4=new MarkerOptions().position(new
		// LatLng(13.011643,80.236056));
		// Toast.makeText(this,"Refer : "+placeLatLocation+" "+placeLongLocation+" "+C_LAT+" "+C_LON,
		// Toast.LENGTH_LONG).show();
		map.addMarker(M1);
		map.addMarker(M2);
		/*
		 * int width1 = getWindowManager().getDefaultDisplay().getWidth(); final
		 * int height1 = getWindowManager().getDefaultDisplay().getHeight();
		 * LinearLayout.LayoutParams = new LinearLayout.LayoutParams(
		 * LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		 */
		final int imageArray3[] = { R.drawable.icon1, R.drawable.icon1,
				R.drawable.icon1, R.drawable.icon1, R.drawable.icon1,
				R.drawable.icon1, R.drawable.icon1, R.drawable.icon1,
				R.drawable.icon1, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon4, R.drawable.icon4,
				R.drawable.icon4, R.drawable.icon4, R.drawable.icon4,
				R.drawable.icon4, R.drawable.icon4, R.drawable.icon4,
				R.drawable.icon4, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon3, R.drawable.icon3,
				R.drawable.icon3, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2, R.drawable.icon2, R.drawable.icon2,
				R.drawable.icon2 };

		// CameraUpdate update=CameraUpdateFactory.newLatLngZoom(CHEPAK,16);
		// map.animateCamera(update);

		// CameraUpdate update1=CameraUpdateFactory.newLatLngZoom(CHEPAK,16);
		// map.animateCamera(update1);
		getSreenDimanstions();

		// map.setMyLocationEnabled(true);
		bNavigation = (ImageButton) findViewById(R.id.bNavigation);
		checkIn = (ImageButton) findViewById(R.id.checkIn);
		myframe1 = (FrameLayout) findViewById(R.id.venueimage1);

		naviagteMe = (LinearLayout) findViewById(R.id.navigateme);
		slideup = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.right);
		slideright = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.left);
		dialog = new Dialog(LocateMe.this, R.style.PauseDialog);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setTitle("Notice ! ! !");
		dialog.getWindow().setBackgroundDrawable(
				new ColorDrawable(android.graphics.Color.TRANSPARENT));

		dialog.setCancelable(true);

		dialog.setContentView(R.layout.dialoguemap);

		okiebtn = (Button) dialog.findViewById(R.id.okie);
		okiebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View View3) {
				dialog.dismiss();
			}
		});
		// showMyDirection(placeLatLocation, placeLongLocation);

		int width = getWindowManager().getDefaultDisplay().getWidth();
		final int height = getWindowManager().getDefaultDisplay().getHeight();
		FrameLayout.LayoutParams mapvenue = new FrameLayout.LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

		mapvenue.leftMargin = (width / 2) - 64;
		mapvenue.topMargin = 60;
		checkIn.setLayoutParams(mapvenue);

		final View someView = findViewById(R.id.mylayout);
		final LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) someView
				.getLayoutParams();
		set = createAnimation();
		set.addListener(new AnimatorListenerAdapter() {

			@SuppressLint("NewApi")
			@Override
			public void onAnimationEnd(Animator animation) {
				// Toast.makeText(getApplicationContext(),"Hai",Toast.LENGTH_LONG).show();
				canrun = true;
			}
		});

		final Handler handler = new Handler();
		Runnable runnable = new Runnable() {
			int i = 0, j = 0;

			@Override
			public void run() {

				handler.postDelayed(this, 0);

				if (canrun) {
					i += 1;
					params.height += i;

					someView.setLayoutParams(params);

					// i > 42
					int refer = (height - params.height) - 100;
					if (i > refer) {

						CameraUpdate update = CameraUpdateFactory
								.newLatLngZoom(UserCurrentLocation, 15f);
						map.animateCamera(update);

						canrun = false;

					}

				}

			}

		};

		handler.postDelayed(runnable, 0);

		myframe1.startAnimation(slideright);

		checkIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				set.start();

			}
		});

		naviagteMe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				set.start();
			}
		});
		bNavigation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				set.start();
				// canrun=true;
				// CameraUpdate
				// update=CameraUpdateFactory.newLatLngZoom(CPDE,50);
				// map.animateCamera(update);
				// TODO Auto-generated method stub
				// View someView12 = findViewById(R.id.mylayout1);
				// RelativeLayout.LayoutParams params11 =
				// (RelativeLayout.LayoutParams)

				// someView12 .getLayoutParams();
				// CameraUpdate
				// update=CameraUpdateFactory.newLatLngZoom(CPDE,50);
				// map.animateCamera(update);
				// params.height = 600;
				// params11.height=600;
				// someView12 .setLayoutParams(params11);

				/*
				 * if (!isTravelingToParis) { isTravelingToParis = true;
				 * findDirections( ANNA.latitude,
				 * ANNA.longitude,CHEPAK.latitude, CHEPAK.longitude,
				 * GMapV2Direction.MODE_DRIVING ); }
				 */

			}
		});

		// autopress.setPressed(true);
		// autopress.invalidate();
		// autopress.performClick();
		/*
		 * CameraPosition cameraPosition1 = new CameraPosition.Builder()
		 * .target(new LatLng(13.0121,80.2356)) .bearing(45) .tilt(90)
		 * .zoom(map.getCameraPosition().zoom) .build(); map.animateCamera(
		 * CameraUpdateFactory.newCameraPosition(cameraPosition1), 100, null );
		 */

		// Refer

		// map.getMyLocation();
		map.setMyLocationEnabled(true);

		// Refer

		// Location location = mLocationClient.getLastLocation();
		// LatLng latLng = new LatLng(location.getLatitude(),
		// location.getLongitude());
		// Toast.makeText(this, (int)
		// (location.getLatitude()+location.getLongitude()),
		// Toast.LENGTH_LONG).show();
		// curlati=location.getLatitude();
		// CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ANNA,
		// 17);
		// map.animateCamera(cameraUpdate);
		// MarkerOptions M1 = new MarkerOptions().position(new LatLng(13.010964,
		// 80.235404));
		// M1.title("Anna University");
		// MarkerOptions M3=new MarkerOptions().position(new
		// LatLng(13.011749,80.234956));
		// MarkerOptions M4=new MarkerOptions().position(new
		// LatLng(13.011643,80.236056));

		// map.addMarker(M1);
		// showMyDirection();
		// map.addMarker(M2);
		// map.addMarker(M3);
		// map.addMarker(M4);

		// map.addMarker(new MarkerOptions().position(new
		// LatLng(13.012082,80.235593)).title("SNH"));
		// map.addMarker(new MarkerOptions().position(new
		// LatLng(13.011742,80.235511)).title("CPDE"));
		// map.addMarker(new MarkerOptions().position(new
		// LatLng(13.011749,80.234956)).title("Swimming Pool"));
		// map.addMarker(new MarkerOptions().position(new
		// LatLng(13.011643,80.236056)).title("Vivek Audi"));

		map.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng arg0) {
				// Toast.makeText(getBaseContext(),"Current Location : "+arg0,
				// Toast.LENGTH_LONG).show();

				if (mapclickcnt == 0) {
					// dialog.show();
					// okiebtn.startAnimation(slideup);
				}

				mapclickcnt++;

			}
		});
		map.setOnMarkerClickListener(this);

	}

	@SuppressLint("NewApi")
	private AnimatorSet createAnimation() {
		// int nextX = randon.nextInt(width);
		// int nextY = randon.nextInt(height);
		// int nextX=275;
		int width = getWindowManager().getDefaultDisplay().getWidth();
		int height = getWindowManager().getDefaultDisplay().getHeight();
		int nextX = (width / 2) - 64;
		int nextY = -200;

		animation1 = ObjectAnimator.ofFloat(checkIn, "x", nextX);
		animation1.setDuration(400);
		animation2 = ObjectAnimator.ofFloat(checkIn, "y", nextY);
		animation2.setDuration(400);

		AnimatorSet set = new AnimatorSet();

		set.playTogether(animation1, animation2);

		return set;

	}

	@Override
	protected void onResume() {

		super.onResume();
		locationmanager.requestLocationUpdates(provider, 400, 1, this);

	}

	public void findDirections(double fromPositionDoubleLat,
			double fromPositionDoubleLong, double toPositionDoubleLat,
			double toPositionDoubleLong, String mode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LAT,
				String.valueOf(fromPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.USER_CURRENT_LONG,
				String.valueOf(fromPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DESTINATION_LAT,
				String.valueOf(toPositionDoubleLat));
		map.put(GetDirectionsAsyncTask.DESTINATION_LONG,
				String.valueOf(toPositionDoubleLong));
		map.put(GetDirectionsAsyncTask.DIRECTIONS_MODE, mode);

		try {
			GetDirectionsAsyncUpdateTask asyncTask = new GetDirectionsAsyncUpdateTask(
					this);
			asyncTask.execute(map);
		} catch (NullPointerException e) {
			Toast.makeText(
					this,
					"Unable To Get Your Location...Check Your Network Connection",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
		try {
			locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			provider = locationmanager.getBestProvider(criteria, true);
			Location mylocation = locationmanager
					.getLastKnownLocation(provider);
			current_latitude = mylocation.getLatitude();
			current_longitude = mylocation.getLongitude();
			LatLng CURRENT_LOCATION = new LatLng(13.0147462, 80.2385241);
			PolylineOptions rectLine = new PolylineOptions().width(5).color(
					Color.DKGRAY);

			for (int i = 0; i < directionPoints.size(); i++) {
				rectLine.add(directionPoints.get(i));
			}
			if (newPolyline != null) {
				newPolyline.remove();
			}
			newPolyline = map.addPolyline(rectLine);
			// if (isTravelingToParis)
			// {
			latlngBounds = createLatLngBoundsObject(EventPlace,
					CURRENT_LOCATION);
			map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds,
					width, height, 150));
			// }
			// else
			// {
			// latlngBounds = createLatLngBoundsObject(ANNA, CURRENT);
			// map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds,
			// width, height, 150));
			// }
		} catch (NullPointerException e) {
			Toast.makeText(
					this,
					"Unable To Get Your Location...Check Your Network Connection",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mapmenu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_map:
			showRoute();
			// dialog.show();
			// showRoute();

			break;
		default:
			;
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void getSreenDimanstions() {
		Display display = getWindowManager().getDefaultDisplay();
		width = display.getWidth();
		height = display.getHeight();
	}

	private LatLngBounds createLatLngBoundsObject(LatLng firstLocation,
			LatLng secondLocation) {
		if (firstLocation != null && secondLocation != null) {
			LatLngBounds.Builder builder = new LatLngBounds.Builder();
			builder.include(firstLocation).include(secondLocation);

			return builder.build();
		}
		return null;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		C_LAT = location.getLatitude();
		C_LON = location.getLongitude();
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	public boolean onMarkerClick(LatLng arg0) {
		// TODO Auto-generated method stub
		// Toast.makeText(getBaseContext(),"hai", Toast.LENGTH_LONG).show();
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(arg0, 17);
		map.animateCamera(cameraUpdate);
		return false;

	}

	@Override
	public void onMapClick(LatLng arg0) {
		// TODO Auto-generated method stub
		// Toast.makeText(getBaseContext(),"Info", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * public boolean onTouchEvent(MotionEvent touchevent) {
	 * Toast.makeText(this,"swipe",Toast.LENGTH_SHORT).show(); switch
	 * (touchevent.getAction()) { // when user first touches the screen we get x
	 * and y coordinate case MotionEvent.ACTION_DOWN: { x1 = touchevent.getX();
	 * y1 = touchevent.getY(); break; } case MotionEvent.ACTION_UP: { x2 =
	 * touchevent.getX(); y2 = touchevent.getY();
	 * 
	 * 
	 * if (x1 < x2) { if(mapclickcnt==0) { dialog.show();
	 * okiebtn.startAnimation(slideup); }
	 * 
	 * mapclickcnt++; }
	 * 
	 * 
	 * if (x1 > x2) { if(mapclickcnt==0) { dialog.show();
	 * okiebtn.startAnimation(slideup); }
	 * 
	 * mapclickcnt++; }
	 * 
	 * 
	 * if (y1 < y2) { if(mapclickcnt==0) { dialog.show();
	 * okiebtn.startAnimation(slideup); }
	 * 
	 * mapclickcnt++; }
	 * 
	 * 
	 * if (y1 > y2) { if(mapclickcnt==0) { dialog.show();
	 * okiebtn.startAnimation(slideup); }
	 * 
	 * mapclickcnt++; } break; } } return false; }
	 */

}
