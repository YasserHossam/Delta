package com.projectx.graduation.projectx.Presenters.impl;

import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.SignupUserInteractor;
import com.projectx.graduation.projectx.Core.interactors.impl.SignupUserInteractorImpl;
import com.projectx.graduation.projectx.Presenters.CollectinfoPresenter;
import com.projectx.graduation.projectx.Presenters.base.AbstractPresenter;
import com.projectx.graduation.projectx.UI.activity.CollectUserInfo;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public class CollectinfoPresenterImpl extends AbstractPresenter implements CollectinfoPresenter , SignupUserInteractor.Callback {

    private CollectinfoPresenter.View mView ;

    private SignUpUser mSignUpUser ;

    private String mUserName , mUserEmail , mPhoneNumber , mDeviceID , mDeviceType , mAppID , mAndroidVersion ;

    public CollectinfoPresenterImpl(Executor executor , MainThread mainThread , View view ,
                                    SignUpUser signUpUser , String userName , String userEmail,
                                    String phoneNumber , String deviceID , String deviceType,
                                    String appID , String androidVersion)
    {
        super(executor , mainThread );
        mView = view ;
        mSignUpUser = signUpUser ;
        mUserName = userName ;
        mUserEmail = userEmail ;
        mPhoneNumber = phoneNumber ;
        mDeviceID = deviceID ;
        mDeviceType = deviceType ;
        mAppID = appID ;
        mAndroidVersion = androidVersion ;


    }

    @Override
    public void resume()
    {
        mView.showProgress();

        SignupUserInteractor interactor = new SignupUserInteractorImpl(mExecutor ,mMainThread,
                this , mPhoneNumber ,mUserName ,mUserEmail ,mDeviceID , mAndroidVersion , mAppID , mDeviceType ,mSignUpUser);

        interactor.execute();
    }
    @Override
    public void pause()
    {

    }

    @Override
    public void stop()
    {

    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void onError(String message)
    {
        mView.showError(message);
    }

    @Override
    public void onSignUpSuccess(Object object)
    {
        mView.onFinish(object);
    }

    @Override
    public void onSignUpFaliure(String message)
    {
        onError(message);
    }

}
