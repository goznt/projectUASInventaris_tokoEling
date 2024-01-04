package com.example.projectuasinventaris_tokoeling;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView myListViewActivity;
    private ArrayList<Barang> daftarBarang;
    private ArrayAdapter<Barang> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Inisialisasi ListView
        myListViewActivity = findViewById(R.id.myListViewActivity);

        // Inisialisasi daftarBarang
        daftarBarang = new ArrayList<>();

        // Dapatkan data yang disimpan dari PenjualanActivity (gantilah ini sesuai kebutuhan)
        // Contoh:
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String kodeBarang = extras.getString("kodeBarang");
            String namaBarang = extras.getString("namaBarang");
            String statusBarang = extras.getString("statusBarang");
            String imagePath = extras.getString("imagePath");

            // Buat objek Barang dari data yang diterima
            Barang barang = new Barang(kodeBarang, namaBarang, statusBarang, imagePath);

            // Tambahkan barang ke daftarBarang
            daftarBarang.add(barang);

            // Update daftar barang
            updateDaftarBarang();
        }

        // Inisialisasi ArrayAdapter
        adapter = new ArrayAdapter<>(this, R.layout.item_datalist_view, R.id.textViewNamaItemListView, daftarBarang);

        // Set Adapter to ListView
        myListViewActivity.setAdapter(adapter);

        // Set item click listener
        myListViewActivity.setOnItemClickListener((parent, view, position, id) -> {
            // Get selected Barang
            Barang selectedBarang = daftarBarang.get(position);

            // Example: Show Toast with selected Barang's details
            Toast.makeText(ListViewActivity.this, "Selected: " + selectedBarang.getNama(), Toast.LENGTH_SHORT).show();
        });
    }

    // Method untuk mengupdate daftar barang pada adapter
    private void updateDaftarBarang() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}