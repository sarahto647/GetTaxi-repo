package com.example.yiska.project_part2.controller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yiska.project_part2.R;

public class GetTaxiActivity extends AppCompatActivity {

    private static int TIME_OUT = 3000; //Time to launch the another activity
    //LinearLayout linearLayout=(FrameLayout)findViewById(R.id.line);
    @Override
    protected void onCreate(Bundle savedInstanceState) {//when the activity open
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gettaxi);
        final View myLayout = findViewById(R.id.all);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {//make the activity change to another activity after TIME_OUT Time
                Intent i = new Intent(GetTaxiActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
