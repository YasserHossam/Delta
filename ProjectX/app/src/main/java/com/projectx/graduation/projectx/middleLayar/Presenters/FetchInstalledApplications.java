package com.projectx.graduation.projectx.middleLayar.Presenters;

import com.projectx.graduation.projectx.TopLayar.UI.BaseView;
import com.projectx.graduation.projectx.middleLayar.Presenters.base.BasePresenter;

/**
 * Created by abdalrhmantaher on 4/7/16.
 */
public interface FetchInstalledApplications extends BasePresenter {
    public interface View extends BaseView
    {
        public void onFinish();
    }

}
