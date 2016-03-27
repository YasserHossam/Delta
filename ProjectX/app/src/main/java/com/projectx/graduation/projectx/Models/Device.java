package com.projectx.graduation.projectx.Models;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public class Device {
    public String deviceID ;
    public String appID ;
    public String deviceType ;
    public String androidVersion ;

    public Device()
    {}
    public Device(String deviceID , String appID , String deviceType , String androidVersion)
    {
        this.deviceID = deviceID ;
        this.appID = appID ;
        this.deviceType = deviceType ;
        this.androidVersion = androidVersion ;

    }
}
