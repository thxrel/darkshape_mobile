package com.example.proekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OformlyatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oformlyat);
        Button buttonOformlyat = findViewById(R.id.buttonOformlyat);

        buttonOformlyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OformlyatActivity.this, PaymentActivity.class);
                startActivity(intent); // Запустить PaymentActivity
            }
        });
    }
}


