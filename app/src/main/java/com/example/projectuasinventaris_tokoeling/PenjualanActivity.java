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

    EditText etKodeBarang, etNamaBarang;
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
        btCari = findViewById(R.id.buttonCariBarang);
        btSimpan = findViewById(R.id.buttonSimpanStatus);
        spStatusBarang = findViewById(R.id.spinnerStatusPenjualan);
        ivGambarBarangOutput = findViewById(R.id.imageViewOutputBarang);

        // Set up Spinner with dummy data
        statusList.add("Sudah Dijual");
        statusList.add("Belum Dijual");
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, statusList);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStatusBarang.setAdapter(statusAdapter);

        btCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kodeBarang = etKodeBarang.getText().toString().trim();
                Barang barang = searchBarang(kodeBarang);

                if (barang != null) {
                    etNamaBarang.setText(barang.getNama());
                    spStatusBarang.setSelection(statusList.indexOf(barang.getStatus()));
                } else {
                    Toast.makeText(PenjualanActivity.this, "Barang not found with code: " + kodeBarang, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement your logic for saving data
                String kodeBarang = etKodeBarang.getText().toString().trim();
                String namaBarang = etNamaBarang.getText().toString().trim();
                String statusBarang = spStatusBarang.getSelectedItem().toString();
                String imagePath = "path/to/image";  // Ganti ini dengan path gambar yang sesuai

                // Tambahkan data ke Intent
                Intent intent = new Intent(PenjualanActivity.this, ListViewActivity.class);
                intent.putExtra("kodeBarang", kodeBarang);
                intent.putExtra("namaBarang", namaBarang);
                intent.putExtra("statusBarang", statusBarang);
                intent.putExtra("imagePath", imagePath);
                startActivity(intent);
            }
        });
    }

    // Example method to search for Barang by code
    private Barang searchBarang(String kodeBarang) {
        // Replace this with your actual search logic in the database or wherever you store your data
        // Return a Barang object if found, or null if not found
        // Dummy implementation
        return new Barang(kodeBarang, "Dummy Barang", statusList.get(0), "imagePath");
    }

    // Example method to save Barang data
    private boolean saveBarang(Barang barang) {
        // Replace this with your actual save logic to the database or wherever you store your data
        // Return true if saved successfully, false otherwise
        // Dummy implementation
        return true;
    }
}