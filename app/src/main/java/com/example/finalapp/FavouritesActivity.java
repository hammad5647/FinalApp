package com.example.finalapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.finalapp.adapter.RecyclerFavouriteAdapter;
import com.example.finalapp.databinding.ActivityFavouritesBinding;

public class FavouritesActivity extends AppCompatActivity {
    ActivityFavouritesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFavouritesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RecyclerFavouriteAdapter adapter = new RecyclerFavouriteAdapter(MainActivity.favouriteList);

        binding.favouriteRecycler.setAdapter(adapter);
    }
}