package edu.scu.coen268.lecture20contentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

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
                // Example querying contacts
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, null, null, null);
                int displayNameColumn = cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int phoneNumberColumn = cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER);
                while (cursor.moveToNext()) {
                    Log.d("COEN268", cursor.getString(displayNameColumn) + ": " +
                            cursor.getString(phoneNumberColumn));
                }
                cursor.close();

                // Example writing to the call log
                ContentValues values = new ContentValues();
                values.put(CallLog.Calls.NUMBER, "911");
                values.put(CallLog.Calls.DATE, System.currentTimeMillis());
                values.put(CallLog.Calls.TYPE, CallLog.Calls.OUTGOING_TYPE);
                values.put(CallLog.Calls.NEW, 1);
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CALL_LOG)
                        == PackageManager.PERMISSION_GRANTED) {
                    Log.d("COEN268", "Inserting call log");
                    getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
                }
            }
        });
    }
}
