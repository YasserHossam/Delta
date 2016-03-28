package com.projectx.graduation.projectx;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.projectx.graduation.projectx.API.ProjectXAPI;
import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;
import com.projectx.graduation.projectx.Models.gitmodel;
import java.io.File;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit ret = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build() ;

        ProjectXAPI api = ret.create(ProjectXAPI.class) ;
        retrofit2.Call<gitmodel> call = api.getFeed("basil2style") ;
        call.enqueue(new retrofit2.Callback<gitmodel>() {
            @Override
            public void onResponse(retrofit2.Call<gitmodel> call, retrofit2.Response<gitmodel> response) {
                Log.e("zxc" , response.body().getEmail().toString()) ;
            }

            @Override
            public void onFailure(retrofit2.Call<gitmodel> call, Throwable t) {

            }
        });

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
