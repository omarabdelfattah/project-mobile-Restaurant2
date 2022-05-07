package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//list
public class list_fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list,container ,false);

        RecyclerView rv;
        rv= (RecyclerView) view.findViewById(R.id.rec);

        ArrayList<Meal> meals=new ArrayList<>();
        meals.add(new Meal(R.drawable.pizzza,"pizzza","its a gragjiajfjagiaj","20$"));
        meals.add(new Meal(R.drawable.pizzza,"pizzza2","dddddddddddddddddddddddddddddddd","25$"));
        meals.add(new Meal(R.drawable.pizzza,"pizzza","its a gragjiajfjagiaj","20$"));
        meals.add(new Meal(R.drawable.pizzza,"pizzza","its a gragjiajfjagiaj","20$"));
        meals.add(new Meal(R.drawable.pizzza,"pizzza","its a gragjiajfjagiaj","20$"));

        meals.add(new Meal(R.drawable.burger,"burgeer","burgeeeeeeeeeeeeer1","15$"));
        meals.add(new Meal(R.drawable.burger,"burgeer2","basic one","12$"));




        RecyclerViewAdapter adapter=new RecyclerViewAdapter(meals);
        RecyclerView.LayoutManager lm=new GridLayoutManager(getContext(),2);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        return view;




    }
}
