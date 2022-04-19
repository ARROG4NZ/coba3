package com.example.praktikum_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    menampung recyclerview
    private RecyclerView rec;
//    menampung contact yang dibuat dalam bentuk array list
    private ArrayList<contact_model> contact_list = new ArrayList<>();
    LinearLayout form = findViewById(R.id.add_form);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec =findViewById(R.id.recylcerview);
        rec.setHasFixedSize(true);
//        membuat contact dummy

    }

//    memunculkan form tambah contact
    public void Tambah(View view) {
        if(rec.getVisibility() == View.VISIBLE && form.getVisibility() == View.GONE){
            rec.setVisibility(View.GONE);
            form.setVisibility(View.VISIBLE);
        }
    }
// membuat contact baru
    public void Submit(View view) {
//        insialisasi recycler view adapter dan recycler view
        RecyclerView.Adapter rec_adap;
        EditText nama,nomor;
        ImageView image;
        image = findViewById(R.id.ad_image);
        nama = findViewById(R.id.ad_nama);
        nomor = findViewById(R.id.ad_nomor);
        contact_list.add(new contact_model(nama.getText().toString(),nomor.getText().toString()));
        rec_adap = new adapter_rec(this,contact_list);
        rec.setAdapter(rec_adap);
        rec.setVisibility(View.VISIBLE);
        form.setVisibility(View.GONE);
    }
}