package edu.scu.coen268.lecture13background_work;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int interval = intent.getExtras().getInt("interval");
        for (int i = 0; i < 100; i++) {
            Log.d("COEN268", Integer.toString(interval * i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
