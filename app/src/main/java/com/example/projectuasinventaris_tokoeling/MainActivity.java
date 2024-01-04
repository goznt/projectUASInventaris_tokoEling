package com.example.projectuasinventaris_tokoeling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btUploadBarang, btStatusPenjualan, btDaftarBarang, btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btUploadBarang = findViewById(R.id.buttonUploadBarang);
        btStatusPenjualan = findViewById(R.id.buttonPenjualanBarang);
        btDaftarBarang = findViewById(R.id.buttonListViewBarang);
        btExit = findViewById(R.id.buttonExit);

        btUploadBarang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UploadBarangActivity.class);
            startActivity(intent);
        });

        btStatusPenjualan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PenjualanActivity.class);
            startActivity(intent);
        });

        btDaftarBarang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        btExit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });



    }
}