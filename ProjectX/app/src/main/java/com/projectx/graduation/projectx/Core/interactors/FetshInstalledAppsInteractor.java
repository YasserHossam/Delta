package com.projectx.graduation.projectx.Core.interactors;

import com.projectx.graduation.projectx.Core.interactors.base.Interactor;

/**
 * Created by abdalrhmantaher on 4/4/16.
 */
public interface FetshInstalledAppsInteractor extends Interactor {
    public interface Callback{
        public void onSuccess(Object object) ;
        public void onFaliure(String message) ;
    }
}
