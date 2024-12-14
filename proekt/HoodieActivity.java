package com.example.proekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HoodieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoodie);

        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HoodieActivity.this, MainActivity.class);
                startActivity(intent); // Запустить MainActivity
            }
        });
        Button buttonOformlyat = findViewById(R.id.buttonOformlyat);


        buttonOformlyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HoodieActivity.this, OformlyatActivity.class);
                startActivity(intent);
            }
        });
    }
}