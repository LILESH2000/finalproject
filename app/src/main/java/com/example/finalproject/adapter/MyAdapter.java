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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.FoodViewHolder> {
    private Context context;
    private List<HomeItem> foodList;

    public MyAdapter(Context context, List<HomeItem> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homeitems, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        HomeItem foodItem = foodList.get(position);
        holder.foodImage.setImageResource(foodItem.getFoodImage());
        holder.foodName.setText(foodItem.getFoodName());
        holder.foodPrice.setText(foodItem.getFoodPrice());

        holder.foodAdd.setOnClickListener(v ->
                Toast.makeText(context, foodItem.getFoodName() + " added!", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return foodList.size();
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
