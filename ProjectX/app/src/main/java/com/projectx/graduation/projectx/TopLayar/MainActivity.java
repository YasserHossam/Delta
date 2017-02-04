package com.projectx.graduation.projectx.TopLayar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.projectx.graduation.projectx.R;
import com.projectx.graduation.projectx.TopLayar.UI.activity.CollectUserInfo;
import com.alexkasko.delta.DirDeltaPatcher;

import java.io.File;


public class MainActivity extends AppCompatActivity {



    String extractioPath ;
    String PatchPath ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        extractioPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ProjXAPK/" ;
        PatchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ProjXPatch/" ;

        File APKDir = new File(extractioPath) ;
        File PatchDir = new File(PatchPath);
       try {
            if(!APKDir.exists())
                APKDir.mkdirs() ;

           if(!PatchDir.exists())
               PatchDir.mkdirs();

       }
       catch (Exception e)
       {
           Log.wtf("TT:" , e.getMessage()) ;
       }




    }

    public void  go(String phoneNumber)
    {
        Intent intent = new Intent(this, CollectUserInfo.class);
        intent.putExtra("phoneNumber" , phoneNumber) ;
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
