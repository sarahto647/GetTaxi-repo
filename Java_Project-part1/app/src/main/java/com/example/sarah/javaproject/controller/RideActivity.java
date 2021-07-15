package com.example.sarah.javaproject.controller;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.javaproject.model.backEnd.Backend;
import com.example.sarah.javaproject.model.backEnd.BackendFactory;
import com.example.sarah.javaproject.model.enteties.Trip;
import com.example.sarah.javaproject.R;

import java.util.List;
import java.util.Locale;

public class RideActivity extends AppCompatActivity {

    String currentLocationString;
    Location currentLocation;//will contain the current location of this phone
    LocationManager mLocationManager;
    EditText source; //the edit text of the source location of this activity

    private LocationListener mLocationListener = new LocationListener() {

        /**
         * this function gets the current location of the user and it sets in "currentLocation" field of the RideActivity
         * @param location the current location of the phone, Location type= contains latitude and longitude
         */
        @Override
        public void onLocationChanged(final Location location) {

            try {
                Geocoder geocoder = new Geocoder(RideActivity.this, Locale.getDefault());
                List<Address> addresses  = null;
                addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(), 1);
                if(addresses.size()==0)//error
                {
                    currentLocationString="";
                }
                else{//sets location in "currentLocation" field of the RideActivity and show the location in "toast"
                    String city = addresses.get(0).getLocality();
                    String country = addresses.get(0).getCountryName();
                    String street = addresses.get(0).getThoroughfare();
                    String numberHouse=addresses.get(0).getSubThoroughfare();
                    currentLocationString=street+", "+numberHouse+", "+city+", "+country;
                    source.setText(currentLocationString);
                    Toast.makeText(RideActivity.this, currentLocationString,
                            Toast.LENGTH_LONG).show();//message to user
                    mLocationManager.removeUpdates(mLocationListener);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentLocationString="";
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 5); }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, mLocationListener);


        BackendFactory.getInstance(getApplicationContext());//init the database
        setContentView(R.layout.activity_ride);
        Button buttonOK=(Button)findViewById(R.id.button2);
        buttonOK.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        //uploading the trip details from the UI
        SharedPreferences prefs = getSharedPreferences("GeTaxiTemp",MODE_PRIVATE);

        final EditText name =(EditText)findViewById(R.id.nameText);
        final EditText phone =(EditText)findViewById(R.id.PhoneText);
        final EditText email =(EditText)findViewById(R.id.EMailText);
       // final EditText begin =(EditText)findViewById(R.id.beginTripText);
        source =(EditText)findViewById(R.id.beginTripText);

        final EditText end = (EditText)findViewById(R.id.endTripText);
        name.setText(prefs.getString( "nameVal",""));
        phone.setText(prefs.getString( "phoneVal",""));
        email.setText(prefs.getString( "emailVal",""));
      //  begin.setText(prefs.getString( "sourceVal",""));
        end.setText(prefs.getString( "destVal",""));
        source.setText(currentLocationString);

        buttonOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                   if(check(phone, email)) {
                       BackendFactory.mode = "fb";
                       final Trip trip = new Trip(source.getText().toString(), end.getText().toString(), name.getText().toString(), phone.getText().toString(), email.getText().toString());
                       final Backend instance = BackendFactory.getInstance(getApplicationContext());//get the instance of Backend
                       new AsyncTask<Context, Void, Void>() {//open "thread" to add data to database
                           /**
                            * this function start the thread action
                            *
                            * @param contexts the context of the activity
                            * @return void
                            */
                           @Override
                           protected Void doInBackground(Context... contexts) {
                               try {
                                   instance.addTrip(trip);//add to database
                                   return null;
                               } catch (Exception e) {
                                   System.out.println(e.getMessage());
                                   return null;
                               }
                           }

                       }.execute();//run thread
                       name.setText("");//clean input EditText
                       phone.setText("");//clean input EditText
                       email.setText("");//clean input EditText
                       source.setText("");//clean input EditText
                       end.setText("");//clean input EditText
                       Toast.makeText(RideActivity.this, "Your Ride was added successfully",
                               Toast.LENGTH_LONG).show();//message to user
                   }
                }
                catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }
            }
        });
    }
    public boolean check(EditText phone ,EditText email)
    {
        boolean flag= true;
        if (!isValidEmail(email.getText().toString())) {
            email.setError("Your Email is invalid!");
            Toast.makeText(RideActivity.this, "Your Email is invalid!",
                    Toast.LENGTH_LONG).show();
            flag= false;
        }
        if (!isValidMobile(phone.getText().toString())) {
            phone.setError("your phone number is invalid!");
            Toast.makeText(RideActivity.this, "Your Phone Number is invalid!",
                    Toast.LENGTH_LONG).show();
            flag= false;
        }
        return flag;
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean isValidMobile(String target) {
        if (target == null || target.length() < 6 || target.length() > 13) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }    }

    /**
     * This func remembers what the info the user putts in the field for the next use
     * if he didnt press on ok.
     */
    public void onStop()
    {   super.onStop();
        final EditText name =(EditText)findViewById(R.id.nameText);
        final EditText phone =(EditText)findViewById(R.id.PhoneText);
        final EditText email =(EditText)findViewById(R.id.EMailText);
        final EditText source =(EditText)findViewById(R.id.beginTripText);
        final EditText dest = (EditText)findViewById(R.id.endTripText);
        SharedPreferences prefs = getSharedPreferences("GeTaxiTemp",MODE_PRIVATE);//the file
        SharedPreferences.Editor editor = prefs.edit();//edit the file
        editor.putString("nameVal",name.getText().toString());//put the name in file
        editor.putString("phoneVal",phone.getText().toString());//put the phone in file
        editor.putString("emailVal",email.getText().toString());//put the email in file
        //editor.putString("sourceVal",source.getText().toString());//put the source in file
        editor.putString("destVal",dest.getText().toString());//put the dest in file
        editor.apply();//save the edits
    }
}
