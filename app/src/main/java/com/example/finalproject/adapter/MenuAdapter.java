package com.example.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.FoodViewHolder> {
    private Context context;
    private List<MenuItem> foodmenuList;

    public MenuAdapter(Context context, List<MenuItem> foodmenuList) {
        this.context = context;
        this.foodmenuList = foodmenuList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menuitem, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        MenuItem foodItem = foodmenuList.get(position);
        holder.foodImage.setImageResource(foodItem.getFoodImage());
        holder.foodName.setText(foodItem.getFoodName());
        holder.foodPrice.setText(foodItem.getFoodPrice());

        holder.foodAdd.setOnClickListener(v ->
                Toast.makeText(context, foodItem.getFoodName() + " added!", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return foodmenuList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName, foodPrice;
        Button foodAdd;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodimg);
            foodName = itemView.findViewById(R.id.foodname);
            foodPrice = itemView.findViewById(R.id.foodprice);
            foodAdd = itemView.findViewById(R.id.foodadd);
        }
    }
}
