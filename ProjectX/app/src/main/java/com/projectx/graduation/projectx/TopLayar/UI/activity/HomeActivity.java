package com.projectx.graduation.projectx.TopLayar.UI.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.projectx.graduation.projectx.Core.Models.Application;
import com.projectx.graduation.projectx.TopLayar.Helper.packageExtractor;
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

    }

}
