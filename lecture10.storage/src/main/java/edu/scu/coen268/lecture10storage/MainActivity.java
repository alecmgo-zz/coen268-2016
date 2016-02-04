package edu.scu.coen268.lecture10storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "myprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefsExample();
        internalStorageExample();
    }

    private void sharedPrefsExample() {
        SharedPreferences settings =
                getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("silentMode", true);
        editor.commit();
    }

    private void internalStorageExample() {
        String filename = "diary.txt";
        String body = "My deepest secret is...";
        try {
            FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE);
            fos.write(body.getBytes());
            fos.close();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(openFileInput(filename)));
            Log.d("COEN268", "From file: " + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
