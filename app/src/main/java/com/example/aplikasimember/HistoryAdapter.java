package com.example.aplikasimember;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<History> historyArrayList;


    public HistoryAdapter(Context context, ArrayList<History> historyArrayList) {

        this.context = context;
        this.historyArrayList = historyArrayList;
    }


    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_product, parent, false);
        return new HistoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {

        History history = historyArrayList.get(position);
        holder.txtName.setText(history.name);
        holder.txtNormalPrice.setText(""+history.normalPrice);
        holder.txtPromoPrice.setText(""+history.promoPrice);
        holder.imgProduct.setImageResource(history.titleImage);

        //handling click
        holder.cvProduct.setOnClickListener(view -> {
            //pindah ke activity product detail
            Intent intent = new Intent(this.context, DetailProdukActivity.class);
            intent.putExtra("product_name", history.name);
            intent.putExtra("product_normal_price", history.normalPrice);
            intent.putExtra("product_promo_price", history.promoPrice);
            intent.putExtra("product_img", history.titleImage);
            this.context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtNormalPrice;
        TextView txtPromoPrice;

        ImageView imgProduct;
        CardView cvProduct;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNormalPrice = itemView.findViewById(R.id.txtNormalPrice);
            txtPromoPrice = itemView.findViewById(R.id.txtPromoPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            cvProduct = itemView.findViewById(R.id.cvProduct);
        }
    }
}
