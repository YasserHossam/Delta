package com.projectx.graduation.projectx.TopLayar.API;

import com.projectx.graduation.projectx.Core.Models.gitmodel;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public interface ProjectXAPI {
    @GET("users/{user}")
    public Call<gitmodel> getFeed(@retrofit2.http.Path("user") String user);

    @POST("api/usersdevices/")
    public Call<ResponseBody> register(@Body HashMap<String , Object>body) ;

    @POST("api/installedApps/")
    public Call<ResponseBody> pushInstalledApps(@Body HashMap<String, Object> body);

    @POST("api/delete-apps/")
    public Call<ResponseBody> removeDeletedApps(@Body HashMap<String,Object> body);

    @POST("api/usersdevices/")
    public Call<ResponseBody> registerDevice(@Body HashMap<String , Object>body);
}
