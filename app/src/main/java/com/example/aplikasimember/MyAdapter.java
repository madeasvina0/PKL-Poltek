package com.example.aplikasimember;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Location> locationArrayList;

    public MyAdapter(Context context, ArrayList<Location> locationArrayList) {

        this.context = context;
        this.locationArrayList = locationArrayList;



    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Location location = locationArrayList.get(position);
        holder.txtCabang.setText(""+location.cabang);
        holder.txtDescLoc.setText(""+location.desc);
        holder.imgLocation.setImageResource(location.titleImage);


        //handling click
        holder.cvLocation.setOnClickListener(view -> {
            //pindah ke activity product detail
            Intent intent = new Intent(this.context, DetailLokasiActivity.class);
            intent.putExtra("location_cabang", location.cabang);
            intent.putExtra("location_desc", location.desc);
            intent.putExtra("location_img", location.titleImage);
            this.context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return locationArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView txtCabang;
        TextView txtDescLoc;
        ImageView imgLocation;
        CardView cvLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //inisialisasi adapter ke view
            txtCabang = itemView.findViewById(R.id.txtCabang);
            txtDescLoc = itemView.findViewById(R.id.txtDescLoc);
            imgLocation = itemView.findViewById(R.id.imgLocation);
            cvLocation = itemView.findViewById(R.id.cvLocation);

        }
    }
}
