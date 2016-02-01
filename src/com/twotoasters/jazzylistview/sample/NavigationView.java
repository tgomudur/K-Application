package com.twotoasters.jazzylistview.sample;

import android.os.Bundle;
import in.org.kurukshetra.app.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.graphics.Color;

import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NavigationView extends FragmentActivity implements
		LocationListener {

	private static final LatLng AMSTERDAM = new LatLng(52.37518, 4.895439);
	private static final LatLng PARIS = new LatLng(48.856132, 2.352448);
	private static final LatLng FRANKFURT = new LatLng(50.111772, 8.682632);
	private static final LatLng ANNA = new LatLng(13.0121, 80.2356);
	private static final LatLng CHEPAK = new LatLng(13.0628, 80.2794);
	private static final LatLng SNH = new LatLng(13.012082, 80.235593);
	private GoogleMap map;
	private SupportMapFragment fragment;
	private LatLngBounds latlngBounds;
	private Button bNavigation, satellite, hybrid, terrain, autopress;
	private Polyline newPolyline;
	private boolean isTravelingToParis = false;
	private int width, height;
	double current_latitude, current_longitude;

	public void updatecamera() {
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CHEPAK, 100);
		map.moveCamera(update);
		map.animateCamera(update);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.navigation);

		getSreenDimanstions();
		fragment = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map));
		map = fragment.getMap();
		updatecamera();
		LocationManager locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = locationmanager.getBestProvider(criteria, true);
		Location mylocation = locationmanager.getLastKnownLocation(provider);
		current_latitude = mylocation.getLatitude();
		current_longitude = mylocation.getLongitude();

		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CHEPAK, 100);
		map.moveCamera(update);
		map.animateCamera(update);

		map.setMyLocationEnabled(true);

		bNavigation = (Button) findViewById(R.id.bNavigation);
		satellite = (Button) findViewById(R.id.SAT);
		hybrid = (Button) findViewById(R.id.HYB);
		terrain = (Button) findViewById(R.id.TER);
		autopress = (Button) findViewById(R.id.autopress);
		autopress.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		autopress.setClickable(true);
		autopress.invalidate();
		autopress.performClick();

		// Refer

		/*
		 * CameraPosition cameraPosition1 = new CameraPosition.Builder()
		 * .target(new LatLng(13.0121,80.2356)) .bearing(45) .tilt(90)
		 * .zoom(map.getCameraPosition().zoom) .build(); map.animateCamera(
		 * CameraUpdateFactory.newCameraPosition(cameraPosition1), 100, null );
		 * 
		 * //map.getMyLocation(); map.setMyLocationEnabled(true); //Refer
		 */
		// Location location = mLocationClient.getLastLocation();
		// LatLng latLng = new LatLng(location.getLatitude(),
		// location.getLongitude());
		// Toast.makeText(this, (int)
		// (location.getLatitude()+location.getLongitude()),
		// Toast.LENGTH_LONG).show();
		// curlati=location.getLatitude();

		map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title(
				"Hello world"));
		satellite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			}
		});
		hybrid.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			}
		});
		terrain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

			}
		});
		bNavigation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				LatLng CURRENT_POSITION = new LatLng(current_latitude,
						current_longitude);
				if (!isTravelingToParis) {
					isTravelingToParis = true;
					findDirections(CURRENT_POSITION.latitude,
							CURRENT_POSITION.longitude, CHEPAK.latitude,
							CHEPAK.longitude, GMapV2Direction.MODE_DRIVING);
				} else {
					isTravelingToParis = false;
					findDirections(CURRENT_POSITION.latitude,
							CURRENT_POSITION.longitude, SNH.latitude,
							SNH.longitude, GMapV2Direction.MODE_DRIVING);
				}
			}
		});
	}

	@Override
	protected void onResume() {

		super.onResume();
		latlngBounds = createLatLngBoundsObject(ANNA, CHEPAK);
		map.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width,
				height, 150));

	}

	public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
		PolylineOptions rectLine = new PolylineOptions().width(5).color(
				Color.DKGRAY);

		for (int i = 0; i < directionPoints.size(); i++) {
			rectLine.add(directionPoints.get(i));
		}
		if (newPolyline != null) {
			newPolyline.remove();
		}
		newPolyline = map.addPolyline(rectLine);

		LatLng CURRENT_POSITION = new LatLng(current_latitude,
				current_longitude);

		if (isTravelingToParis) {
			latlngBounds = createLatLngBoundsObject(CURRENT_POSITION, ANNA);
			map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds,
					width, height, 150));
		} else {
			latlngBounds = createLatLngBoundsObject(CURRENT_POSITION, SNH);
			map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds,
					width, height, 150));
		}

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

		GetDirectionsAsyncTask asyncTask = new GetDirectionsAsyncTask(this);
		asyncTask.execute(map);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

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
	public void onStatusChanged(String provider, int  status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
