package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailPromoActivity extends AppCompatActivity {
    String promoName;
    Double promoHargaPromo;
    Double promoHargaNormal;
    int imgPromo;

    TextView txtNama;
    TextView txtHargaNormal;
    TextView txtHargaPromo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);

        //ambil data dari intent extra
        promoName = getIntent().getStringExtra("promo_name");
        promoHargaPromo = getIntent().getDoubleExtra("promo_harga_promo",0);
        promoHargaNormal = getIntent().getDoubleExtra("promo_harga_normal",0);

        //deklarasi view
        txtNama = findViewById(R.id.txtName);
        txtHargaNormal = findViewById(R.id.txtHargaNormal);
        txtHargaPromo = findViewById(R.id.txtHargaPromo);

        //Format Number
        NumberFormat defaultFormat = NumberFormat.getInstance();
        String strHargaNormal = defaultFormat.format(promoHargaNormal);
        String strHargaPromo = defaultFormat.format(promoHargaPromo);

        //set text
        txtNama.setText(promoName);
        txtHargaNormal.setText(""+strHargaNormal);
        txtHargaPromo.setText(""+strHargaPromo);
    }
}