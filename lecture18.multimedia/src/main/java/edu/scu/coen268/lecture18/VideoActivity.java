package edu.scu.coen268.lecture18;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Uri videoUri = Uri.parse("android.resource://"
                + getPackageName() + "/" + R.raw.sample2);

        VideoView myVideo = (VideoView) findViewById(R.id.videoView);
        myVideo.setVideoURI(videoUri);

        MediaController mc = new MediaController(this);
        mc.setMediaPlayer(myVideo);
        myVideo.setMediaController(mc);
        myVideo.requestFocus();
        mc.show();
    }

}
