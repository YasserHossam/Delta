package com.projectx.graduation.projectx.Models;

import com.google.gson.annotations.Expose;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public class Device {
    @Expose
    private String deviceID ;
    @Expose
    private String appID ;
    @Expose
    private String deviceType ;
    @Expose
    private String androidVersion ;

    public Device()
    {}
    public Device(String deviceID , String appID , String deviceType , String androidVersion)
    {
        this.deviceID = deviceID ;
        this.appID = appID ;
        this.deviceType = deviceType ;
        this.androidVersion = androidVersion ;

    }

    public String getDeviceID()
    {
        return  this.deviceID ;
    }
    public void setDeviceID(String deviceID)
    {
        this.deviceID = deviceID ;
    }

    public String getAppID()
    {
        return this.appID ;
    }
    public void setAppID(String appID)
    {
        this.appID = appID ;
    }

    public String getDeviceType()
    {
        return this.deviceType ;
    }
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType ;
    }

    public String getAndroidVersion()
    {
        return this.androidVersion ;
    }
    public void setAndroidVersion(String androidVersion)
    {
        this.androidVersion = androidVersion ; 
    }

}
