package com.example.user_interaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_reghasil extends AppCompatActivity {

    TextView textHasil;
    Button utama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reghasil);

        textHasil = findViewById(R.id.hasil_text);
        utama = findViewById(R.id.lanjut);

        utama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(activity_reghasil.this,MainActivity2.class);
                startActivity(pindah);
            }
        });
        Intent intent = getIntent();
        if (intent.hasExtra("NAMA")){
            String text=intent.getStringExtra("NAMA");
            textHasil.append("Selamat"+" "+text+ ", anda sudah Terdaftar dengan data:\n");
        }
        if (intent.hasExtra("USERNAME")){
            String text=intent.getStringExtra("USERNAME");
            textHasil.append("username " +text+": \n");
        }
        if (intent.hasExtra("NEGARA")){
            String text=intent.getStringExtra("NEGARA");
            textHasil.append("Asal Negara " +text+ ": \n");
        }
        if (intent.hasExtra("JK")){
            String text=intent.getStringExtra("JK");
            textHasil.append("Jenis Kelamin " +text+ ": \n");
        }

    }
}