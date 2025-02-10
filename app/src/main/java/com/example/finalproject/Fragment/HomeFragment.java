package com.example.finalproject.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.finalproject.R;
import com.example.finalproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.adapter.MyAdapter;
import com.example.finalproject.adapter.HomeItem;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter foodAdapter;
    private List<HomeItem> foodList;
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View Binding सेट करें
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // ImageSlider सेट करें
        ImageSlider imageSlider = binding.imageSlider;
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));

        // ImageSlider को अपडेट करें
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);

        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        // **Food List डेटा सेट करें**
        foodList = new ArrayList<>();
        foodList.add(new HomeItem(R.drawable.w, "Burger \nFull Plate", "150"));
        foodList.add(new HomeItem(R.drawable.x, "Pizza\nFull Plate", "250"));
        foodList.add(new HomeItem(R.drawable.y, "Pasta\nFull Plate", "100"));
        foodList.add(new HomeItem(R.drawable.z, "Sandwich\nFull Plate", "50"));

        // **Adapter सेट करें**
        foodAdapter = new MyAdapter(getContext(), foodList);
        binding.recycler.setAdapter(foodAdapter);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // मेमोरी लीक्स रोकने के लिए
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
