package com.example.niki.musicmachine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by NIKI on 8/15/2016.
 */
public class DownloadIntentService extends IntentService {

    public static final String TAG = DownloadIntentService.class.getSimpleName();

    public DownloadIntentService(){
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSongs(song);
    }

    public void downloadSongs(String song) {
        long endTime = System.currentTimeMillis() + 10*1000;
        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + "DOWNLOADED");
    }

}
