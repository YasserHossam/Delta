package com.projectx.graduation.projectx.Core.Models;

import com.google.gson.annotations.Expose;

import java.lang.ref.SoftReference;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public class User {
    @Expose
    private String userName  ;
    @Expose
    private String userEmail ;
    @Expose
    private String phoneNumber ;


    public User()
    {}
    public User(String userName , String userEmail , String phoneNumber)
    {
        this.userName = userName ;
        this.phoneNumber = phoneNumber ;
        this.userEmail = userEmail ;

    }

    public String getUserName()
    {
        return this.userName ;
    }
    public void  setUserName(String userName)
    {
        this.userName = userName ;
    }

    public String getUserEmail()
    {
        return this.userEmail ;
    }
    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail ;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber ;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber ;
    }
}
