package edu.scu.lecture6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Instead of a List of Strings, use a List of Persons.
        List<Person> people = new ArrayList<>();
        people.add(new Person("Clooney", "clooney.jpg"));
        people.add(new Person("Rickman", "rickman.jpg"));
        people.add(new Person("Trump", "trump.jpg"));

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new CustomAdapter(this, R.layout.custom_row, people));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("COEN268", "Position selected: " + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("COEN268", "Nothing selected");
            }
        });
    }
}
