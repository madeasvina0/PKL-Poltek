package com.example.aplikasimember;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    private ArrayList<Notification> notificationArrayList;
    private String[] notificationHeading;
    private String[] notificationTgl;
    private String[] notificationDesc;
    private RecyclerView recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        dataInitialize();

    }

    private void dataInitialize() {

        notificationArrayList = new ArrayList<>();

        notificationHeading = new String[]{
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

        notificationTgl = new String[]{
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

        notificationDesc = new String[]{

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

        for (int i =0; i< notificationHeading.length; i++){

            Notification notification = new Notification(notificationHeading[i], notificationTgl[i], notificationDesc[i] );
            notificationArrayList.add(notification);
        }

    }


}