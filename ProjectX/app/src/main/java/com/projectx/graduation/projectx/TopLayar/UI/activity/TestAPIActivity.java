package com.projectx.graduation.projectx.TopLayar.UI.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectx.graduation.projectx.R;
import com.projectx.graduation.projectx.TopLayar.API.API;

import java.util.HashMap;

public class TestAPIActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);
        ((Button)findViewById(R.id.test_api_button)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                API api=API.getInstance();
                //Change Those Lines when testing our Project
                HashMap<String,Object> body=fillData();
                api.testRetrofit(body);
            }
        });
    }
    private HashMap<String,Object> fillData()
    {
        HashMap<String,Object> body=new HashMap<>();
        body.put("user_name","kokokeke");
        body.put("password","kokoelda3ef");
        return body;
    }
}
