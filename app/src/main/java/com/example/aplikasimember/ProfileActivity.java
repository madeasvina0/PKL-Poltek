package com.example.aplikasimember;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn;
    RadioButton genderRadioBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btn = findViewById(R.id.btn);
        radioGroup = findViewById(R.id.radioGroup);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"WrongViewCast", "ResourceType"})
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderRadioBtn = findViewById(R.id.radioGroup);

                if (selectedId == -1){
                    Toast.makeText(ProfileActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProfileActivity.this, genderRadioBtn.getId(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}