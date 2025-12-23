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

public class adapter_flight extends RecyclerView.Adapter<adapter_flight.ViewHolder> {

    Context context ;
    ArrayList<flightmodal> arrlist;

    adapter_flight(Context context , ArrayList<flightmodal> arrlist){
        this.context = context;
        this.arrlist = arrlist;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_flight = LayoutInflater.from(context).inflate(R.layout.fligh_recyler,parent,false);
        ViewHolder view2 = new ViewHolder(view_flight);
        return view2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrlist.get(position).name);
        holder.price.setText(arrlist.get(position).price);
        holder.depart.setText(arrlist.get(position).depart);
        holder.arrival.setText(arrlist.get(position).arrival);
        holder.tdepart.setText(arrlist.get(position).tdepart);
        holder.tarrival.setText(arrlist.get(position).tarrival);
        holder.available.setText(arrlist.get(position).available);
        holder.coach.setText(arrlist.get(position).coach);
        holder.time.setText(arrlist.get(position).time);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(holder.itemView.getContext(), confirm.class);
                holder.itemView.getContext().startActivity(obj);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , time , price , coach , available ,depart , arrival , tdepart , tarrival;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_flight_name);
            price = itemView.findViewById(R.id.tv_flight_price);
            arrival = itemView.findViewById(R.id.tv_flight_arrival_time);
            coach = itemView.findViewById(R.id.tv_flight_class);
            available = itemView.findViewById(R.id.tv_flight_availability);
            depart = itemView.findViewById(R.id.tv_flight_departure_time);
            time = itemView.findViewById(R.id.tv_flight_duration);
            tdepart = itemView.findViewById(R.id.tv_flight_departure_label);
            tarrival = itemView.findViewById(R.id.tv_flight_arrival_label);
        }
    }
}