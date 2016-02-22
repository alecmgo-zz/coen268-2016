package edu.scu.lecture5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.catImageView);
        img.setImageResource(R.drawable.cat);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    private void loadCsv() throws IOException {
        InputStream ins = getResources().openRawResource(R.raw.data);
        InputStreamReader reader = new InputStreamReader(getAssets().open("names.csv"));
    }
}
