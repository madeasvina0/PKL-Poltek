package com.example.aplikasimember;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.aplikasimember.databinding.ActivityMainBinding;
import com.google.android.filament.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView= findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.bottom_home) {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.bottom_discount) {
                    loadFragment(new PromoFragment(), false);

                } else if (itemId == R.id.bottom_location) {
                    loadFragment(new LocationFragment(), false);

                } else if (itemId == R.id.bottom_history) {
                    loadFragment(new HistoryFragment(), false);

                } else { //bottom profile
                    loadFragment(new ProfileFragment(), false);


                }

                return true;
            }
        });
        loadFragment(new HomeFragment(), true);

            }


    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (isAppInitialized) {
                    fragmentTransaction.add(R.id.frameLayout, fragment);

                } else {
                    fragmentTransaction.replace(R.id.frameLayout,fragment);
                }

                fragmentTransaction.commit();
            }


}