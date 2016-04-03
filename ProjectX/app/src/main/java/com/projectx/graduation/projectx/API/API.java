package com.projectx.graduation.projectx.API;

import com.projectx.graduation.projectx.Core.Network.Iresponse;
import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.Models.Device;
import com.projectx.graduation.projectx.Core.Models.User;
import com.projectx.graduation.projectx.Core.Models.gitmodel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abdalrhmantaher on 3/28/16.
 */
public class API implements SignUpUser {
    private static API ourInstance = new API();

    public static API getInstance()
    {
        return ourInstance;
    }

    private ProjectXAPI projectXAPI ;

    private Retrofit retrofit ;

    private API()
    {

        retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build() ;

        projectXAPI = retrofit.create(ProjectXAPI.class) ;

    }


    public void userSignUp(User user , Device device , Iresponse callback )
    {
        retrofit2.Call<gitmodel> call = projectXAPI.getFeed("basil2style") ;

        final Iresponse _callback = callback ;
        call.enqueue(new retrofit2.Callback<gitmodel>()
        {

            @Override
            public void onResponse(retrofit2.Call<gitmodel> call, retrofit2.Response<gitmodel> response)
            {
                _callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<gitmodel> call, Throwable t)
            {
                _callback.onFaliure(t.getMessage());
            }
        });


    }

}
