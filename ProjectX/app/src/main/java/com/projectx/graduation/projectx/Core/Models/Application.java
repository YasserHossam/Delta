package com.projectx.graduation.projectx.Core.Models;

import com.google.gson.annotations.Expose;

/**
 * Created by abdalrhmantaher on 4/3/16.
 */
public class Application {
    @Expose
    private String applicationName ;
    @Expose
    private String versionNumber ;
    @Expose
    private String packageName ;

    public Application()
    {}
    public Application(String applicationName , String versionNumber , String packageName)
    {
        this.applicationName = applicationName ;
        this.packageName = packageName ;
        this.versionNumber = versionNumber ;
    }

    public String getApplicationName()
    {
        return this.applicationName ;
    }
    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName ;
    }

    public String getVersionNumber()
    {
        return this.versionNumber ;
    }
    public void setVersionNumber(String versionNumber)
    {
        this.versionNumber = versionNumber ;
    }

    public String getPackageName()
    {
        return this.packageName ;
    }
    public void setPackageName(String packageName)
    {
        this.packageName = packageName ;
    }
}
