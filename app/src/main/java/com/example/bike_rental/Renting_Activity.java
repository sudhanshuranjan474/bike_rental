package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bike_rental.Adapters.RentVehicleListAdapter;
import com.example.bike_rental.Adapters.TransactionListAdapter;
import com.example.bike_rental.Interfaces.RentingRecyclerViewInterface;
import com.example.bike_rental.data_class.RentVehicleData;

import java.util.ArrayList;
import java.util.Random;

public class Renting_Activity extends AppCompatActivity  implements RentingRecyclerViewInterface {



    RecyclerView recyclerView;
    RentVehicleListAdapter adapter;
    ArrayList<RentVehicleData> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renting);


        // taking data from dashboard activity
        Intent intent=getIntent();
        String rentType =intent.getStringExtra("rentType");
        TextView rentTypeText=findViewById(R.id.renting_type);
        rentTypeText.setText(rentType);

        //initializing recycler view
        recyclerView= findViewById(R.id.renting_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //setting Payment transaction RecyclerView Adapter

        // all the code from 44 to 81 line is for testing it will be delete in some time
        String[] localBikeNames = {"Hero Splendor", "Bajaj Pulsar", "TVS Apache", "Honda Activa", "Royal Enfield Bullet","TVS Apache"};
        String[] highMileageBikeNames = {"Bajaj Platina 110 H-Gear", "Hero Splendor iSmart", "TVS Radeon", "Honda Dream Yuga", "Suzuki Access 125"};
        String[] superBikeNames = {"Ducati Panigale V4", "Kawasaki Ninja H2R", "BMW S1000RR", "Yamaha YZF R1", "Honda CBR1000RR-R Fireblade"};
        String[] nearestBikeName = {"Hero Splendor", "Ducati Panigale V4", "TVS Apache", "Kawasaki Ninja H2R", "Bajaj Platina 110 H-Gear", "Honda Activa", "BMW S1000RR", "Suzuki Access 125", "Royal Enfield Classic 350"};

        if(rentType.equals("Nearest Bikes"))
        {
            adapter=new RentVehicleListAdapter(this,convertToList(nearestBikeName),this);
        }
        else if(rentType.equals("Super Bikes"))
        {
            adapter=new RentVehicleListAdapter(this,convertToList(superBikeNames),this);
        }
        else if(rentType.equals("Best Mileage")){
            adapter=new RentVehicleListAdapter(this,convertToList(highMileageBikeNames),this);
        }
        else{
            adapter=new RentVehicleListAdapter(this,convertToList(localBikeNames),this);
        }
        recyclerView.setAdapter(adapter);
    }
    private ArrayList<RentVehicleData> convertToList(String[] li)
    {
        Random random=new Random();

        for (String str:li)
        {
            RentVehicleData vehicleData=new RentVehicleData();
            int price=random.nextInt(401)+300;
            vehicleData.setVehicle(str);
            vehicleData.setPrice(price+" /Day");
            vehicleData.setLocation("Ratnagiri,Bhopal");
            vehicleData.setMileage("Petrol | 30km/l");
            list.add(vehicleData);

        }
        return list;
    }

    @Override
    public void onItemClick(int position) {
    Intent intent =new Intent(this,BookingPanel.class);
    intent.putExtra("item",list.get(position).getVehicle());
    startActivity(intent);
    }
}