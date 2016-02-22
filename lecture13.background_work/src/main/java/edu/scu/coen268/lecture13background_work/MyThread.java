package edu.scu.coen268.lecture13background_work;

import android.util.Log;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Log.d("COEN268", "Count: " + i);
        }
    }
}
