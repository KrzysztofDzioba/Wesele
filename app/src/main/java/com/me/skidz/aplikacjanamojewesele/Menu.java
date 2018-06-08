package com.me.skidz.aplikacjanamojewesele;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class Menu extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;

    private Button butZdjWeselne;
    private Button butPrzejrzyjPlan;
    private Button butQuiz;
    private ImageView zrobioneFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        verifyStoragePermissions(this);
        butZdjWeselne = findViewById(R.id.butZdjWeselne);
        butPrzejrzyjPlan = findViewById(R.id.butPrzejrzyjPlan);
        butQuiz = findViewById(R.id.butQuiz);
        zrobioneFoto = findViewById(R.id.zrobioneFoto);
        setOnClicks();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    private void setOnClicks() {
        butZdjWeselne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        butPrzejrzyjPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Wkrótce odbędzie się przeglądnięcie planu wesela :)",
                        Toast.LENGTH_LONG).show();
            }
        });

        butQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz();
            }
        });
    }

    private void openQuiz() {
        Intent intent = new Intent(this, QuizQuestion1.class);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            File imgFile = new  File(mCurrentPhotoPath);
            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                ImageView myImage = (ImageView) findViewById(R.id.zrobioneFoto);
                myImage.setImageBitmap(myBitmap);

            }
        }

    }

    private void createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String imageFileName = "Rokrzys_" + timeStamp + "_";
        File storageDir =  getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = storageDir.getAbsolutePath() + "/" + imageFileName;

        File file = new File(mCurrentPhotoPath);
        Uri outputFileUri = Uri.fromFile(file);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(cameraIntent, 1);
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
