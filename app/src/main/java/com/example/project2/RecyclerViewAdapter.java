package com.example.project2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.mealsViewHolder> {
    ArrayList<Meal> Meals;

    public RecyclerViewAdapter(ArrayList<Meal> Meal) {
        this.Meals = Meal;
    }

    @NonNull
    @Override
    public mealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_custom_item,null,false);

        return new mealsViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull mealsViewHolder holder, int position) {

        Meal meal=Meals.get(position);
        holder.tv_name.setText(meal.getName());
        holder.iv.setImageResource(meal.getImg());
        holder.price.setText(meal.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(view.getContext(),Product.class);
                i.putExtra("data", meal);
                view.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Meals.size();
    }



    class mealsViewHolder extends RecyclerView.ViewHolder{
            TextView tv_name;
            ImageView iv;
            TextView price;
            CardView cardView;
            LinearLayout ln;
        public mealsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name= itemView.findViewById(R.id.meal_custom_tv);
            iv= itemView.findViewById(R.id.meal_custom_image);
            price=itemView.findViewById(R.id.meal_custom_price);




        }
    }
}
