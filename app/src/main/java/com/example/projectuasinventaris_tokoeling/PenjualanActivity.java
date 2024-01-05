package com.example.projectuasinventaris_tokoeling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PenjualanActivity extends AppCompatActivity {

    EditText etKodeBarang, etNamaBarang, etHargaBarang;
    Button btCari, btSimpan;
    Spinner spStatusBarang;
    ImageView ivGambarBarangOutput;

    // Dummy data for Spinner
    private final List<String> statusList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);

        etKodeBarang = findViewById(R.id.editTextMasukkanKodeBarang);
        etNamaBarang = findViewById(R.id.editTextOutputNamaBarang);
        etHargaBarang = findViewById(R.id.editTextOutputHargaBarang);
        btCari = findViewById(R.id.buttonCariBarang);
        btSimpan = findViewById(R.id.buttonSimpanStatus);
        spStatusBarang = findViewById(R.id.spinnerStatusPenjualan);
        ivGambarBarangOutput = findViewById(R.id.imageViewOutputBarang);


    }
}