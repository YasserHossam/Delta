package com.projectx.graduation.projectx.Core.interactors.base;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor ;
    protected MainThread mMainThread ;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor executor , MainThread mainThread)
    {
        this.mThreadExecutor = executor ;
        this.mMainThread = mainThread ;
    }
    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public abstract void run() ;

    public void execute()
    {
        this.mIsRunning = true ;

        mThreadExecutor.execute(this);

    }
}
