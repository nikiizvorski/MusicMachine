package com.example.niki.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by NIKI on 8/12/2016.
 */
public class DownloadService extends Service {


    public static final String TAG = DownloadService.class.getSimpleName();
    private DownloadHandler mHandler;

    @Override
    public void onCreate() {
        DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();
        //create the thread
        mHandler = thread.mHandler;
        mHandler.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        //create a message for the handler
        Message msg = Message.obtain();
        //get data and convert it with the songs
        msg.obj = song;
        //Add startID to msg
        msg.arg1 = startId;
        //send the messages to the handler
        mHandler.sendMessage(msg);

        return Service.START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
