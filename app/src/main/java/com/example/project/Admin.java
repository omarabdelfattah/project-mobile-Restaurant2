package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText mealName,mealDesc,mealPrice,mealNewPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        notificationManager  =NotificationManagerCompat.from(this);

        mealName     = findViewById(R.id.Food);
        mealDesc     = findViewById(R.id.Describe);
        mealPrice    = findViewById(R.id.Price);
        mealNewPrice = findViewById(R.id.NewPrice);



    }
    public void sendOnChannel1(View v)
    {
        String name = mealName.getText().toString();
        String description = mealDesc.getText().toString();
        String price = mealPrice.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(name + " Arrived!!")
                .setContentText(description + "with price"+price+"$")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,notification);

    }

    public void sendOnChannel2(View v)
    {
        String name = mealName.getText().toString();
        String description = mealDesc.getText().toString();
        String oldPrice = mealPrice.getText().toString();
        String newPrice = mealNewPrice.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(name + "Offer Arrived!!")
                .setContentText(description + "with price"+newPrice+"$ instead of " + oldPrice+"$")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2,notification);
    }



}