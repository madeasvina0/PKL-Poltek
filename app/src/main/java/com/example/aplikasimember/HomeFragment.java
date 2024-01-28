package com.example.aplikasimember;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<Product> productArrayList;
    private String[] productNames;
    private Double[] productNormalPrices;
    private Double[] productMemberPrices;
    private int[] imageResourceID;
    private RecyclerView recyclerview;


    private ArrayList<Promo> promoArrayList;
    private String[]  promoNames;
    private Double[] promoHargaNormal;
    private Double[] promoHargaPromo;
    private int[] imgResourceID;
    private RecyclerView horizontalRv;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnFragment = (Button) view.findViewById(R.id.btnFragment1);


        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new PromoFragment());
                fr.commit();
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerview.setHasFixedSize(true);
        ProductAdapter ProductAdapter = new ProductAdapter(getContext(), productArrayList);
        recyclerview.setAdapter(ProductAdapter);
        ProductAdapter.notifyDataSetChanged();

        dataInitialized();

        horizontalRv = view.findViewById(R.id.horizontalRv);
        horizontalRv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        horizontalRv.setHasFixedSize(true);
        PromoAdapter PromoAdapter = new PromoAdapter(getContext(), promoArrayList);
        horizontalRv.setAdapter(PromoAdapter);
        PromoAdapter.notifyDataSetChanged();
    }


    private void dataInitialize() {

        productArrayList = new ArrayList<>();

        productNames = new String[]{
                "Item A",
                "Item B",
                "Item C",
                "Item D",
                "Item E",
                "Item F",
        };

        productNormalPrices = new Double[]{
                2000.00,
                2000.00,
                2000.00,
                2000.00,
                2000.00,
                2000.00
        };


        productMemberPrices = new Double[]{
                1000.00,
                1000.00,
                1000.00,
                1000.00,
                1000.00,
                1000.00
        };


        imageResourceID = new int[]{

                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple

        };

        for (int i = 0; i < productNames.length; i++) {

            Product product = new Product(productNames[i], productNormalPrices[i], productMemberPrices[i], imageResourceID[i]);
            productArrayList.add(product);
        }

    }


    private void dataInitialized() {

        promoArrayList = new ArrayList<>();

        promoNames = new String[]{
                "Apel A",
                "Apel B",
                "Apel C",
                "Apel D",
                "Apel E",
                "Apel F",
        };

        promoHargaNormal = new Double[]{
                20000.00,
                20000.00,
                20000.00,
                20000.00,
                20000.00,
                20000.00,
        };


        promoHargaPromo = new Double[]{
                10000.00,
                10000.00,
                10000.00,
                10000.00,
                10000.00,
                10000.00,
        };


        imgResourceID = new int[]{

                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,
                R.drawable.apple,

        };

        for (int a = 0; a < promoNames.length; a++) {

            Promo promo = new Promo(promoNames[a], promoHargaNormal[a], promoHargaPromo[a], imgResourceID[a]);
            promoArrayList.add(promo);
        }

    }

}
