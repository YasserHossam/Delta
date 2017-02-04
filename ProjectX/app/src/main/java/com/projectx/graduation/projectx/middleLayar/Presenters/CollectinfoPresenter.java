package com.projectx.graduation.projectx.middleLayar.Presenters;

import com.projectx.graduation.projectx.middleLayar.Presenters.base.BasePresenter;
import com.projectx.graduation.projectx.TopLayar.UI.BaseView;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface CollectinfoPresenter extends BasePresenter {
    public interface View extends BaseView
    {
        void onFinish(Object object) ;
    }
}
