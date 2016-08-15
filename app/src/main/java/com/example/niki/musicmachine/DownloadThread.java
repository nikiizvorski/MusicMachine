package com.example.niki.musicmachine;

import android.os.Looper;
import android.util.Log;

/**
 * Created by NIKI on 8/12/2016.
 */
public class DownloadThread extends Thread {

    //Create a Handler
    public DownloadHandler mHandler;

    @Override
    public void run() {
        //Create a looper to make the message queue to be send to the handler.
        Looper.prepare();
        mHandler = new DownloadHandler();
        //Start Looping over the message queue
        Looper.loop();
    }
}
