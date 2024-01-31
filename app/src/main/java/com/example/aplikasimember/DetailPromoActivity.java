package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailPromoActivity extends AppCompatActivity {
    String promoName;
    Double promoHargaPromo;
    Double promoHargaNormal;
    int imgPromo;

    TextView txtName;
    TextView txtHargaNormal;
    TextView txtHargaPromo;

    ImageButton imB_1, imB_2, imB_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);

        imB_1 = findViewById(R.id.imB_1);
        imB_2 = findViewById(R.id.imB_2);
        imB_3 = findViewById(R.id.imB_3);

        imB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPromoActivity.this, PromotionActivity.class);
                startActivity(intent);
            }
        });

        imB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPromoActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        imB_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPromoActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });


        //ambil data dari intent extra
        promoName = getIntent().getStringExtra("promo_name");
        promoHargaPromo = getIntent().getDoubleExtra("promo_harga_promo",0);
        promoHargaNormal = getIntent().getDoubleExtra("promo_harga_normal",0);

        //deklarasi view
        txtName = findViewById(R.id.txtName);
        txtHargaNormal = findViewById(R.id.txtHargaNormal);
        txtHargaPromo = findViewById(R.id.txtHargaPromo);

        //Format Number
        NumberFormat defaultFormat = NumberFormat.getInstance();
        String strHargaNormal = defaultFormat.format(promoHargaNormal);
        String strHargaPromo = defaultFormat.format(promoHargaPromo);

        //set text
        txtName.setText(promoName);
        txtHargaNormal.setText(""+strHargaNormal);
        txtHargaPromo.setText(""+strHargaPromo);
    }
}