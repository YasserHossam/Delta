package com.projectx.graduation.projectx.Core.interactors.impl;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.SignupUserInteractor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;
import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public class SignupUserInteractorImpl extends AbstractInteractor implements SignupUserInteractor {

    private SignupUserInteractor.Callback mCallback ;

    private User user ;
    private Device device ;

    public SignupUserInteractorImpl(Executor mThreadExecutor , MainThread mMainThread , Callback callback ,
                                    String phoneNumber , String userName , String userEmail ,
                                    String deviceID , String androidVersion , String appID , String deviceType)
    {
        super(mThreadExecutor , mMainThread);
        mCallback = callback ;

        device = new Device(deviceID , appID , deviceType , androidVersion) ;
        user = new User(userName , userEmail , phoneNumber) ;



    }
    @Override
    public void execute()
    {
        run();
    }

    @Override
    public void run()
    {

    }
}
