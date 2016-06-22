package com.projectx.graduation.projectx.TopLayar.API;

import android.util.Log;

import com.projectx.graduation.projectx.Core.Network.Iresponse;
import com.projectx.graduation.projectx.Core.Network.PushInstalledApplicationsNetworkInterface;
import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.Models.Device;
import com.projectx.graduation.projectx.Core.Models.User;
import com.projectx.graduation.projectx.Core.Models.gitmodel;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abdalrhmantaher on 3/28/16.
 */
public class API implements SignUpUser,PushInstalledApplicationsNetworkInterface
{
    private static API ourInstance = new API();

    public static API getInstance()
    {
        return ourInstance;
    }

    private ProjectXAPI projectXAPI;

    private Retrofit retrofit;

    private API()
    {

        // "https://api.github.com/"
        retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/").addConverterFactory(GsonConverterFactory.create()).build();

        projectXAPI = retrofit.create(ProjectXAPI.class);

    }

    public void userSignUp2(HashMap<String, Object> map, Iresponse response)
    {


        retrofit2.Call<ResponseBody> call = projectXAPI.register(map);

        final Iresponse _callback = response;

        call.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
            {
            /*add callbacks*/
                if (response.isSuccessful())
                {

                } else
                {
                    try
                    {
                        _callback.onFaliure(response.errorBody().string());
                    } catch (IOException e)
                    {

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t)
            {
            /*add callbacks*/
            }
        });
    }

    public void userSignUp(User user, Device device, Iresponse callback)
    {
        retrofit2.Call<gitmodel> call = projectXAPI.getFeed("basil2style");

        final Iresponse _callback = callback;
        call.enqueue(new retrofit2.Callback<gitmodel>()
        {

            @Override
            public void onResponse(retrofit2.Call<gitmodel> call, retrofit2.Response<gitmodel> response)
            {
                if (response.isSuccessful())
                    _callback.onSuccess(response.body());
                else
                {
                    try
                    {
                        _callback.onFaliure(response.errorBody().string());
                    } catch (IOException e)
                    {

                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<gitmodel> call, Throwable t)
            {
                _callback.onFaliure(t.getMessage());
            }
        });


    }

    @Override
    public void pushInstalledApps(HashMap<String, Object> applications, Iresponse response)
    {
        retrofit2.Call<ResponseBody> call = projectXAPI.pushInstalledApps(applications);

        final Iresponse _callback = response;

        call.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
            {
            /*add callbacks*/
                if (response.isSuccessful())
                {
                    _callback.onSuccess(response.body());
                } else
                {
                    try
                    {
                        _callback.onFaliure(response.errorBody().string());
                    } catch (IOException e)
                    {
                        _callback.onFaliure("Can't Send Error Body");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t)
            {
            /*add callbacks*/
                _callback.onFaliure("Request couldn't be sent");
            }
        });
    }
}
