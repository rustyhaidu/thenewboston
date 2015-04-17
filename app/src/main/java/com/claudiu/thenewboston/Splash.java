package com.claudiu.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Claudiu on 2/15/2015.
 */
public class Splash extends Activity{
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle toTheSuperClass) {
        super.onCreate(toTheSuperClass);
        setContentView(R.layout.splash);  //xml splash
        ourSong = MediaPlayer.create(Splash.this, R.raw.transformation);
        ourSong.start();
        //Thread urmeaza timer

        Thread timer = new Thread()
        {
           public void run()
           {
               try
               {
                    sleep(5000);
               }
               catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent openMainIntent = new Intent("ClassMenu");
                    startActivity(openMainIntent);
                }

           }
        };
        timer.start();
    }
    protected void onPause()
    {
        super.onPause();
        ourSong.release();
        finish();
    }

}

