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

    EditText etInputNamaBarang, etInputKodeBarang;
    Button btUploadBarang, btSimpanInput, btDeleteInput, btViewInput;
    ImageView ivGambarBarangInput;

    String path;

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Uri data = result.getData().getData();
                    ivGambarBarangInput.setImageURI(data);
                    path = getRealPath(UploadBarangActivity.this, data);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_barang);

        etInputKodeBarang = findViewById(R.id.editTextMasukkanKode);
        etInputNamaBarang = findViewById(R.id.editTextMasukkanNama);
        ivGambarBarangInput = findViewById(R.id.imageViewInputBarang);

        btUploadBarang = findViewById(R.id.buttonUploadBarangBaru);
        btSimpanInput = findViewById(R.id.buttonSimpanInput);
        btDeleteInput = findViewById(R.id.buttonDeleteInput);
        btViewInput = findViewById(R.id.buttonViewInput);

        btUploadBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        btSimpanInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAlert("insert");
            }
        });

        btDeleteInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAlert("delete");
            }
        });

        btViewInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadBarangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void chooseImage() {
        String myPath = Environment.getExternalStorageDirectory() + "/" + "Pictures" + "/";
        Uri uri = Uri.parse(myPath);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(uri, "image/*");
        activityResultLauncher.launch(intent);
    }

    private String getRealPath(Activity context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] data_media_uri = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, data_media_uri, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void showDialogAlert(String Mode) {
        int buttonpic = -1;
        String title = "", message = "";
        switch (Mode) {
            case "insert":
                title = "Do you sure save data?";
                message = "Click yes to save data";
                buttonpic = R.drawable.save_icon;
                break;
            case "delete":
                title = "Do you sure delete data?";
                message = "Click yes to delete data";
                buttonpic = R.drawable.delete_icon;
                break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setIcon(buttonpic)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Add logic for saving or deleting data based on the mode
                        if (Mode.equals("insert")) {
                            saveData();
                        } else if (Mode.equals("delete")) {
                            deleteData();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Do nothing or add logic as needed
                    }
                })
                .show();
    }

    private void saveData() {
        // Add logic to save data to your database or perform other actions
        Toast.makeText(UploadBarangActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    private void deleteData() {
        // Add logic to delete data from your database or perform other actions
        Toast.makeText(UploadBarangActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    private void clearFields() {
        // Clear input fields and image view
        etInputKodeBarang.setText("");
        etInputNamaBarang.setText("");
        ivGambarBarangInput.setImageResource(R.drawable.ic_launcher_background);
        path = "";
    }
}