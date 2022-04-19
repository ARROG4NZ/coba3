package com.example.praktikum_6;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detail_contact extends AppCompatActivity {
    private TextView nama,nomor;
    private ImageView image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        nama = findViewById(R.id.nama_detail);
        nomor = findViewById(R.id.nomor_detail);
        image =findViewById(R.id.image_detail);

        if(getIntent().getExtras() != null){
            Bundle bundle =getIntent().getExtras();
            String sname = bundle.getString("kname");
            String snomor = bundle.getString("knomer");

            //mengisi nama, nomor dan gambar detail
            nama.setText(sname);
            nomor.setText(snomor);
        }
    }
}
