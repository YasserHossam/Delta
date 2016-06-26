package com.projectx.graduation.projectx.Core.interactors.impl;

import android.telecom.Call;

import com.projectx.graduation.projectx.Core.DeltaPatcher.DeltaPatcherInterface;
import com.projectx.graduation.projectx.Core.executor.Executor;
import com.projectx.graduation.projectx.Core.executor.MainThread;
import com.projectx.graduation.projectx.Core.interactors.base.AbstractInteractor;
import com.projectx.graduation.projectx.Core.interactors.applyPatchInteractor;
/**
 * Created by abdalrhmantaher on 6/23/16.
 */
public class applyPatchInteractorImpl extends AbstractInteractor implements applyPatchInteractor  {
    public DeltaPatcherInterface deltaPatcher ;
    public Callback mCallback ;
    public String APKPath ;
    public String PatchPath;
    public applyPatchInteractorImpl(Executor mThreadExecutor , MainThread mMainThread , DeltaPatcherInterface patcher , Callback callback , String apkPth , String patchPth )
    {
        super(mThreadExecutor , mMainThread);
        deltaPatcher = patcher ;
        mCallback = callback ;
        APKPath = apkPth ;
        PatchPath = patchPth ;
    }
    @Override
    public void run()
    {
        String Path =  deltaPatcher.applyPatch(APKPath , PatchPath) ;
        if(Path != null) {
            boolean installed = deltaPatcher.installApplication(APKPath);
            if(installed == true)
            {
                mCallback.onSuccess((Object) true);
            }
            else
            {
                mCallback.onFaliure("installation not successfull");

            }
        }
        else
        {
            mCallback.onFaliure("failed");

        }


    }
}
