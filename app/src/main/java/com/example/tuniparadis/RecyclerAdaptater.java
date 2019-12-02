package com.example.tuniparadis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdaptater extends RecyclerView.Adapter<RecyclerAdaptater.ViewHolder> {
    private String[] nom={"Movenpick Resort&Spa","Movenpick Resort&Spa","Movenpick Resort&Spa"};
    private String[] lieu={"Gammarth","Gammarth","Gammarth"};
    private String[] prix={"150","150","150"};
    private int[] image={R.drawable.tunis,R.drawable.movenpick,R.drawable.fourseanse};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelistview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_nom.setText(nom[position]);
        holder.item_lieu.setText(lieu[position]);
        holder.item_prix.setText(prix[position]);
        holder.imageView.setImageResource(image[position]);


    }

    @Override
    public int getItemCount() { return nom.length;}
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView item_nom;
        private TextView item_lieu;
        private TextView item_prix;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            item_nom=itemView.findViewById(R.id.nom_hotel);
            item_lieu=itemView.findViewById(R.id.lieu);
            item_prix=itemView.findViewById(R.id.prix);
        }
    }
    }

