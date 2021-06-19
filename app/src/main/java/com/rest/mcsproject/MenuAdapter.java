package com.rest.mcsproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Menu> menuList;


    public MenuAdapter(Context ctx, ArrayList<Menu> menuList){
        this.ctx = ctx;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.listfood, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String foodName, fileName;
        int foodPrice, imageId;

        Menu menu = menuList.get(position);

        foodName = menu.getFoodName();
        foodPrice = menu.getFoodPrice();
        fileName = menu.getFileName();

        imageId = getImageId(ctx, fileName);

        holder.foodName.setText(foodName);
        holder.foodPrice.setText("Rp. " + foodPrice);
        holder.fileName.setImageResource(imageId);
    }

    public static int getImageId(Context ctx, String imageName) {
        return ctx.getResources().getIdentifier("drawable/" + imageName, null, ctx.getPackageName());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodName, foodPrice;
        ImageView fileName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.tv_foodName);
            foodPrice = itemView.findViewById(R.id.tv_foodPrice);
            fileName = itemView.findViewById(R.id.foodImage);

        }
    }
}
