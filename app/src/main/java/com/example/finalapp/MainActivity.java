package com.example.finalapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalapp.adapter.RecyclerBookAdapter;
import com.example.finalapp.databinding.ActivityMainBinding;
import com.example.finalapp.interfaces.BookInterface;
import com.example.finalapp.models.BookModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    List<BookModel> bookList = new ArrayList<>();
    ActivityMainBinding binding;
    BookInterface bookInterface;
    List<BookModel> filterList = new ArrayList<>();
    public static List<BookModel> favouriteList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        bookInterface = new BookInterface() {
            @Override
            public void onClick(BookModel b1, int position) {
                Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
                intent.putExtra("image", b1.bookimage);
                intent.putExtra("name", b1.bookname);
                intent.putExtra("author", b1.bookauthor);
                intent.putExtra("price", b1.bookprice);

                startActivity(intent);
            }
        };


        bookList.add(new BookModel(R.drawable.book1, "Billion Dollar Enemy", "Book by Olivia Hayle", "₹ 499"));
        bookList.add(new BookModel(R.drawable.book2, "Dirty Red", "Book by Tarryn Fisher", "₹ 599"));
        bookList.add(new BookModel(R.drawable.book3, "The Pool Boy", "Book by Nikki Sloane", "₹ 449"));
        bookList.add(new BookModel(R.drawable.book4, "Black Female", "Book by Kim J. West", "₹ 1049"));
        bookList.add(new BookModel(R.drawable.book5, "Wild Island Love", "Book by Melissa Foster", "₹ 899"));
        bookList.add(new BookModel(R.drawable.book6, "Her Billionaire Protector", "Book by Sophia Summers", "₹ 699"));
        bookList.add(new BookModel(R.drawable.book7, "White Out", "Book by Danielle Girard", "₹ 349"));
        bookList.add(new BookModel(R.drawable.book8, "Courting Perceptions", "Book by Maria CrawFord", "₹ 249"));

        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                alertBox();
            }
        });

        binding.favouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });

        RecyclerBookAdapter adapter = new RecyclerBookAdapter(bookList, this, bookInterface);
        binding.recyclerBookView.setAdapter(adapter);
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = bookList.stream().filter(a -> a.bookname.toLowerCase().contains(newText.toLowerCase())).collect(Collectors.toList());
                adapter.searchProduct(filterList);
                return false;
            }
        });
    }

    void alertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("Do you want to Exit ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}