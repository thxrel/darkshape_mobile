package com.example.proekt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextLogin, editTextPassword;
    private Button buttonRegister;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Инициализация базы данных
        databaseHelper = new DatabaseHelper(this);

        // Найти элементы интерфейса
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonLogin);

        // Установить слушатель на кнопку "Зарегистрировать"
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();

                // Добавление пользователя в базу данных
                long id = databaseHelper.addUser(login, password);
                if (id > 0) {
                    Toast.makeText(LoginActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}