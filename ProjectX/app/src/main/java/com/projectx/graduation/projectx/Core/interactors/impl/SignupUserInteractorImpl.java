package com.projectx.graduation.projectx.Core.interactors.impl;

import android.net.Network;

import com.projectx.graduation.projectx.API.Iresponse;
import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.SignupUserInteractor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;
import com.projectx.graduation.projectx.Models.Device;
import com.projectx.graduation.projectx.Models.User;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public class SignupUserInteractorImpl extends AbstractInteractor implements SignupUserInteractor , Iresponse  {

    private SignupUserInteractor.Callback mCallback ;
    private SignUpUser msignUpUser ;
    private User user ;
    private Device device ;


    public SignupUserInteractorImpl(Executor mThreadExecutor , MainThread mMainThread , Callback callback ,
                                    String phoneNumber , String userName , String userEmail ,
                                    String deviceID , String androidVersion , String appID , String deviceType , SignUpUser signUpUser)
    {
        super(mThreadExecutor , mMainThread);
        mCallback = callback ;
        msignUpUser = signUpUser ;

        device = new Device(deviceID , appID , deviceType , androidVersion) ;
        user = new User(userName , userEmail , phoneNumber) ;



    }

    public void onSuccess(final Object object)
    {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSignUpFinished(object);
            }
        });

    }

    public void onFaliure(String message)
    {


    }

    @Override
    public void execute()
    {
        run();
    }

    @Override
    public void run()
    {
        msignUpUser.userSignUp(user , device , this);

    }
}
