package com.example.getgpslocation;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	Button btnSetStart, btnSetEnd, btnDistance;
	ProgressBar barTimer;
	EditText chooseProgress;
	
	GPSTracker gps;

	double startLat, startLng, endLat, endLng;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		btnDistance = (Button) findViewById(R.id.find_distance);
		barTimer = (ProgressBar) findViewById(R.id.progressBar);
		chooseProgress = (EditText) findViewById(R.id.editText);

		gps = new GPSTracker(MainActivity.this);

		btnDistance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				float distanceToAla;
		/*
				//Calculate distance from start location to end location
				distanceToAla = gps.getDistanceTo(startLat, startLng, endLat, endLng);
		*/
				distanceToAla = gps.getDistance();

				Toast.makeText(
						getApplicationContext(),
						"Distance between start and end is: " + distanceToAla + " meters",
						Toast.LENGTH_LONG).show();

				int val;
				if(!chooseProgress.getText().toString().equals("")) {
					val = Integer.valueOf(chooseProgress.getText().toString());
					barTimer.setProgress(val);
				}
			}
		});

		/*btnSetStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (gps.canGetLocation()) {
					gps.getLocation();
					startLat = gps.getLatitude();
					startLng = gps.getLongitude();


					Toast.makeText(
							getApplicationContext(),
							"Your Location is -\nLat: " + startLat + "\nLong: "
									+ startLng, Toast.LENGTH_SHORT).show();
				} else {
					gps.showSettingsAlert();
				}
			}
		});
		btnSetEnd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (gps.canGetLocation()) {
					gps.getLocation();
					endLat = gps.getLatitude();
					endLng = gps.getLongitude();

					Toast.makeText(
							getApplicationContext(),
							"Your Location is -\nLat: " + endLat + "\nLong: "
									+ endLng, Toast.LENGTH_SHORT).show();
				} else {
					gps.showSettingsAlert();
				}
			}
		});*/
    }
}
