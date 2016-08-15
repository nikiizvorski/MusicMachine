package com.example.niki.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by NIKI on 8/12/2016.
 */
public class DownloadHandler extends Handler {

    public static final String TAG = DownloadHandler.class.getSimpleName();
    private DownloadService service;

    @Override
    public void handleMessage(Message msg) {
        downloadSongs(msg.obj.toString());
        //pass the service and stop after receiving all the startId of our Songs.
        service.stopSelf(msg.arg1);
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

    public void setService(DownloadService service) {
        this.service = service;
    }
}
