package com.example.aplikasimember;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PromoFragment extends Fragment {


    private ArrayList<Promo> promoArrayList;
    private String[] promoNames;
    private Double[] promoNormalPrices;
    private Double[] promoMemberPrices;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promo, container, false);
        return view;
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerview.setHasFixedSize(true);
        PromoAdapter PromoAdapter = new PromoAdapter(getContext(), promoArrayList);
        recyclerview.setAdapter(PromoAdapter);
        PromoAdapter.notifyDataSetChanged();


    }

    private void dataInitialize() {

        promoArrayList = new ArrayList<>();

        promoNames = new String[]{
                "Item A",
                "Item B",
                "Apel C",
                "Apel D",
                "Apel E",
                "Apel F",
                "Jeruk G",
                "Jeruk H",
                "Jeruk I",
                "Jeruk J",
                "Jeruk K",
                "Jeruk L",
        };

        promoNormalPrices = new Double[]{
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00,
                3000.00
        };


        promoMemberPrices = new Double[]{
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00,
                1500.00
        };


        imageResourceID = new int[]{

                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.orange,
                R.drawable.orange,
                R.drawable.orange,
                R.drawable.orange,
                R.drawable.orange,
                R.drawable.orange

        };

        for (int i = 0; i < promoNames.length; i++) {

            Promo promo = new Promo(promoNames[i], promoMemberPrices[i], promoNormalPrices[i], imageResourceID[i]);
            promoArrayList.add(promo);
        }

    }
}