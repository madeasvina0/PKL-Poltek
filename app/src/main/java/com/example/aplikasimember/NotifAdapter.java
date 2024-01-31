package com.example.aplikasimember;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessControlContext;
import java.util.ArrayList;

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.MyViewHolder> {

    Context context;
    ArrayList<Notification> notificationArrayList;

    public NotifAdapter(Context context, ArrayList<Notification> notificationArrayList) {

        this.context = context;
        this.notificationArrayList = notificationArrayList;



    }

    @NonNull
    @Override
    public NotifAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_notif, parent, false);
        return new NotifAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifAdapter.MyViewHolder holder, int position) {

        Notification notification = notificationArrayList.get(position);
        holder.txtHeading.setText(""+notification.heading);
        holder.txtTgl.setText(""+notification.tgl);
        holder.txtDesc.setText(""+notification.desc);

        //handling click
        holder.cvNotification.setOnClickListener(view -> {
            //pindah ke activity product detail
            Intent intent = new Intent(this.context, DetailLokasiActivity.class);
            intent.putExtra("notification_heading", notification.heading);
            intent.putExtra("notification_tgl", notification.tgl);
            intent.putExtra("notification_desc", notification.desc);
            this.context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return notificationArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtHeading;
        TextView txtTgl;
        TextView txtDesc;
        CardView cvNotification;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //inisialisasi adapter ke view
            txtHeading = itemView.findViewById(R.id.txtHeading);
            txtTgl = itemView.findViewById(R.id.txtTgl);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            cvNotification = itemView.findViewById(R.id.cvNotification);
        }
    }
}
