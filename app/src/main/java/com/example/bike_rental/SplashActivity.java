package com.example.bike_rental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Thread td =new Thread(){
            public void run(){
                try{
                    sleep(5000);

                }catch (Exception ex){
                    ex.printStackTrace();

                }
                finally {
                    Intent intent =new Intent(SplashActivity.this,DashBoard.class);
                    startActivity(intent);
                    finish();

                }
            }

        };td.start();
    }
}