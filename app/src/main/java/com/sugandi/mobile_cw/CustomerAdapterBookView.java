package com.sugandi.mobile_cw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapterBookView extends RecyclerView.Adapter<CustomerAdapterBookView.MyViewHolder> {

    private Context context;
    private ArrayList B_id, B_name, B_quantity, B_price;

    CustomerAdapterBookView(Context context, ArrayList B_id, ArrayList B_name, ArrayList B_quantity, ArrayList B_price){
        this.context = context;
        this.B_id = B_id;
        this.B_name = B_name;
        this.B_quantity = B_quantity;
        this.B_price = B_price;
    }

    @NonNull
    @Override
    public CustomerAdapterBookView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_book_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapterBookView.MyViewHolder holder, int position) {
        holder.txt_Bid.setText(String.valueOf(B_id.get(position)));
        holder.txt_Bname.setText(String.valueOf(B_name.get(position)));
        holder.txt_Bquantity.setText(String.valueOf(B_quantity.get(position)));
        holder.txt_Bprice.setText(String.valueOf(B_price.get(position)));
    }

    @Override
    public int getItemCount() {

        return B_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_Bid, txt_Bname, txt_Bquantity, txt_Bprice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_Bid = itemView.findViewById(R.id.txtB_id);
            txt_Bname = itemView.findViewById(R.id.txtBname);
            txt_Bquantity = itemView.findViewById(R.id.txtPrice);
            txt_Bprice = itemView.findViewById(R.id.txtQuantity);
        }
    }
}
