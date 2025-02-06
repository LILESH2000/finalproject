package com.example.finalproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.finalproject.Fragment.CartFragment;
import com.example.finalproject.Fragment.HomeFragment;
import com.example.finalproject.Fragment.MenuFragment;
import com.example.finalproject.Fragment.ProfileFragment;
import com.example.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.homeFragment) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.menuFragment) {
                replaceFragment(new MenuFragment());
            } else if (item.getItemId() == R.id.cartFragment) {
                replaceFragment(new CartFragment());
            } else if (item.getItemId() == R.id.profileFragment) {
                replaceFragment(new ProfileFragment());
            } else {
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            
            return true;
        });
        
    }
    
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView3,fragment);
        fragmentTransaction.commit();

    }
}