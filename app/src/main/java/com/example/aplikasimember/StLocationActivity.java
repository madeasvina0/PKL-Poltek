package com.example.aplikasimember;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StLocationActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_location);
        replaceFragment(new LocationFragment());

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frame_layout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.bottom_home) {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.bottom_discount) {
                    loadFragment(new PromoFragment(), false);

                } else if (itemId == R.id.bottom_location) {
                    loadFragment(new LocationFragment(), true);

                } else if (itemId == R.id.bottom_history) {
                    loadFragment(new HistoryFragment(), false);

                } else { //bottom profile
                    loadFragment(new ProfileFragment(), false);


                }

                return true;
            }
        });
        loadFragment(new LocationFragment(), true);

    }


    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frame_layout, fragment);

        } else {
            fragmentTransaction.replace(R.id.frame_layout, fragment);
        }

        fragmentTransaction.commit();
    }



    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}