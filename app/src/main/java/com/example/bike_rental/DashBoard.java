package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DashBoard extends AppCompatActivity implements View.OnContextClickListener, View.OnClickListener {
    private CardView payment_cardview;
    private CardView nearest_cardview;
    private CardView premium_bikes_cardview;
    private CardView mileage_card_view;
    private CardView affordable_cardview;
    private CardView profile_cardview;
    private ImageView profile_Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getSupportActionBar().hide();
        payment_cardview=findViewById(R.id.payment_cardview);
        nearest_cardview=findViewById(R.id.nearest_cardview);
        premium_bikes_cardview=findViewById(R.id.premium_bikes_cardview);
        mileage_card_view= findViewById(R.id.mileage_card_view);
        affordable_cardview=findViewById(R.id.affordable_cardview);
        profile_cardview = findViewById(R.id.profile);
        profile_Image = findViewById(R.id.profile_pic);

        payment_cardview.setOnClickListener(this);
        nearest_cardview.setOnClickListener(this);
        premium_bikes_cardview.setOnClickListener(this);
        mileage_card_view.setOnClickListener(this);
        affordable_cardview.setOnClickListener(this);
        profile_cardview.setOnClickListener(this);
        profile_Image.setOnClickListener(this);
    }

    @Override
    public boolean onContextClick(View view) {
        return false;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.payment_cardview:
                    i=new Intent(this, Payments.class);
            startActivity(i);
            break;

            case R.id.nearest_cardview:
                i=new Intent(this, Renting_Activity.class);
                // sending rentype to Renting_activity
                i.putExtra("rentType","Nearest Bikes");
                startActivity(i);
            break;
            case R.id.premium_bikes_cardview:
                i=new Intent(this, Renting_Activity.class);
                //sending rentype to Renting_activity
                i.putExtra("rentType", "Super Bikes");
                startActivity(i);
                break;
            case R.id.mileage_card_view:
                i=new Intent(this, Renting_Activity.class);
                //sending rentype to Renting_activity
                i.putExtra("rentType", "Best Mileage");
                startActivity(i);
                break;
            case R.id.affordable_cardview:
                i=new Intent(this, Renting_Activity.class);
                //sending rentype to Renting_activity
                i.putExtra("rentType", "Affordable Bikes");
                startActivity(i);
                break;

            case R.id.profile :
            case R.id.profile_pic:
                i=new Intent(this, Profile.class);
                startActivity(i);
                break;

            default:break;
        }
    }
}