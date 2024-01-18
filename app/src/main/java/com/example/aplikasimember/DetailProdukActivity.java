package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

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