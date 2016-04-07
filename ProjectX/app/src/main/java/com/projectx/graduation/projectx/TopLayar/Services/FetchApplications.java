package com.projectx.graduation.projectx.TopLayar.Services;

import android.app.IntentService;
import android.content.Intent;

import com.projectx.graduation.projectx.Core.interactors.FetshInstalledAppsInteractor;
import com.projectx.graduation.projectx.middleLayar.Presenters.FetchInstalledApplications;

/**
 * Created by abdalrhmantaher on 4/7/16.
 */
public class FetchApplications extends IntentService implements FetchInstalledApplications.View , FetshInstalledAppsInteractor.Callback {
    public FetchApplications()
    {
        super("FetchThread");
    }
    @Override
    public void onHandleIntent(Intent intent)
    {
        /*Service core function */
    }
    public void showError(String message)
    {

    }
    public void hideProgress()
    {

    }
    public void showProgress()
    {

    }
    public void onFinish()
    {

    }
    @Override
    public void onSuccess(Object object)
    {
        /*interactor callback*/
    }
    @Override
    public void onFaliure(String message)
    {
     /*interactor callback*/
    }

}
