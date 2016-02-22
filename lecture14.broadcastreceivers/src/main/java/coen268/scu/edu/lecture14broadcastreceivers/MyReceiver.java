package coen268.scu.edu.lecture14broadcastreceivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

// Create a Broadcast Receiver that listens to SMS messages
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] messages = (Object[]) bundle.get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[]) messages[0]);
        Log.d("COEN268", message.getMessageBody() + " from " + message.getOriginatingAddress());

        int id = (int) (Math.random() * 100);
        Notification notification = new Notification.Builder(context)
                .setContentTitle("Message from " + message.getOriginatingAddress())
                .setContentText(message.getMessageBody())
                .setSmallIcon(android.R.drawable.ic_menu_day)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id, notification);
    }
}
