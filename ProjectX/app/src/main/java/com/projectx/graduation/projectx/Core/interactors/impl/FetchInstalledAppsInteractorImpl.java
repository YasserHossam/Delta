package com.projectx.graduation.projectx.Core.interactors.impl;

import com.projectx.graduation.projectx.Core.Models.Application;
import com.projectx.graduation.projectx.Core.Network.Iresponse;
import com.projectx.graduation.projectx.Core.Network.PushInstalledApplications;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.FetshInstalledAppsInteractor;
import com.projectx.graduation.projectx.Core.interactors.SignupUserInteractor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by abdalrhmantaher on 4/4/16.
 */
public class FetchInstalledAppsInteractorImpl extends AbstractInteractor implements FetshInstalledAppsInteractor , Iresponse {

    private FetshInstalledAppsInteractor.Callback mCallback ;

    private ArrayList<Application> applications ;

    private PushInstalledApplications mPushInsatlledApps ;

    public FetchInstalledAppsInteractorImpl(Executor mThreadExecutor , MainThread mMainThread ,
                                            Callback callback , ArrayList<Application> applications ,
                                            PushInstalledApplications pushInstalledApplications)
    {
        super(mThreadExecutor , mMainThread);
        this.mCallback = callback ;
        this.applications = applications ;
        this.mPushInsatlledApps = pushInstalledApplications ;


    }
    public void onSuccess(final Object object)
    {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuccess(object);
            }
        });

    }

    public void onFaliure(final String message)
    {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFaliure(message);
            }
        });
    }

    @Override
    public void run()
    {
        HashMap<String,Object> JSON = new HashMap<String, Object>() ;

        JSON.put("apps" , applications) ;
        
    }
}


