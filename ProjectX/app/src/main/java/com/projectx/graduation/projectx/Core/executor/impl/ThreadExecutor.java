package com.projectx.graduation.projectx.Core.executor.impl;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public class ThreadExecutor implements Executor {
    private static volatile ThreadExecutor ourInstance = new ThreadExecutor();

    private static final int CORE_POOL_SIZE  = 3;
    private static final int MAX_POOL_SIZE   = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit                TIME_UNIT       = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE      = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    public static ThreadExecutor getInstance() {
        if(ourInstance == null)
        {
            ourInstance = new ThreadExecutor() ;
        }
        return ourInstance;
    }

    private ThreadExecutor() {
        long keepAlive = KEEP_ALIVE_TIME ;
        mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE , MAX_POOL_SIZE , keepAlive , TimeUnit.SECONDS , new  LinkedBlockingQueue<Runnable>()) ;
    }

    @Override
    public void execute(final AbstractInteractor interactor)
    {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

                interactor.run();

                interactor.onFinished();
            }
        });
    }
}
