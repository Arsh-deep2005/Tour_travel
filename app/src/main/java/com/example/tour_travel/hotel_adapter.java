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

public class hotel_adapter extends RecyclerView.Adapter<hotel_adapter.ViewHolder> {

    Context context;
    ArrayList<hotelmodal> arrayList;

    public hotel_adapter(Context context, ArrayList<hotelmodal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public hotel_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.activity_hotel_recyler,parent,false);
        ViewHolder view2 = new ViewHolder(view1);
        return  view2;


    }

    @Override
    public void onBindViewHolder(@NonNull hotel_adapter.ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).name);
        holder.price.setText(arrayList.get(position).price);
        holder.checkin.setText(arrayList.get(position).checkin);
        holder.checkout.setText(arrayList.get(position).checkout);
        holder.type.setText(arrayList.get(position).type);
        holder.avaliable.setText(arrayList.get(position).avaliable);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(holder.itemView.getContext(), confirmh.class);
                holder.itemView.getContext().startActivity(obj);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , checkin , checkout ,type , avaliable , price ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name  =  itemView.findViewById(R.id.hotelName);
            checkin  =  itemView.findViewById(R.id.hotelCheckinLabel);
            checkout  =  itemView.findViewById(R.id.hotelCheckoutLabel);
            type  =  itemView.findViewById(R.id.hotelRoomClass);
            avaliable  =  itemView.findViewById(R.id.hotelAvailability);
            price   =  itemView.findViewById(R.id.hotelPrice);







        }
    }
}