package edu.scu.lecture6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Clooney", "clooney.jpg"));
        people.add(new Person("Rickman", "rickman.jpg"));
        people.add(new Person("Trump", "trump.jpg"));

        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        listView.setAdapter(new CustomAdapter(this, R.layout.custom_row, people));
    }
}
