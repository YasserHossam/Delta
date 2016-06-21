package com.projectx.graduation.projectx.Core.interactors.impl;

import com.projectx.graduation.projectx.Core.Network.Iresponse;
import com.projectx.graduation.projectx.Core.Network.SignUpUser;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.SignupUserInteractor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;
import com.projectx.graduation.projectx.Core.Models.Device;
import com.projectx.graduation.projectx.Core.Models.User;

import java.util.HashMap;
import java.util.Objects;

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
                mCallback.onSignUpSuccess(object);
            }
        });

    }

    public void onFaliure(final String message)
    {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSignUpFaliure(message);
            }
        });
    }

    @Override
    public void run()
    {

        HashMap<String,Object> map = buildJSONObject() ;
        msignUpUser.userSignUp2(map, this);

    }

    private HashMap<String , Object> buildJSONObject()
    {
        //   msignUpUser.userSignUp(user, device, this);
        HashMap<String , Object> map = new HashMap<String, Object>() ;
        map.put("DeviceType" , device.getDeviceType()) ;
        map.put("AndroidVersion" , device.getAndroidVersion()) ;
        map.put("registeration_id"  , device.getDeviceID()) ;
        HashMap<String,Object> userProfile = new HashMap<String, Object>() ;
        userProfile.put("phone_number" , user.getPhoneNumber()) ;
        HashMap<String , Object> userMap = new HashMap<String,Object>() ;
        userMap.put("email" , user.getUserEmail()) ;
       /*to be deleted*/ userMap.put("password" , "ljljljljgkgkbmjgv") ;
        userMap.put("username", user.getUserName()) ;
       /*to be deleted*/ userMap.put("first_name" , "alaa") ;
        /*to be deleted*/userMap.put("last_name" , "kkkk") ;
        userProfile.put("user" , userMap) ;
        map.put("user_profile" , userProfile) ;
        return map ;
    }
}
