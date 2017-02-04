package com.projectx.graduation.projectx.Core.DeltaPatcher;

/**
 * Created by abdalrhmantaher on 6/23/16.
 */
public interface DeltaPatcherInterface {
    public String applyPatch(String APKPath , String PatchPath) ;
    public boolean installApplication(String APKPath) ;
}
