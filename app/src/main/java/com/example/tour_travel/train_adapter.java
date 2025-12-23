package com.example.tour_travel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class train_adapter extends RecyclerView.Adapter<train_adapter.ViewHolder> {

    Context context;
    ArrayList<trainmodal> arrlist;

    public train_adapter(Context context, ArrayList<trainmodal> arrlist) {
        this.context = context;
        this.arrlist = arrlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ✅ Use a proper item layout (rename your XML file to item_train.xml)
        View view_train = LayoutInflater.from(context).inflate(R.layout.activity_train_recyler, parent, false);
        return new ViewHolder(view_train);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        trainmodal model = arrlist.get(position);

        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.depart.setText(model.getDepart());
        holder.arrival.setText(model.getArrival());
        holder.tdepart.setText(model.getTdepart());
        holder.tarrival.setText(model.getTarrival());
        holder.available.setText(model.getAvailable());
        holder.coach.setText(model.getCoach());
        holder.time.setText(model.getTime());

        // ✅ Open confirmation screen on click
        holder.itemView.setOnClickListener(v -> {
            Intent OBJ = new Intent(context, confirm.class);
            context.startActivity(OBJ);
        });
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, time, price, coach, available, depart, arrival, tdepart, tarrival;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_train_name);
            price = itemView.findViewById(R.id.tv_price);
            arrival = itemView.findViewById(R.id.tv_arrival_time);
            coach = itemView.findViewById(R.id.tv_class);
            available = itemView.findViewById(R.id.tv_availability);
            depart = itemView.findViewById(R.id.tv_departure_time);
            time = itemView.findViewById(R.id.tv_duration);
            tdepart = itemView.findViewById(R.id.tv_departure_label);
            tarrival = itemView.findViewById(R.id.tv_arrival_label);
        }
    }
}
