package com.example.project;

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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.meilsViewHolder> {
    ArrayList<Meil> Meils;

    public RecyclerViewAdapter(ArrayList<Meil> Meil) {
        this.Meils = Meil;
    }

    @NonNull
    @Override
    public meilsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.meil_custom_item,null,false);

        return new meilsViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull meilsViewHolder holder, int position) {

        Meil meil=Meils.get(position);
        holder.tv_name.setText(meil.getName());
        holder.iv.setImageResource(meil.getImg());
        holder.price.setText(meil.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(view.getContext(),Product.class);
                i.putExtra("data", meil);
                view.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Meils.size();
    }



    class meilsViewHolder extends RecyclerView.ViewHolder{
            TextView tv_name;
            ImageView iv;
            TextView price;
            CardView cardView;
            LinearLayout ln;
        public meilsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name= itemView.findViewById(R.id.meil_custom_tv);
            iv= itemView.findViewById(R.id.meil_custom_image);
            price=itemView.findViewById(R.id.meil_custom_price);




        }
    }
}
