package com.example.sarah.javaproject.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.sarah.javaproject.R;

public class MainActivity extends AppCompatActivity
{
    private static int TIME_OUT = 3000; //Time to launch the another activity
    //LinearLayout linearLayout=(FrameLayout)findViewById(R.id.line);
    @Override
    protected void onCreate(Bundle savedInstanceState) {//when the activity open
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View myLayout = findViewById(R.id.all);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {//make the activity change to another activity after TIME_OUT Time
                Intent i = new Intent(MainActivity.this, RideActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }

}
