package com.rest.mcsproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "TastealDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MENU = "Menu";
    public static final String FIELD_MENU_ID = "id";
    public static final String FIELD_MENU_NAME = "name";
    public static final String FIELD_MENU_PRICE = "price";
    public static final String FIELD_MENU_IMG = "image";
    public static final String FIELD_MENU_CAT = "category";
    public static final String FIELD_MENU_REC = "recommendation";

    private static final String CREATE_MENU = "CREATE TABLE IF NOT EXISTS " + TABLE_MENU + "(" +
            FIELD_MENU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_MENU_NAME + " TEXT NOT NULL, " +
            FIELD_MENU_PRICE + " INTEGER NOT NULL, " +
            FIELD_MENU_IMG + " TEXT NOT NULL, " +
            FIELD_MENU_CAT + " TEXT NOT NULL, " +
            FIELD_MENU_REC + " TEXT)";

    private static final String DROP_MENU = "DROP TABLE IF EXISTS " + TABLE_MENU;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_MENU);
        onCreate(db);
    }
}
