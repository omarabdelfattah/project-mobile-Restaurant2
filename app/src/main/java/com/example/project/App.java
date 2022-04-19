package com.example.project;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application
{
    public static final String CHANNEL_1_ID = "homeChannel";
    public static final String CHANNEL_2_ID = "offerChannel";


    @Override
    public void onCreate() {
        super.onCreate();

    }
    private void createNotificationChannels()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel1 = new NotificationChannel(
                  CHANNEL_1_ID,
                  "New Meal!!",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("new Meal Arrived!!");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "New Offer!!",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("new Offer Arrived!!");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }

}
