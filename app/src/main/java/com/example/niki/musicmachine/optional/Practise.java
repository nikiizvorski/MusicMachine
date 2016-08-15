package com.example.niki.musicmachine.optional;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by NIKI on 8/12/2016.
 */
public class Practise extends AppCompatActivity {
    private PractiseThread mThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Message msg = Message.obtain();
        mThread.mHandler.sendMessage(msg);
    }


    class PractiseThread extends Thread {
        //create the Handler Object
        private PractiseHandler mHandler;

        @Override
        public void run() {
            //Create the Queue for msgs
            Looper.prepare();

            //Initialize the handler
            mHandler = new PractiseHandler();

            //Loop all of the msgs to send to handler
            Looper.loop();
        }
    }

    class PractiseHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            dowork(msg.obj.toString());
        }

        public void dowork(String work){
            work.toString();
        }
    }
}
