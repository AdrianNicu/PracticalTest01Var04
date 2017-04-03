package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;

public class PracticalTest01Var04Service extends Service {
    public PracticalTest01Var04Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Serviciu", "onCreate() method was invoked");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO: exercise 5 - implement and start the ProcessingThread
        Log.d("serviciu", "OnStartCommand() called in StatedService");
        String sablon = intent.getStringExtra("key2");


        final String[] a = sablon.split(",");
        Thread dedicatedThread = new Thread(new Runnable() {
            @Override
            public void run() {

            for (int i = 0; i < a.length; i++) {
                Intent intentStr = new Intent("ACTIONSTR");
                intentStr.putExtra("key3", a[i]);
                sendBroadcast(intentStr);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            }
        });
        dedicatedThread.start();
        return START_REDELIVER_INTENT;
    }
}
