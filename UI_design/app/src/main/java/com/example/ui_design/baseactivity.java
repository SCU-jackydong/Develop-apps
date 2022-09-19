package com.example.ui_design;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class baseactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        activity_collect.addActivity(this);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
     activity_collect.removeActivity(this);
    }
}
