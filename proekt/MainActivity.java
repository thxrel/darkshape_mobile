package com.example.proekt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAbout = findViewById(R.id.buttonAbout);

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent); // Запустить RegisterActivity
            }
        });

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setBackgroundColor(Color.parseColor("#0D4579"));

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent); // Запустить RegisterActivity
            }
        });

        Button buttonLongsliv = findViewById(R.id.buttonLongsliv);

        buttonLongsliv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Button buttonReviews = findViewById(R.id.buttonReviews);
        buttonLogin.setBackgroundColor(Color.parseColor("#0D4579"));

        buttonReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ReviewsActivity.class);
                startActivity(intent);
            }
        });
        // Найти кнопку по ID
        Button buttonHoodie = findViewById(R.id.buttonHoodie);

        buttonHoodie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HoodieActivity.class);
                startActivity(intent); // Запустить HoodieActivity
            }
        });
        ImageView imageViewTelegram = findViewById(R.id.imageViewTelegram);

        imageViewTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTelegramChannel();
            }
        });
    }

    private void openTelegramChannel() {
        String telegramChannelUrl = "https://t.me/darksshape";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(telegramChannelUrl));

        if (isTelegramInstalled()) {
            intent.setPackage("org.telegram.messenger");
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            System.out.println("Starting intent to open Telegram channel");
            startActivity(intent);
        } else {
            System.out.println("No activity found to handle the intent");
            openChannelInBrowser(telegramChannelUrl);
        }
    }
    private boolean isTelegramInstalled() {
        try {
            getPackageManager().getPackageInfo("org.telegram.messenger", 0);
            System.out.println("Telegram is installed");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            System.out.println("Telegram is NOT installed");
            return false;
        }
    }
    private void openChannelInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            System.out.println("Starting intent to open channel in browser");
            startActivity(intent);
        } else {
            System.out.println("No activity found to handle the browser intent");
            copyLinkToClipboard(url);
            Toast.makeText(this, "Ссылка скопирована в буфер обмена", Toast.LENGTH_SHORT).show();
        }
    }
    private void copyLinkToClipboard(String link) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Telegram Channel Link", link);
        clipboard.setPrimaryClip(clip);
        }
    }
