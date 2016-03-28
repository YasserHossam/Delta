package com.projectx.graduation.projectx.API;

import com.projectx.graduation.projectx.Models.gitmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public interface ProjectXAPI {
    @GET("users/{user}")
    public Call<gitmodel> getFeed(@retrofit2.http.Path("user") String user);

}
