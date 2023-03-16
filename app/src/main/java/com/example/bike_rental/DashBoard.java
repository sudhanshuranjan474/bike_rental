package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity implements View.OnContextClickListener, View.OnClickListener {
private CardView payment_cardview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getSupportActionBar().hide();
        payment_cardview=findViewById(R.id.payment_cardview);

payment_cardview.setOnClickListener(this);
    }

    @Override
    public boolean onContextClick(View view) {
        return false;
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId())
        {
            case R.id.payment_cardview:i=new Intent(this,Payments.class);startActivity(i);
            break;
            default:break;
        }
    }
}