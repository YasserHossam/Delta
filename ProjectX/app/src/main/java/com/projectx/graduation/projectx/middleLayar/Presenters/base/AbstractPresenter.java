package com.projectx.graduation.projectx.middleLayar.Presenters.base;

import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public abstract class AbstractPresenter {

    protected Executor mExecutor ;

    protected MainThread mMainThread ;

    public  AbstractPresenter(Executor executor , MainThread mainThread )
    {
        this.mExecutor = executor ;
        this.mMainThread = mainThread ;

    }
}
