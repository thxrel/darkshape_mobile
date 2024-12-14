package com.example.proekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Имя базы данных
    private static final String DATABASE_NAME = "UserDatabase.db";

    // Версия базы данных
    private static final int DATABASE_VERSION = 1;

    // Имя таблицы
    private static final String TABLE_NAME = "users";

    // Поля таблицы
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";

    // SQL-запрос для создания таблицы
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_LOGIN + " TEXT NOT NULL, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создание таблицы
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Удаление старой таблицы и создание новой
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Метод для добавления пользователя
    public long addUser(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN, login);
        values.put(COLUMN_PASSWORD, password);

        // Вставка данных в таблицу
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    // Метод для проверки логина и пароля
    public boolean checkUser(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_LOGIN + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {login, password};

        // Выполнение запроса
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
}