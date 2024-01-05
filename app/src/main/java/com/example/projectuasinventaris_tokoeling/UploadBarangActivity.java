package com.example.projectuasinventaris_tokoeling;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadBarangActivity extends AppCompatActivity {

    EditText etInputNamaBarang, etInputKodeBarang, etInputHargaBarang;
    Button btUploadBarang, btSimpanInput, btDeleteInput, btViewInput;
    ImageView ivGambarBarangInput;

    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_barang);

        etInputKodeBarang = findViewById(R.id.editTextMasukkanKode);
        etInputNamaBarang = findViewById(R.id.editTextMasukkanNama);
        etInputHargaBarang = findViewById(R.id.editTextMasukkanHargaBarang);
        ivGambarBarangInput = findViewById(R.id.imageViewInputBarang);

        btUploadBarang = findViewById(R.id.buttonUploadBarangBaru);
        btSimpanInput = findViewById(R.id.buttonSimpanInput);
        btDeleteInput = findViewById(R.id.buttonDeleteInput);
        btViewInput = findViewById(R.id.buttonViewInput);

    }
}