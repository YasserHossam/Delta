package com.projectx.graduation.projectx;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.projectx.graduation.projectx.API.API;
import com.projectx.graduation.projectx.API.Iresponse;
import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;
import com.projectx.graduation.projectx.Models.gitmodel;

public class CollectUserInfo extends AppCompatActivity implements Iresponse {
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
        String user_name , user_email , phone_Number , device_ID  , android_version , device_model , manfu , device_type  ;

        user_name = userName.getText().toString() ;

        user_email = Email.getText().toString() ;

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            phone_Number = bundle.getString("phoneNumber");


            User user = new User(user_name, user_email, phone_Number);



            device_ID = Settings.Secure.getString(getBaseContext().getContentResolver() , Settings.Secure.ANDROID_ID);

            android_version = Build.VERSION.RELEASE ;

            device_model = Build.MODEL ;

            manfu = Build.MANUFACTURER ;

            device_type = manfu +" "+ device_model ;

            Device device = new Device(device_ID , "appID" , device_type , android_version);

            API api = API.getInstance() ;

            api.userSignUp(user , device , this);


        }

    }
    /*
        * iresponse methods .
     */
    @Override
    public void onSuccess(Object object)
    {
        gitmodel mod = (gitmodel)object ;
        Log.e("E" , mod.getName()) ;
        Log.e("E" , mod.getEmail()) ;

    }
    @Override
    public void onFaliure(String message)
    {
        Log.e("Error" , message) ;
    }

}
