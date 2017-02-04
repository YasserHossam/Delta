package com.projectx.graduation.projectx.Core.executor;

import java.io.Serializable;

/**
 * Created by abdalrhmantaher on 3/29/16.
 */
public interface MainThread extends Serializable {
    void post(final Runnable runnable);
}
