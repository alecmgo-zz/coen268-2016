package coen268.scu.edu.lecture8intents;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,  SecondActivity.class);
                startActivityForResult(i, Constants.REQUEST_CODE);

//                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
//                i.putExtra(Constants.CELEBRITY,"Leonardo & Scarlet");
//                startActivity(i);

//                Intent intent = new Intent(android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://www.youtube.com"));
//                startActivity(intent);
//
//                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//                intent.putExtra(SearchManager.QUERY, "puppy");
//                startActivity(intent);

//                String myData = "tel:555-1234";
//                Intent intent = new Intent(Intent.ACTION_CALL,
//                        Uri.parse(myData));
//                startActivity(intent);

//                // Create the text message with a string
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                String textMessage = "Hi!";
//                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
//                sendIntent.setType("text/plain");
//
//                // Verify that the intent will resolve to an activity
//                if (sendIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(sendIntent);
//                }
            }
        });
    }

    // and in First Activity receive data as onActivityResult:
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == RESULT_OK){
                ((TextView) findViewById(R.id.textView)).setText(data.getStringExtra(Constants.CELEBRITY));
            }
        }
    }
}
