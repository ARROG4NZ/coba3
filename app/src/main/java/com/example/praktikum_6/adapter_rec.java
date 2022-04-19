package com.example.praktikum_6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapter_rec extends RecyclerView.Adapter<adapter_rec.viewholder> {
    private ArrayList<contact_model> contact_item;
    //        MainActivity class
    Context context;

    static class viewholder extends  RecyclerView.ViewHolder{
        ImageView image;
        TextView nama, nomor,detail;
        Button btndel;


        public viewholder(View v){
            super(v);
            image = v.findViewById(R.id.image_user);
            nama = v.findViewById(R.id.name_user);
            detail = v.findViewById(R.id.detail);
            btndel = v.findViewById(R.id.del);

        }
    }
    public adapter_rec(Context context, ArrayList<contact_model> contact_item){
        this.contact_item = contact_item;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new viewholder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final contact_model contact =contact_item.get(position);
//        memasukan image dan nama kedalam layout item contact
        holder.image.setImageResource(contact.getImage());
        holder.nama.setText(contact.getNama());
//        tombol del dan detail
        holder.detail.setOnClickListener(v ->{
          Intent intent = new Intent(context, detail_contact.class);
          Bundle bundle =new Bundle();
//          mengirim nama, nomor, dan image ke class contact detail
          bundle.putString("kname",contact.getNama());
          bundle.putString("knomer", contact.getNomor());
            intent.putExtras(bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
        holder.btndel.setOnClickListener(v->{

        });


    }

    @Override
    public int getItemCount() {
        return contact_item.size();
    }

}
