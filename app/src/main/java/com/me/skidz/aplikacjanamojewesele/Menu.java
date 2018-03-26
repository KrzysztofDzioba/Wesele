package com.me.skidz.aplikacjanamojewesele;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private Button butZdjWeselne;
    private Button butPrzejrzyjPlan;
    private Button butQuiz;
    private ImageView zrobioneFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        butZdjWeselne = findViewById(R.id.butZdjWeselne);
        butPrzejrzyjPlan = findViewById(R.id.butPrzejrzyjPlan);
        butQuiz = findViewById(R.id.butQuiz);
        zrobioneFoto = findViewById(R.id.zrobioneFoto);
        setOnClicks();



    }

    private void setOnClicks() {
        butZdjWeselne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Zaraz zrobimy tu sobie zdjęcie weselne :)",
//                                                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
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
                Toast.makeText(getApplicationContext(), "Rozwiązujemy quiz! :)",
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        zrobioneFoto.setImageBitmap(bitmap);
    }

}
