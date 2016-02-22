package edu.scu.coen268.lecture13background_work;

import android.util.Log;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Log.d("COEN268", "Count: " + i);
        }
    }
}
