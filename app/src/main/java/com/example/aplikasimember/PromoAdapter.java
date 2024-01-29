package com.example.aplikasimember;

import static androidx.core.content.ContextCompat.startActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder> {

    Context context;
    ArrayList<Promo> promoArrayList;

    public PromoAdapter(Context context, ArrayList<Promo> promoArrayList) {

        this.context = context;
        this.promoArrayList = promoArrayList;



    }

    @NonNull
    @Override
    public PromoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_promo, parent, false);
        return new PromoAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.MyViewHolder holder, int position) {
        //inisialisasi object promo
        Promo promo = promoArrayList.get(position);
        holder.txtNames.setText(promo.name);
        holder.txtNormal.setText(""+promo.hargaNormal);
        holder.txtPromo.setText(""+promo.hargaPromo);
        holder.imgPromo.setImageResource(promo.titleImg);

        //handling click
        holder.cvPromo.setOnClickListener(view -> {
            //pindah ke activity promo detail
            Intent intent = new Intent(this.context, DetailPromoActivity.class);
            intent.putExtra("promo_nama", promo.name);
            intent.putExtra("promo_harga_normal", promo.hargaNormal);
            intent.putExtra("promo_harga_promo", promo.hargaPromo);
            intent.putExtra("promo_img", promo.titleImg);
            this.context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return promoArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtNames;
        TextView txtNormal;
        TextView txtPromo;

        ImageView imgPromo;
        CardView cvPromo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //inisialisasi adapter ke view
            txtNames = itemView.findViewById(R.id.txtName);
            txtNormal = itemView.findViewById(R.id.txtHargaNormal);
            txtPromo = itemView.findViewById(R.id.txtHargaPromo);
            imgPromo = itemView.findViewById(R.id.imgPromo);
            cvPromo = itemView.findViewById(R.id.cvPromo);
        }
    }
}
