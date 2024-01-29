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

public class HistoryFragment extends Fragment {

    private ArrayList<History> historyArrayList;
    private String[] historyNames;
    private Double[] historyNormalPrices;
    private Double[] historyMemberPrices;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerview.setHasFixedSize(true);
        HistoryAdapter HistoryAdapter = new HistoryAdapter(getContext(), historyArrayList);
        recyclerview.setAdapter(HistoryAdapter);
        HistoryAdapter.notifyDataSetChanged();


}

    private void dataInitialize() {

        historyArrayList = new ArrayList<>();

        historyNames = new String[]{
                "Apel A",
                "Apel B",
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

        historyNormalPrices = new Double[]{
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00,
                30000.00
        };


        historyMemberPrices = new Double[]{
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00,
                15000.00
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

        for (int i = 0; i < historyNames.length; i++) {

            History history = new History(historyNames[i], historyMemberPrices[i], historyNormalPrices[i], imageResourceID[i]);
            historyArrayList.add(history);
        }

    }

    }
