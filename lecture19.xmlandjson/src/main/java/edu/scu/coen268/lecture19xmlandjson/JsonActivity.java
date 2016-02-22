package edu.scu.coen268.lecture19xmlandjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        try {
            // Example: Parsing a JSON string
            JSONObject obj = new JSONObject(
                    "{name: 'Alec', age: 50.5, misc: {hands: 2}}");

            System.out.println("Name: " + obj.getString("name"));
            System.out.println("Age: " + obj.getDouble("age"));
            System.out.println("Hands: " +
                    obj.getJSONObject("misc").getInt("hands"));

            // Example: Constructing a JSON object
            JSONObject obj2 = new JSONObject();
            obj2.put("name", "Michelle");
            obj2.put("age", 23.3);

            JSONObject misc = new JSONObject();
            misc.put("hands",  2);
            obj2.put("misc", misc);

            System.out.println(obj2.toString());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
