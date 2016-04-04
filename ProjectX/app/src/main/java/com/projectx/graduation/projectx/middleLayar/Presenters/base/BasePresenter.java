package com.projectx.graduation.projectx.middleLayar.Presenters.base;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface BasePresenter {

    void resume() ;


    void pause() ;


    void stop() ;


    void destroy() ;


    void onError(String message) ;
}
