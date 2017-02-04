package com.projectx.graduation.projectx.TopLayar.Helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.projectx.graduation.projectx.Core.Models.Application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 * Created by abdalrhmantaher on 4/3/16.
 */
public class packageExtractor {
    private PackageManager manager ;
    Context context ;
    public packageExtractor(Context context)
    {
        this.context = context ;
        manager  = context.getPackageManager() ;
    }

    public ArrayList<Application> getInstalledApps()
    {
        ArrayList<Application> apps = new ArrayList<Application>() ;
        List<PackageInfo> packs = manager.getInstalledPackages(0) ;
        for(int i = 0 ; i<packs.size() ; i++)
        {
            PackageInfo p = packs.get(i) ;
            if(p.versionName == null)
                continue;
            if((p.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                Application app = new Application();
                app.setApplicationName(p.applicationInfo.loadLabel(manager).toString());
                app.setPackageName(p.packageName);
                app.setVersionNumber(p.versionName);

                apps.add(app);
            }
        }
        HashMap<String , Object> map = new HashMap<String, Object>() ;
        map.put("app" , apps) ;
        return apps  ;
    }
}
