package com.example.bike_rental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.util.Log;

import com.example.bike_rental.Adapters.TransactionListAdapter;
import com.example.bike_rental.data_class.Transactions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Payments extends AppCompatActivity {

    //database reference variable
    DatabaseReference database;
    RecyclerView recyclerView;
    ArrayList<Transactions> list;
    TransactionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        getSupportActionBar().hide();

        //initializing recycler view
        recyclerView= findViewById(R.id.account_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //database reference variable initializing                     --- need to change
        database= FirebaseDatabase.getInstance().getReference("Transactions");

        list=new ArrayList<>();
//        TransactionListAdapter adapte initialization
        adapter=new TransactionListAdapter(this,list);

        //setting Payment transaction RecyclerView Adapter
        recyclerView.setAdapter(adapter);


//     fetching transaction data from firebase
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.getChildren())
                {
                    Transactions transactions = data.getValue(Transactions.class);
                    list.add(transactions);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}