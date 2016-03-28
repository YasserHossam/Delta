package com.projectx.graduation.projectx.API;

import android.util.Log;

import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;
import com.projectx.graduation.projectx.Models.gitmodel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abdalrhmantaher on 3/28/16.
 */
public class API {
    private static API ourInstance = new API();

    public static API getInstance() {
        return ourInstance;
    }
    private ProjectXAPI api ;
    private Retrofit ret ;
    private API()
    {

        ret = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build() ;

        api = ret.create(api.getClass()) ;

    }

    public void userSignUp(User user , Device device)
    {
        retrofit2.Call<gitmodel> call = api.getFeed("basil2style") ;
        call.enqueue(new retrofit2.Callback<gitmodel>() {
            @Override
            public void onResponse(retrofit2.Call<gitmodel> call, retrofit2.Response<gitmodel> response) {
                Log.e("zxc", response.body().getEmail().toString()) ;
            }

            @Override
            public void onFailure(retrofit2.Call<gitmodel> call, Throwable t) {

            }
        });


    }

}
