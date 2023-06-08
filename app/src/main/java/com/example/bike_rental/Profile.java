package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    private ImageView profile_back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();

        profile_back_btn = findViewById(R.id.profile_back);
        profile_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent back = new Intent(Profile.this,DashBoard.class);
//                startActivity(back);
                onBackPressed();
            }
        });

        findViewById(R.id.update_Profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this,Update_Profile.class));
            }
        });
    }
}