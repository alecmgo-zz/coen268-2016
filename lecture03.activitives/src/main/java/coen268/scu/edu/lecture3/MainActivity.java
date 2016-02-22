package coen268.scu.edu.lecture3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "mydata";
    private int count;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You win $800M!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        // The activity is about to become visible.
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        // The activity has become visible (it is now "resumed").
        super.onResume();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        count = prefs.getInt("count", 0); //0 is the default value.
        Toast.makeText(this, "onResume" + count, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        // Another activity is taking focus (this activity is about to be "paused").
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        count++;
        editor.putInt("count", count);
        editor.commit();
    }

    @Override
    protected void onStop() {
        // The activity is no longer visible (it is now "stopped")
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d("COEN268", "onStop");
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("COEN268", "onDestroy");

        // The activity is about to be destroyed.
        super.onDestroy();
    }
}
