package com.projectx.graduation.projectx.Models;

import java.lang.ref.SoftReference;

/**
 * Created by abdalrhmantaher on 3/27/16.
 */
public class User {
    public String userName  ;
    public String userEmail ;
    public String phoneNumber ;


    public User()
    {}
    public User(String userName , String userEmail , String phoneNumber)
    {
        this.userName = userName ;
        this.phoneNumber = phoneNumber ;
        this.userEmail = userEmail ;

    }
}
