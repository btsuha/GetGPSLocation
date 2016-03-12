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
        
        btnSetStart = (Button) findViewById(R.id.set_start);
		btnSetEnd = (Button) findViewById(R.id.set_end);
		btnDistance = (Button) findViewById(R.id.find_distance);
		barTimer = (ProgressBar) findViewById(R.id.progressBar);
		chooseProgress = (EditText) findViewById(R.id.editText);

		btnSetStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				gps = new GPSTracker(MainActivity.this);

				if (gps.canGetLocation()) {
					startLat = gps.getLatitude();
					startLng = gps.getLongitude();


					Toast.makeText(
							getApplicationContext(),
							"Your Location is -\nLat: " + startLat + "\nLong: "
									+ startLng, Toast.LENGTH_LONG).show();
				} else {
					gps.showSettingsAlert();
				}
			}
		});
		btnSetEnd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				gps = new GPSTracker(MainActivity.this);

				if (gps.canGetLocation()) {
					endLat = gps.getLatitude();
					endLng = gps.getLongitude();

					Toast.makeText(
							getApplicationContext(),
							"Your Location is -\nLat: " + endLat + "\nLong: "
									+ endLng, Toast.LENGTH_LONG).show();
				} else {
					gps.showSettingsAlert();
				}
			}
		});
		btnDistance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int val = Integer.valueOf(chooseProgress.getText().toString());
				barTimer.setProgress(val);

				gps = new GPSTracker(MainActivity.this);
				double distanceToAla;

				//Calculate distance from start location to end location
				distanceToAla = gps.getDistanceTo(startLat, startLng, endLat, endLng);

				Toast.makeText(
						getApplicationContext(),
						"Distance between start and end is: " + distanceToAla + " meters",
							Toast.LENGTH_LONG).show();

			}
		});
    }
}
