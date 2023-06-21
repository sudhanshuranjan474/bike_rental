package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookingPanel extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_panel);

        findViewById(R.id.Booking_panel_back).setOnClickListener(view -> onBackPressed());
        textView = findViewById(R.id.sample_Txt);
        textView.setText(getIntent().getStringExtra("item"));
    }
}