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

public class RecyclerViewAdapterOffer extends RecyclerView.Adapter<RecyclerViewAdapterOffer.offerViewHolder> {
    ArrayList<offer_items> offers ;

    public RecyclerViewAdapterOffer(ArrayList<offer_items> offer) {
        this.offers = offer;
    }

    @NonNull
    @Override
    public offerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item,null,false);

        return new offerViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull offerViewHolder holder, int position) {

       offer_items offer=offers.get(position);
        holder.offer_name.setText(offer.getName());
        holder.i_offer.setImageResource(offer.getImg());
        holder.old_price.setText(offer.getOld_price());
        holder.new_price.setText(offer.getNew_price());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),Product.class);
                i.putExtra("data2", offer);
                view.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }



    class offerViewHolder extends RecyclerView.ViewHolder{
        TextView offer_name;
        ImageView i_offer;
        TextView old_price;
        TextView new_price;


        public offerViewHolder(@NonNull View itemView) {
            super(itemView);
            offer_name= itemView.findViewById(R.id.name_item);
            i_offer= itemView.findViewById(R.id.image_offer);
            old_price=itemView.findViewById(R.id.old_price);
            new_price=itemView.findViewById(R.id.new_price);





        }
    }
}
