package com.example.niki.musicmachine;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nispok.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_SONG = "song";
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();

        mDownloadButton = (Button) findViewById(R.id.download);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading...", Toast.LENGTH_SHORT).show();

                //Send messages to handler for processing
                for(String song : Playlist.songs){
                    Intent intent = new Intent(MainActivity.this, DownloadService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }
            }
        });
    }
}
