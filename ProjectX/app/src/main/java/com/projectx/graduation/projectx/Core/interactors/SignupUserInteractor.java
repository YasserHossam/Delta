package com.projectx.graduation.projectx.Core.interactors;

import com.projectx.graduation.projectx.Core.interactors.base.Interactor;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface SignupUserInteractor extends Interactor {
    public interface Callback
    {
        public   void onSignUpSuccess(Object object) ;
        public  void onSignUpFaliure(String Message) ;
    }
}
