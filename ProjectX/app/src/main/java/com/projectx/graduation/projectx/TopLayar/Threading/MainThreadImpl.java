package com.projectx.graduation.projectx.TopLayar.Threading;


import android.os.Looper;

import com.projectx.graduation.projectx.Core.executor.MainThread;

import android.os.Handler;

import java.io.Serializable;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public class MainThreadImpl implements MainThread  {

    private static MainThreadImpl ourInstance = new MainThreadImpl();

    private Handler mHandler ;

    public static MainThreadImpl getInstance() {
        if(ourInstance == null)
        {
            ourInstance = new MainThreadImpl() ;
        }


        return ourInstance;
    }

    @Override
    public void post(Runnable runnable)
    {
        mHandler.post(runnable) ;
    }

    private MainThreadImpl() {

        mHandler = new Handler(Looper.getMainLooper());
    }
}
