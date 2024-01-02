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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Location> locationArrayList;
    private String[] locationHeading;
    private String[] locationDesc;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    public LocationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationFragment newInstance(String param1, String param2) {
        LocationFragment fragment = new LocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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

        locationHeading = new String[]{
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

        for (int i =0; i< locationHeading.length; i++){

            Location location = new Location(locationHeading[i], locationDesc[i], imageResourceID[i] );
            locationArrayList.add(location);
        }

    }
}