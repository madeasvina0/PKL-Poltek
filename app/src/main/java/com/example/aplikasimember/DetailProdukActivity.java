package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailProdukActivity extends AppCompatActivity {
    String productName;
    Double productPromoPrice;
    Double productNormalPrice;
    int productImg;

    TextView txtName;
    TextView txtNormalPrice;
    TextView txtPromoPrice;


    ImageButton imB_1, imB_2, imB_3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        imB_1 = findViewById(R.id.imB_1);
        imB_2 = findViewById(R.id.imB_2);
        imB_3 = findViewById(R.id.imB_3);

        imB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProdukActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        imB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProdukActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        imB_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProdukActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        //ambil data dari intent extra
        productName = getIntent().getStringExtra("product_name");
        productPromoPrice = getIntent().getDoubleExtra("product_promo_price",0);
        productNormalPrice = getIntent().getDoubleExtra("product_normal_price",0);

        //deklarasi view
        txtName = findViewById(R.id.txtName);
        txtNormalPrice = findViewById(R.id.txtNormalPrice);
        txtPromoPrice = findViewById(R.id.txtPromoPrice);

        //Format Number
        NumberFormat defaultFormat = NumberFormat.getInstance();
        String strNormalPrice = defaultFormat.format(productNormalPrice);
        String strPromoPrice = defaultFormat.format(productPromoPrice);

        //set text
        txtName.setText(productName);
        txtNormalPrice.setText(""+strNormalPrice);
        txtPromoPrice.setText(""+strPromoPrice);
    }
}