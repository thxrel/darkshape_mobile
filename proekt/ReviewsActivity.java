package com.example.proekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity extends AppCompatActivity {

    private EditText editTextReview;
    private Button buttonSubmitReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ReviewsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        editTextReview = findViewById(R.id.editTextReview);
        buttonSubmitReview = findViewById(R.id.buttonSubmitReview);

        buttonSubmitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reviewText = editTextReview.getText().toString().trim();

                if (reviewText.isEmpty()) {
                    Toast.makeText(ReviewsActivity.this, "Пожалуйста, введите отзыв", Toast.LENGTH_SHORT).show();
                } else {

                    saveReview(reviewText);

                    editTextReview.setText("");

                    Toast.makeText(ReviewsActivity.this, "Отзыв успешно отправлен", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveReview(String reviewText) {
        System.out.println("Отзыв: " + reviewText);
    }
}



