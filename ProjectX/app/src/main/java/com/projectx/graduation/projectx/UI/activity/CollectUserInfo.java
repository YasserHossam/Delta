package com.projectx.graduation.projectx.UI.activity;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.projectx.graduation.projectx.API.API;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.executor.impl.ThreadExecutor;
import com.projectx.graduation.projectx.Core.Models.Device;
import com.projectx.graduation.projectx.Core.Models.User;
import com.projectx.graduation.projectx.Core.Models.gitmodel;
import com.projectx.graduation.projectx.Presenters.CollectinfoPresenter;
import com.projectx.graduation.projectx.Presenters.impl.CollectinfoPresenterImpl;
import com.projectx.graduation.projectx.R;
import com.projectx.graduation.projectx.Threading.MainThreadImpl;

public class CollectUserInfo extends AppCompatActivity implements  CollectinfoPresenter.View {
EditText userName , Email ;
    private  CollectinfoPresenter mPresenter ;
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

    @Override
    protected void onResume()
    {
        super.onResume();
      //  mPresenter.resume();

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

           // api.userSignUp(user , device , this);

            MainThread mm = MainThreadImpl.getInstance() ;

            ThreadExecutor ee ;
            try {
                 ee = ThreadExecutor.getInstance() ;

            }
            catch (Exception e)
            {
                Log.e("E" , "error") ;

            }
            API api = API.getInstance() ;


            mPresenter = new CollectinfoPresenterImpl(ThreadExecutor.getInstance() , MainThreadImpl.getInstance(),
                    this , api , user_name , user_email , phone_Number , device_ID ,
                    device_type , "" , android_version) ;

            mPresenter.resume();


        }

    }


    @Override
    public void showProgress()
    {

    }

    @Override
    public void hideProgress()
    {

    }

    @Override
    public void showError(String message)
    {
        Log.e("ERROR" , message) ;
    }

    @Override
    public void onFinish(Object object)
    {
        gitmodel asd = (gitmodel) object ;
        Log.e("E" , asd.getName().toString());
        Log.e("E", asd.getEmail().toString());



    }

}
