package com.projectx.graduation.projectx.Core.Network;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abdalrhmantaher on 4/4/16.
 */
public interface PushInstalledApplicationsNetworkInterface {
    public  void pushInstalledApps(HashMap<String , Object> requestBody , Iresponse response) ;

}
