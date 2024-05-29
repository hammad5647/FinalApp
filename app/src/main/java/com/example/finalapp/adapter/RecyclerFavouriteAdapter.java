package com.example.finalapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.R;
import com.example.finalapp.databinding.FavouriteSampleBinding;
import com.example.finalapp.models.BookModel;

import java.util.List;

public class RecyclerFavouriteAdapter extends RecyclerView.Adapter<RecyclerFavouriteAdapter.ViewHolder> {

    Context context;
    List<BookModel> bookModelList;
    public RecyclerFavouriteAdapter(List<BookModel> bookModelList) {
        this.bookModelList = bookModelList;
    }

    @NonNull
    @Override
    public RecyclerFavouriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_sample, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerFavouriteAdapter.ViewHolder holder, int position) {
        holder.binding.favbookImage.setImageResource(bookModelList.get(position).bookimage);
        holder.binding.favbookName.setText(bookModelList.get(position).bookname);
        holder.binding.favbookAuthor.setText(bookModelList.get(position).bookauthor);
        holder.binding.favbookPrice.setText(bookModelList.get(position).bookprice);
        holder.binding.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookModelList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FavouriteSampleBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = FavouriteSampleBinding.bind(itemView);
        }
    }
}
