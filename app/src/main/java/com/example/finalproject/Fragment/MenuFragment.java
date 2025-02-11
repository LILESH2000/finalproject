package com.example.finalproject.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.R;
import com.example.finalproject.Utils.SpacingItemDecoder;
import com.example.finalproject.adapter.HomeItem;
import com.example.finalproject.adapter.MenuAdapter;
import com.example.finalproject.adapter.MenuItem;
import com.example.finalproject.adapter.MyAdapter;
import com.example.finalproject.databinding.FragmentHomeBinding;
import com.example.finalproject.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter foodAdapter;
    private List<MenuItem> foodmenuList;
    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View Binding सेट करें
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        // **Food List डेटा सेट करें**
        foodmenuList = new ArrayList<>();
        foodmenuList.add(new MenuItem(R.drawable.w, "Burger \nFull Plate", "150"));
        foodmenuList.add(new MenuItem(R.drawable.x, "Pizza\nFull Plate", "250"));
        foodmenuList.add(new MenuItem(R.drawable.y, "Pasta\nFull Plate", "100"));
        foodmenuList.add(new MenuItem(R.drawable.z, "Sandwich\nFull Plate", "50"));

        // **Adapter सेट करें**
        foodAdapter = new MenuAdapter(getContext(), foodmenuList);
        binding.recyclerview.setAdapter(foodAdapter);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // मेमोरी लीक्स रोकने के लिए
    }

    private void initRecyclerView() {
        recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SpacingItemDecoder itemDecoder = new SpacingItemDecoder(10);
        recyclerView.addItemDecoration(itemDecoder);
        foodAdapter = new MenuAdapter(getContext(), foodmenuList);
        recyclerView.setAdapter(foodAdapter);
    }


}
