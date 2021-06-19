package com.rest.mcsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Food extends AppCompatActivity {
    //  back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    RecyclerView rv_recFood, rv_allFood;

    TextView tv_allfood;
    MenuAdapter adapter, adapterRec;

    String foodCategory;
    ArrayList<Menu> menuArrayList, recMenuList;
    MenuDB menuDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //  back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        foodCategory = intent.getStringExtra("clicked");

        tv_allfood = findViewById(R.id.tv_allfood);
        tv_allfood.setText("All " + foodCategory);

        rv_recFood = findViewById(R.id.rv_recFood);
        rv_allFood = findViewById(R.id.rv_allFood);

        menuDB = new MenuDB(this);

        getData();


    }

    public void getData() {
        menuArrayList = menuDB.getAllMenuList(foodCategory);
        recMenuList = menuDB.getRecMenuList(foodCategory, "yes");
        if(menuArrayList.isEmpty() || recMenuList.isEmpty()) {
            insertMenu();
            menuArrayList = menuDB.getAllMenuList(foodCategory);
            recMenuList = menuDB.getRecMenuList(foodCategory, "yes");
        }

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        LinearLayoutManager llManager2 = new LinearLayoutManager(this);

        rv_allFood.setLayoutManager(llManager);
        adapter = new MenuAdapter(this, menuArrayList);
        rv_allFood.setAdapter(adapter);

        rv_recFood.setLayoutManager(llManager2);
        adapterRec = new MenuAdapter(this, recMenuList);
        rv_recFood.setAdapter(adapterRec);
    }

    public void insertMenu() {
        Menu menu = new Menu();

        menu.foodName = "Sate";
        menu.foodPrice = 30000;
        menu.fileName = "sate";
        menu.foodCategory = "Food";
        menu.recommendation = "yes";
        menuDB.insertMenu(menu);

        menu.foodName = "Spaghetti";
        menu.foodPrice = 50000;
        menu.fileName = "spaghetti";
        menu.foodCategory = "Food";
        menu.recommendation = "yes";
        menuDB.insertMenu(menu);

        menu.foodName = "Orange Chicken";
        menu.foodPrice = 35000;
        menu.fileName = "orange_chicken";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Lasagna";
        menu.foodPrice = 60000;
        menu.fileName = "lasagna";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Capcay";
        menu.foodPrice = 36000;
        menu.fileName = "capcay";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Nasi Goreng";
        menu.foodPrice = 39000;
        menu.fileName = "nasi_goreng";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Fish and Chips";
        menu.foodPrice = 39000;
        menu.fileName = "fish_and_chips";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Steak";
        menu.foodPrice = 65000;
        menu.fileName = "steak";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Hamburger";
        menu.foodPrice = 28000;
        menu.fileName = "hamburger";
        menu.foodCategory = "Food";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Caramel Macchiato";
        menu.foodPrice = 29000;
        menu.fileName = "caramel_macchiato";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Chocolate Milkshake";
        menu.foodPrice = 25000;
        menu.fileName = "chocolate_milkshake";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Espresso";
        menu.foodPrice = 20000;
        menu.fileName = "espresso";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Avocado Juice";
        menu.foodPrice = 27000;
        menu.fileName = "avocado_juice";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Matcha";
        menu.foodPrice = 29000;
        menu.fileName = "matcha";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Orange Juice";
        menu.foodPrice = 25000;
        menu.fileName = "orange_juice";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Oreo Milkshake";
        menu.foodPrice = 30000;
        menu.fileName = "oreo_milkshake";
        menu.foodCategory = "Drink";
        menu.recommendation = "yes";
        menuDB.insertMenu(menu);

        menu.foodName = "Root Beer Float";
        menu.foodPrice = 36000;
        menu.fileName = "root_beer_float";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Taro Milkshake";
        menu.foodPrice = 25000;
        menu.fileName = "taro_milkshake";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Thai Tea";
        menu.foodPrice = 22000;
        menu.fileName = "thai_tea";
        menu.foodCategory = "Drink";
        menu.recommendation = "no";
        menuDB.insertMenu(menu);

        menu.foodName = "Virgin Mojito";
        menu.foodPrice = 31000;
        menu.fileName = "virgin_mojito";
        menu.foodCategory = "Drink";
        menu.recommendation = "yes";
        menuDB.insertMenu(menu);
    }
}