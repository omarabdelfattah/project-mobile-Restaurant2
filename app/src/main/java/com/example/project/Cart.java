package com.example.project;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private NumberPicker np;
    private Button btn;
    private RadioButton btnCredit,btnCash;
    private NotificationManagerCompat notificationManager;

    public Cart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cart.
     */
    // TODO: Rename and change types and number of parameters
    public static Cart newInstance(String param1, String param2) {
        Cart fragment = new Cart();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        btn = rootView.findViewById(R.id.submit);
        notificationManager  = NotificationManagerCompat.from(this.getContext());

        // on click credit
//        btnCredit = rootView.findViewById(R.id.credit);
//        btnCredit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnCash.setChecked(false);
//            }
//        });
//        btnCash = rootView.findViewById(R.id.credit);
//        btnCash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnCredit.setChecked(false);
//            }
//        });
        // On click submit
        btn = rootView.findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(),"Order is being handled!",Toast.LENGTH_SHORT).show();
                sendOnChannel3(view);
                Intent intent = new Intent(rootView.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        np =  rootView.findViewById(R.id.numberPicker);
        np.setMinValue(1);
        np.setMaxValue(100);

        np =  rootView.findViewById(R.id.numberPicker2);
        np.setMinValue(1);
        np.setMaxValue(100);

        np =  rootView.findViewById(R.id.numberPicker3);
        np.setMinValue(1);
        np.setMaxValue(100);


        np =  rootView.findViewById(R.id.numberPicker4);
        np.setMinValue(1);
        np.setMaxValue(100);


        np =  rootView.findViewById(R.id.numberPicker5);
        np.setMinValue(1);
        np.setMaxValue(100);

        np =  rootView.findViewById(R.id.numberPicker6);
        np.setMinValue(1);
        np.setMaxValue(100);

        np =  rootView.findViewById(R.id.numberPicker7);
        np.setMinValue(1);
        np.setMaxValue(100);

        np =  rootView.findViewById(R.id.numberPicker8);
        np.setMinValue(1);
        np.setMaxValue(100);


        return rootView;
    }

    public void sendOnChannel3(View v)
    {
        Notification notification = new NotificationCompat.Builder(this.getContext(),App.CHANNEL_3_ID)
                .setSmallIcon(R.drawable.delivery)
                .setContentTitle("Delivery in progress 🚚!!")
                .setContentText("Your meal is arriving in 25 minutes")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                .setLights(Color.RED, 3000, 3000)
                .build();
        notificationManager.notify(3,notification);
    }
 }