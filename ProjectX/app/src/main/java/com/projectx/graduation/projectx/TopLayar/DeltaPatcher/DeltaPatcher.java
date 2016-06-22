package com.projectx.graduation.projectx.TopLayar.DeltaPatcher;

import com.alexkasko.delta.DirDeltaPatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Object;

import android.app.Activity;
import android.content.Intent ;
import android.content.Context ;
import android.net.Uri;

/**
 * Created by abdalrhmantaher on 6/22/16.
 */
public class DeltaPatcher implements PatcherInterface{
    public Context context ;
    DeltaPatcher(Context con)
    {

        context = con ;
    }
    public String applyPatch(String APKPath , String PatchPath)
    {
        File APKDireactory = new File(APKPath) ;
        File PatchDirectory = new File(PatchPath) ;
        try {
            new DirDeltaPatcher().patch(APKDireactory , PatchDirectory);
        }
        catch (IOException e)
        {

        }

        return APKPath ;
    }

    public void installApplication(String APKPath)
    {
        File APKDir = new File (APKPath) ;
        File APKFile = APKDir.listFiles()[0] ;
        try {
            InputStream inputStream = new FileInputStream(APKFile);

            byte[] buffer = new byte[inputStream.available()] ;
            int read = inputStream.read(buffer);

            String tempFileName = APKFile.getName();
            FileOutputStream fileOutputStream = context.openFileOutput(tempFileName , context.MODE_WORLD_READABLE) ;

            fileOutputStream.write(buffer);
            fileOutputStream.close();
            inputStream.close();

            File tempFile =context.getFileStreamPath(tempFileName) ;
            Intent intent = new Intent(Intent.ACTION_VIEW) ;
            intent.setDataAndType(Uri.fromFile(tempFile), "application/vnd.android.package-archive");
            context.startActivity(Intent.createChooser(intent, "updater"));



        }
        catch (IOException e)
        {


        }

    }
}
