package com.projectx.graduation.projectx.API;

import com.projectx.graduation.projectx.Models.gitmodel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Path;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public interface ProjectXAPI {
    @GET("/users/basil2style")
    public Call<gitmodel> getFeed();

}
