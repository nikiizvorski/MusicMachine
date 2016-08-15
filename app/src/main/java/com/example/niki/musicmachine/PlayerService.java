package com.example.niki.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by NIKI on 8/15/2016.
 */
public class PlayerService extends Service {
    private MediaPlayer player;

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.jingle);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
