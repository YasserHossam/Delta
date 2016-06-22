package com.projectx.graduation.projectx.Core.interactors.impl;

import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.ExtractAPKInteractor;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by abdalrhmantaher on 6/22/16.
 */
public class ExtractAPKInteractorImpl extends AbstractInteractor implements ExtractAPKInteractor {
    public String packageName ;
    public List apkPaths ;
    public String appPath ;
    public Callback mCallBack ;
    public ExtractAPKInteractorImpl(Executor mThreadExecutor , MainThread mMainThread , String pName , List pahts , String appPath , Callback callback)
    {
        super(mThreadExecutor , mMainThread);
        packageName = pName ;
        apkPaths = pahts  ;
        this.appPath = appPath ;
        mCallBack = callback ;
    }

    @Override
    public void  run()
    {
        for(int index = 0 ; index < apkPaths.size() ; index++)
        {
            File file = new File((String) apkPaths.get(index)) ;
            String absPath = file.getAbsolutePath() ;
            if(absPath.contains(packageName))
            {
                copyFileInDir(file);
                break ;
            }


        }
    }

    public void copyFileInDir(File file)
    {
        try {
            File appDir = new File(appPath) ;
            appDir.createNewFile() ;
            InputStream inputStream = null ;
            OutputStream outputStream = null;
            inputStream = new FileInputStream(file) ;
            outputStream = new FileOutputStream(appDir);
            byte[] buffer = new byte[1024] ;
            int read;
            while ((read = inputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer , 0 , read);

            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();



        }
        catch (Exception e)
        {

        }


    }
}
