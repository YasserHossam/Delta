package com.projectx.graduation.projectx.middleLayar.Services.Base;

import android.app.IntentService;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;

/**
 * Created by abdalrhmantaher on 4/7/16.
 */
public abstract class  AbstractService extends IntentService {
    public Executor mThreadExeutor ;
    public MainThread mMainThread ;
    public AbstractService(String threadName)
    {
        super(threadName);
    }
    public AbstractService(String threadName , Executor executor , MainThread mainThread)
    {
        super(threadName);
        this.mThreadExeutor = executor ;
        this.mMainThread = mainThread ;
    }

}
