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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Context context;
    ArrayList<Product> productArrayList;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {

        this.context = context;
        this.productArrayList = productArrayList;



    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_product, parent, false);
        return new ProductAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        //inisialisasi object product
        Product product = productArrayList.get(position);
        holder.txtName.setText(product.name);
        holder.txtNormalPrice.setText(""+product.normalPrice);
        holder.txtPromoPrice.setText(""+product.promoPrice);
        holder.imgProduct.setImageResource(product.titleImage);

        //handling click
        holder.cvProduct.setOnClickListener(view -> {
            //pindah ke activity product detail
            Intent intent = new Intent(this.context, DetailProdukActivity.class);
            intent.putExtra("product_name", product.name);
            intent.putExtra("product_normal_price", product.normalPrice);
            intent.putExtra("product_promo_price", product.promoPrice);
            intent.putExtra("product_img", product.titleImage);
            this.context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtNormalPrice;
        TextView txtPromoPrice;

        ImageView imgProduct;
        CardView cvProduct;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //inisialisasi adapter ke view
            txtName = itemView.findViewById(R.id.txtName);
            txtNormalPrice = itemView.findViewById(R.id.txtNormalPrice);
            txtPromoPrice = itemView.findViewById(R.id.txtPromoPrice);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            cvProduct = itemView.findViewById(R.id.cvProduct);
        }
    }
}
