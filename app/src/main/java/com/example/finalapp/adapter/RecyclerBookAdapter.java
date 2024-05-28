package com.example.finalapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.R;
import com.example.finalapp.databinding.ActivityMainBinding;
import com.example.finalapp.databinding.BookSampleBinding;
import com.example.finalapp.models.BookModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerBookAdapter extends RecyclerView.Adapter<RecyclerBookAdapter.ViewHolder> {

    Context context;

    List<BookModel> BookModel = new ArrayList<>();
    List<BookModel> booklist;

    public RecyclerBookAdapter( List<BookModel> booklist,Context context) {
        this.context = context;
        this.booklist = booklist;
    }
    public void searchProduct(List<BookModel> filterlist)
    {
        BookModel = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.book_sample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerBookAdapter.ViewHolder holder, int position) {

        holder.binding.bookImage.setImageResource(booklist.get(position).bookimage);
        holder.binding.bookName.setText(booklist.get(position).bookname);
        holder.binding.bookAuthor.setText(booklist.get(position).bookauthor);
        holder.binding.bookPrice.setText(booklist.get(position).bookprice);

    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BookSampleBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = BookSampleBinding.bind(itemView);
        }
    }
}
