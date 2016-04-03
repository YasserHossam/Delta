package com.projectx.graduation.projectx.UI.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.projectx.graduation.projectx.Core.Models.Application;
import com.projectx.graduation.projectx.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getPackageManager() ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        packageExtractor PE = new packageExtractor(getBaseContext()) ;
        ArrayList<Application> apps = PE.getInstalledApps() ;
        Log.e("Error" , "yooo") ;
    }

}
