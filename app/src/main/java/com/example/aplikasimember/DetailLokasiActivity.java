package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DetailLokasiActivity extends AppCompatActivity {

    ImageButton imB_1, imB_2, imB_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lokasi);

        imB_1 = findViewById(R.id.imB_1);
        imB_2 = findViewById(R.id.imB_2);
        imB_3 = findViewById(R.id.imB_3);

        imB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailLokasiActivity.this, StLocationActivity.class);
                startActivity(intent);
            }
        });

        imB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailLokasiActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        imB_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailLokasiActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

    }
}