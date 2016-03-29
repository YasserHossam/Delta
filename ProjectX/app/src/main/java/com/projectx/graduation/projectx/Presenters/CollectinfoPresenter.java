package com.projectx.graduation.projectx.Presenters;

import com.projectx.graduation.projectx.Presenters.base.BasePresenter;
import com.projectx.graduation.projectx.UI.BaseView;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface CollectinfoPresenter extends BasePresenter {
    public interface View extends BaseView
    {
        void onFinish(Object object) ;
    }
}
