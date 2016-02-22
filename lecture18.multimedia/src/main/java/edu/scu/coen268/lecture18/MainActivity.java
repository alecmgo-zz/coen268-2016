package edu.scu.coen268.lecture18;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToMediaStoreDB();

                // Launch the gallery viewer for images.
                Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Intent myIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(myIntent);
            }
        });
    }

    protected void addToMediaStoreDB() {
        try {
            File mSampleFile = new File("/sdcard/myfile.mp3");
            long now = System.currentTimeMillis();
            ContentValues newValues = new ContentValues(6);
            newValues.put(MediaStore.MediaColumns.TITLE, "test_" + mSampleFile.getName());
            newValues.put(MediaStore.MediaColumns.DATE_ADDED, (int) (now / 1000));
            newValues.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mpeg");
            newValues.put(MediaStore.Audio.AudioColumns.IS_MUSIC, true);
            newValues.put(MediaStore.Audio.AudioColumns.ARTIST, "myself");
            newValues.put(MediaStore.MediaColumns.DATA, mSampleFile.getAbsolutePath());

            ContentResolver contentResolver = getContentResolver();
            Uri base = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            Uri newUri = contentResolver.insert(base, newValues);

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, newUri));

            Toast.makeText(this, "Added to MediaStore:\n "
                    + mSampleFile.getAbsolutePath(), 1).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error MediaStore\n" + e.getMessage(), 1).show();
        }
    }

}
