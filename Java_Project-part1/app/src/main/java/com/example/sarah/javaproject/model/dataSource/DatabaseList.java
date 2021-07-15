package com.example.sarah.javaproject.model.dataSource;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.ArrayList;

import com.example.sarah.javaproject.R;
import com.example.sarah.javaproject.model.enteties.Trip;
import com.example.sarah.javaproject.model.backEnd.Backend;

public class DatabaseList implements Backend
{
    static public int TripCounter=0;
    ArrayList<Trip> trips = new ArrayList<Trip>();
    @Override
    public void addTrip(Trip trip) throws Exception {
        if (!isValidEmail(trip.getCostumerEmail()))
            throw new Exception("your Email is invalid!");
        if (!isValidMobile(trip.getCostumerTel()))
            throw new Exception("your phone number is invalid!");
      //  trip.setId(TripCounter++);
        for (Trip t: trips) {
            if (trip.equals(t))
                throw new Exception("this trip is already exists!");
        }
        trips.add(trip);
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }


    public void setList() {
        try {
           // this.addTrip(new Trip("MOTION","jerusalem","//",...));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
