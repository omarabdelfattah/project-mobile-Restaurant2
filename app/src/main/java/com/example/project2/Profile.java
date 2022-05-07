package com.example.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    private TextView email_xml , phone_xml, name_xml, credit_card_xml;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        SharedPreferences session_info = this.getContext().getSharedPreferences("SESSION_INFO", MODE_PRIVATE);

//        if(intent.getExtras() != null ){
//            Log.d("name",intent.getStringExtra("name"));
//        }

        String name = session_info.getString("name", "").toString();
        String email = session_info.getString("email", "").toString();
        String phone = session_info.getString("phone", "").toString();
        String credit_card = session_info.getString("credit_card", "").toString();

        name_xml = (TextView)  rootView.findViewById(R.id.name);
        phone_xml = (TextView)  rootView.findViewById(R.id.phone1);
        email_xml = (TextView)  rootView.findViewById(R.id.email1);
        credit_card_xml = (TextView)  rootView.findViewById(R.id.credit);

        phone_xml.setText(phone);
        email_xml.setText(email);
        name_xml.setText(name);
        credit_card_xml.setText(credit_card);
        return rootView;
    }



}