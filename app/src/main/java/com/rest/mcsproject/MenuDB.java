package com.rest.mcsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MenuDB {
    private DBHelper dbHelper;

    public MenuDB(Context ctx) {
        dbHelper = new DBHelper(ctx);
    }

    public void insertMenu(Menu menu) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.FIELD_MENU_NAME, menu.foodName);
        cv.put(DBHelper.FIELD_MENU_PRICE, menu.foodPrice);
        cv.put(DBHelper.FIELD_MENU_IMG, menu.fileName);
        cv.put(DBHelper.FIELD_MENU_CAT, menu.foodCategory);
        cv.put(DBHelper.FIELD_MENU_REC, menu.recommendation);

        db.insert(DBHelper.TABLE_MENU, null, cv);
        db.close();
    }

    public ArrayList<Menu> getAllMenuList(String cat) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Menu> menuList = new ArrayList<>();

        Cursor cursor = db.query(DBHelper.TABLE_MENU, null, null, null, null, null, null);
        Menu menu = null;

        while(cursor.moveToNext()){
            int id, price;
            String name, image, category, recommendation;

            category = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_CAT));

            if(category.equals(cat)){
                id = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_MENU_ID));
                price = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_MENU_PRICE));
                name = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_NAME));
                image = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_IMG));
                recommendation = cursor.getString(cursor.getColumnIndex((DBHelper.FIELD_MENU_REC)));

                menu = new Menu(id, name, price, image, category, recommendation);
                menuList.add(menu);
            }
        }

        cursor.close();
        db.close();
        return menuList;
    }

    public ArrayList<Menu> getRecMenuList(String cat, String rec) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Menu> menuList = new ArrayList<>();

        Cursor cursor = db.query(DBHelper.TABLE_MENU, null, null, null, null, null, null);
        Menu menu = null;

        while(cursor.moveToNext()){
            int id, price;
            String name, image, category, recommendation;

            category = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_CAT));
            recommendation = cursor.getString(cursor.getColumnIndex((DBHelper.FIELD_MENU_REC)));

            if(category.equals(cat) && recommendation.equals(rec)){
                id = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_MENU_ID));
                price = cursor.getInt(cursor.getColumnIndex(DBHelper.FIELD_MENU_PRICE));
                name = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_NAME));
                image = cursor.getString(cursor.getColumnIndex(DBHelper.FIELD_MENU_IMG));

                menu = new Menu(id, name, price, image, category, recommendation);
                menuList.add(menu);
            }
        }

        cursor.close();
        db.close();
        return menuList;
    }
}
