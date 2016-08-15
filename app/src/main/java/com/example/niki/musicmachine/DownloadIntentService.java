package com.example.niki.musicmachine;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by NIKI on 8/15/2016.
 */
public class DownloadIntentService extends IntentService {

    public DownloadIntentService(){
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
