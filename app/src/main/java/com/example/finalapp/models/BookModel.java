package com.example.finalapp.models;

public class BookModel {
    public int bookimage;
    public String bookname;
    public String bookauthor;
    public String bookprice;
    public BookModel(int bookimage, String bookname, String bookauthor, String bookprice) {
        this.bookimage = bookimage;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookprice = bookprice;
    }
}
