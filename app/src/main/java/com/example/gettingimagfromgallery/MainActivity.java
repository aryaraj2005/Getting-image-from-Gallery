package com.example.gettingimagfromgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   ImageView gimagview;
   Button gbtn;
private  final int GAL_REQUEST_CODE= 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gimagview = findViewById(R.id.GimageView);
        gbtn = findViewById(R.id.Gbutton);
        gbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Gintent  = new Intent(Intent.ACTION_PICK);
                Gintent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Gintent , GAL_REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == GAL_REQUEST_CODE){
                // YHA DIE=RECT HUM GET KAR SKATE HAI YHA KISI CLASS KI REQUIRMENT NHI HAI YE DIRECT IMAGE DATA TYPW DEGA
                gimagview.setImageURI(data.getData());
            }
        }

    }
}