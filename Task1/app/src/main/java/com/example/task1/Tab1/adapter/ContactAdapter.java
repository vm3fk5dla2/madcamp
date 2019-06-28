package com.example.task1.Tab1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task1.R;
import com.example.task1.Tab1.model.ContactList;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<ContactList> items = new ArrayList<>();

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ContactList item = items.get(position);

        Glide.with(viewHolder.itemView.getContext()).load(item.getUrl()).into(viewHolder.Picture);

        viewHolder.Name.setText(item.getName());
        viewHolder.Phone_number.setText(item.getPhone_number());
        viewHolder.Address.setText(item.getAddress());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<ContactList> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Picture;
        TextView Name, Phone_number, Address;

        ViewHolder(View itemView) {
            super(itemView);

            Picture = itemView.findViewById(R.id.list_item_picture);

            Name= itemView.findViewById(R.id.list_item_name);
            Phone_number = itemView.findViewById(R.id.list_item_number);
            Address = itemView.findViewById(R.id.list_item_address);
        }
    }
}