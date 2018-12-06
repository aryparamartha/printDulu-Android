package com.example.aryparamartha.printit;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.aryparamartha.printit.User.MainMenu.UserMainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService{

    @Override
    public void onNewToken(String s) {
        //super.onNewToken(s);
        Log.d("token",s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String message=remoteMessage.getNotification().getBody();
        String title=remoteMessage.getNotification().getTitle();

        Intent intent = new Intent(this, UserMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "my_channel")
                .setContentText(message)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(sound)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }
}
