package com.example.librarymanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    private Context context;
    private ArrayList<Book> bookList;

    public BookAdapter(Context context, ArrayList<Book> bookList) {
        super(context, 0, bookList);
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_book, parent, false);
        }

        Book book = getItem(position);

        TextView tvTitle = view.findViewById(R.id.et_book_title);
        TextView tvAuthor = view.findViewById(R.id.et_author);
        TextView tvIsbn = view.findViewById(R.id.et_isbn);

        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvIsbn.setText(book.getIsbn());

        return view;
    }
}
