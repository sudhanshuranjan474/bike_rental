package com.example.bike_rental.Adapters;

import android.accounts.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bike_rental.R;
import com.example.bike_rental.data_class.Transactions;

import java.util.ArrayList;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.MyViewHolder> {

//    variables
   private final Context context;
   private final ArrayList<Transactions> list;

   // constructor to initialize context and list
    public TransactionListAdapter(Context context, ArrayList<Transactions> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // setting the account_list_item
        View v = LayoutInflater.from(context).inflate(R.layout.accounts_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // taking data from data_class/Transaction and setting its values to accounts_list_item text views
        Transactions transactions = list.get(position);
        holder.vehicle.setText(transactions.getVehicle());
        holder.billingTime.setText(transactions.getBillingTime());
        holder.amount.setText(transactions.getAmount());
        holder.duration.setText(transactions.getBillingTime());
    }

    @Override
    public int getItemCount() {
        // returning size of items
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vehicle, billingTime, amount, duration;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        // initializing TextViews for accounts_list_item TextViews
        vehicle = itemView.findViewById(R.id.accounts_vehicle_name);
        billingTime = itemView.findViewById(R.id.accounts_billing_time);
        amount = itemView.findViewById(R.id.account_billing_price);
        duration = itemView.findViewById(R.id.account_billing_duration);

    }
}
}
