package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class offer_fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_offers,container ,false);

        RecyclerView rv;
        rv= (RecyclerView)view.findViewById(R.id.rec1);

        ArrayList<offer_items> offers=new ArrayList<>();
        offers.add(new offer_items(R.drawable.bufflocomp,"2 cheese burger with special taste","Friend Comp","1̶5̶0̶$", "120$"));
        offers.add(new offer_items(R.drawable.bufflocomp,"3 cheese burger with special taste","Triple Burgers","1̶5̶0̶$","100$"));
        offers.add(new offer_items(R.drawable.bufflocomp,"2 cheese burger with special taste","Elakel Comp","1̶5̶0$","120$"));
        offers.add(new offer_items(R.drawable.bufflocomp,"3 cheese burger with special taste","Elshla Comp","1̶5̶0$","90$"));
        offers.add(new offer_items(R.drawable.bufflocomp,"2 cheese burger with special taste","Elakel Comp","1̶5̶0$","120$"));
        offers.add(new offer_items(R.drawable.bufflocomp,"3 cheese burger with special taste","Elshla Comp","1̶5̶0$","90$"));







        RecyclerViewAdapterOffer adapter=new RecyclerViewAdapterOffer(offers);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return view;




    }
}
