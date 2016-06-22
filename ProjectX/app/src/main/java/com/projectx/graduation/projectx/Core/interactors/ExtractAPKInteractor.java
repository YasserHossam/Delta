package com.projectx.graduation.projectx.Core.interactors;

import com.projectx.graduation.projectx.Core.interactors.base.Interactor;

/**
 * Created by abdalrhmantaher on 6/22/16.
 */
public interface ExtractAPKInteractor extends Interactor {
    public interface Callback {
        public void onSuccess(Object object) ;
        public void onFaliure(String message) ;
    }
}
