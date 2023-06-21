package com.example.bike_rental.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bike_rental.Interfaces.RentingRecyclerViewInterface;
import com.example.bike_rental.R;
import com.example.bike_rental.data_class.RentVehicleData;

import java.util.ArrayList;

public class RentVehicleListAdapter extends RecyclerView.Adapter<RentVehicleListAdapter.MyViewHolder>{

    private RentingRecyclerViewInterface rentingRecyclerViewInterface;

    Context context;
    ArrayList<RentVehicleData> list;

    public RentVehicleListAdapter(Context context, ArrayList<RentVehicleData> list , RentingRecyclerViewInterface rentingRecyclerViewInterface) {
        this.context = context;
        this.list = list;
        this.rentingRecyclerViewInterface = rentingRecyclerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.renting_recyclerview_item,parent,false);
        return new RentVehicleListAdapter.MyViewHolder(v,rentingRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            RentVehicleData rentVehicleData=list.get(position);

            holder.vehicle.setText(rentVehicleData.getVehicle());
            holder.mileage.setText(rentVehicleData.getMileage());
            holder.location.setText(rentVehicleData.getLocation());
            holder.price.setText(rentVehicleData.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vehicle, mileage, location, price;
        public MyViewHolder(@NonNull View itemView , RentingRecyclerViewInterface rentingRecyclerViewInterface) {
            super(itemView);

            vehicle=itemView.findViewById(R.id.rent_vehicle_name);
            mileage=itemView.findViewById(R.id.rent_vehicle_mileage);
            location=itemView.findViewById(R.id.rent_vehicle_location);
            price=itemView.findViewById(R.id.rent_vehicle_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rentingRecyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION)
                        {
                            rentingRecyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
