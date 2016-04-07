package com.projectx.graduation.projectx.middleLayar.Presenters.impl;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.middleLayar.Presenters.base.AbstractPresenter;

/**
 * Created by abdalrhmantaher on 4/7/16.
 */
public class FetchInstalledApplicationsImpl extends AbstractPresenter {

    public FetchInstalledApplicationsImpl(Executor executor , MainThread mainThread)
    {
        super(executor , mainThread );
    }
}
