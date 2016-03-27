package com.projectx.graduation.projectx;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;
import java.io.File;

public class CollectUserInfo extends AppCompatActivity {
EditText userName , Email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_user_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = (EditText)findViewById(R.id.UserName) ;
        Email = (EditText)findViewById(R.id.UserEmail) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onSignUpPressed(View view)
    {
        String user_name , user_email , device_ID  ;
        user_name = userName.getText().toString() ;
        user_email = Email.getText().toString() ;

        User user = new User() ;
        user.userName = user_name ;
        user.userEmail = user_email ;

        Device device = new Device() ;
        device_ID = Settings.Secure.ANDROID_ID ;





    }

}
