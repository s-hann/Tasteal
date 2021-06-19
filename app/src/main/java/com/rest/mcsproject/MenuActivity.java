package com.rest.mcsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    //  back
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    Button btn_food, btn_drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //  back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btn_food = findViewById(R.id.btn_food);
        btn_drink = findViewById(R.id.btn_drink);

        btn_food.setOnClickListener(this);
        btn_drink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Food.class);

        if(v.getId() == R.id.btn_food) {
            intent.putExtra("clicked", "Food");
        }
        else if(v.getId() == R.id.btn_drink) {
            intent.putExtra("clicked", "Drink");
        }

        startActivity(intent);
    }
}