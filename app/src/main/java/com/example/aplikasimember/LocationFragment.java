package com.example.aplikasimember;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LocationFragment extends Fragment {

    private ArrayList<Location> locationArrayList;
    private String[] locationCabang;
    private String[] locationDesc;
    private int[] imageResourceID;
    private RecyclerView recyclerview;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter(getContext(), locationArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        locationArrayList = new ArrayList<>();

        locationCabang = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),
                getString(R.string.head_7),
                getString(R.string.head_8),
                getString(R.string.head_8),
                getString(R.string.head_8),
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),

        };

        locationDesc = new String[]{
                getString(R.string.desc_a),
                getString(R.string.desc_b),
                getString(R.string.desc_c),
                getString(R.string.desc_d),
                getString(R.string.desc_e),
                getString(R.string.desc_f),
                getString(R.string.desc_g),
                getString(R.string.desc_h),
                getString(R.string.desc_h),
                getString(R.string.desc_h),
                getString(R.string.desc_f),
                getString(R.string.desc_g),
                getString(R.string.desc_h),
                getString(R.string.desc_h),
                getString(R.string.desc_h),
        };

        imageResourceID = new int[]{

                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,
                R.drawable.location2,

        };

        for (int i =0; i< locationCabang.length; i++){

            Location location = new Location(locationCabang[i], locationDesc[i], imageResourceID[i] );
            locationArrayList.add(location);
        }

    }
}