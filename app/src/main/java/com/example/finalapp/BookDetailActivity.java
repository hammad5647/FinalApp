package com.example.finalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.finalapp.databinding.ActivityBookDetailBinding;
import com.example.finalapp.models.BookModel;


public class BookDetailActivity extends AppCompatActivity {
    ActivityBookDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int book_image = getIntent().getIntExtra("image", 0);
        String book_name = getIntent().getStringExtra("name");
        String book_author = getIntent().getStringExtra("author");
        String book_price = getIntent().getStringExtra("price");

        binding.detailBookImage.setImageResource(book_image);
        binding.bookTitle.setText(book_name);
        binding.writerName.setText(book_author);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.favouriteList.add(new BookModel(book_image,book_name,book_author,book_price));
                Toast.makeText(BookDetailActivity.this,"Added To Favourites",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}