package com.ccu.skintears.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ccu.skintears.BuildConfig;
import com.ccu.skintears.R;
import com.ccu.skintears.activities.reconocimiento.SubirImagenActivity;

import java.io.File;

public class ReconocimientoActivity extends AppCompatActivity {
    private static final int TAKE_PICTURE = 0;
    Uri mUri;
    Bitmap mPhoto;

    private Button activityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconocimiento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        activityButton = (Button) findViewById(R.id.btn_subir_foto_rec);

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ReconocimientoActivity.this, SubirImagenActivity.class);
                startActivity(intent);
            }
        });
    }


    public void sacarFoto(View view) {
        if (view.getId() == R.id.btn_foto_rec &&
                getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

            // Desde Android 5.1 el método recomendado para acceder a los archivos es utilizando
            // un FileProvider (que es una subclase de ContentProvider)
            // antiguamente se accedía directamente a través de la uri file:// pero ahora es
            // a través de content://
            Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
            // Antes era File f = new File(Environment.getExternalStorageDirectory(),  "foto.jpg");
            File f = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "foto.jpg");

            // Antes era mUri = Uri.fromFile(f); // Ej: file://sdcard/foto.jpg
            mUri = FileProvider.getUriForFile(ReconocimientoActivity.this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    f);

            i.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
            startActivityForResult(i, TAKE_PICTURE);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        //Cargamos la imagen guardada en la memoria SD en nuestro ImageView
                        mPhoto = android.provider.MediaStore.Images.Media.getBitmap(
                                getContentResolver(), mUri);
                        ((ImageView) findViewById(R.id.img_foto)).setImageBitmap(mPhoto);
                    } catch (Exception e) {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("HolaCamara", e.getMessage());
                    }
                }
        }
    }

}
