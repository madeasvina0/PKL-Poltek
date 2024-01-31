package com.example.aplikasimember;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView tvResetPass, tvNewAcc;
    private Button btnLogin;

    private EditText etNoHp, etPassword;

    private String NoHp = "12345";
    private String password = "admin";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNoHp = findViewById(R.id.etNoHp);
        etPassword = findViewById(R.id.etPassword);
        tvResetPass = findViewById(R.id.tvResetPass);
        btnLogin = findViewById(R.id.btnLogin);
        tvNewAcc = findViewById(R.id.tvNewAcc);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNoHp.getText().toString().equalsIgnoreCase(NoHp) && etPassword.getText().toString().equalsIgnoreCase(password)) {
                    Intent login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(login);

                    Toast.makeText(LoginActivity.this, "LOGIN BERHASIL!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "No HP atau Password Yang Anda Masukkan Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        tvResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });


    }
}

