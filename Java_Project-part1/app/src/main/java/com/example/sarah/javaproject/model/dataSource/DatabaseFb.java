package com.example.sarah.javaproject.model.dataSource;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.sarah.javaproject.model.backEnd.Backend;
import com.example.sarah.javaproject.model.enteties.Trip;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class DatabaseFb implements Backend{//this class implement Backend. save the data in FireBase.
    static public int TripCounter=0;
    FirebaseDatabase database=FirebaseDatabase.getInstance();//the instance of the firebase
    DatabaseReference myRef=database.getReference("Trips");//the root
    /**
     * this function add a ride to the FireBase DataBase
     * @return void
     * @param trip the ride to save
     */
    @Override
    public void addTrip(Trip trip) throws Exception {
        if (!isValidEmail(trip.getCostumerEmail()))
            throw new Exception("your Email is invalid!");
        if (!isValidMobile(trip.getCostumerTel()))
            throw new Exception("your phone number is invalid!");
//        trip.setId(TripCounter++);
//        String key= Long.toString((TripCounter));
       myRef.push().setValue(trip);
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}