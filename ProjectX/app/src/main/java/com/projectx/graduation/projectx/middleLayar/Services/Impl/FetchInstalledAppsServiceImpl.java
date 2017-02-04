package com.projectx.graduation.projectx.middleLayar.Services.Impl;

import android.content.Intent;
import android.os.Bundle;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.TopLayar.Threading.MainThreadImpl;
import com.projectx.graduation.projectx.middleLayar.Presenters.impl.FetchInstalledApplicationsImpl;
import com.projectx.graduation.projectx.middleLayar.Services.Base.AbstractService;

/**
 * Created by abdalrhmantaher on 4/8/16.
 */
public class FetchInstalledAppsServiceImpl extends AbstractService {
    public FetchInstalledAppsServiceImpl()
    {
        super("fetchInstalledAppsThread");
    }
    public FetchInstalledAppsServiceImpl(Executor executor , MainThread mainThread)
    {
            super("fetchInstalledAppsThread" ,executor , mainThread );
    }

    public void onHandleIntent(Intent intent)
    {
      //  this.mMainThread = intent.getSerializableExtra("assa") ;
    }
}
