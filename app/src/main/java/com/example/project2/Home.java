package com.example.project2;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment implements View.OnClickListener {

    public CardView c1, c2, c3, c4, c5, c6, c7, c8;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        c1 = (CardView) rootView.findViewById(R.id.card1);
        c2 = (CardView) rootView.findViewById(R.id.card2);
        c3 = (CardView) rootView.findViewById(R.id.card3);
        c4 = (CardView) rootView.findViewById(R.id.card4);
        c5 = (CardView) rootView.findViewById(R.id.card5);
        c6 = (CardView) rootView.findViewById(R.id.card6);
        c7 = (CardView) rootView.findViewById(R.id.card7);
        c8 = (CardView) rootView.findViewById(R.id.card8);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        return rootView;

    }
    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId()) {
            case R.id.card1:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;


            case R.id.card2:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;
            case R.id.card3:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;

            case R.id.card4:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;

            case R.id.card5:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;

            case R.id.card6:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;

            case R.id.card7:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;

            case R.id.card8:
                i=new Intent(this.getContext(),Product.class);
                startActivity(i);
                break;


        }


    }
}