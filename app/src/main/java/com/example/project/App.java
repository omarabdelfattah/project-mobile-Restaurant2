package com.example.project;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application
{
    public static final String CHANNEL_1_ID = "homeChannel";
    public static final String CHANNEL_2_ID = "offerChannel";
    public static final String CHANNEL_3_ID = "deliveryChannel";


    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();

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

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Delivery !!",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("Delivery in progress");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);

        }
    }

}
