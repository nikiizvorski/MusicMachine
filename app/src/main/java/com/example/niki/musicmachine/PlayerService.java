package com.example.niki.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by NIKI on 8/15/2016.
 */
public class PlayerService extends Service {
    private static final String TAG = PlayerService.class.getSimpleName();
    private MediaPlayer player;
    private IBinder mBinder = new LocalBinder();

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate PlayerService");
        player = MediaPlayer.create(this, R.raw.jingle);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind PlayerService");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind PlayerService");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy PlayerService");
        player.release();
    }

    //Creating Binder Class becouse we cannot use IBinder Interface dirrectly

    public class LocalBinder extends Binder {
        public PlayerService getService() {
            return PlayerService.this;
        }
    }

    //  Client Methods these methods cannot be private becouse
    // clients will not be able to use them.

    public Boolean isPlaying() {
         return player.isPlaying();
    }

    public void play() {
        player.start();
    }

    public void pause() {
        player.pause();
    }
}
