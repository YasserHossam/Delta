package com.projectx.graduation.projectx.TopLayar.DeltaPatcher;

/**
 * Created by abdalrhmantaher on 6/22/16.
 */
public interface PatcherInterface {
    public String applyPatch(String APKPath , String PatchPath) ;
    public void installApplication(String APKPath) ;
}
