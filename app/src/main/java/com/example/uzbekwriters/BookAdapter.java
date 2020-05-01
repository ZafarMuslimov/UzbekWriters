package com.example.uzbekwriters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private ArrayList<BookModel> data;

    public BookAdapter(ArrayList<BookModel> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public BookModel getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book,viewGroup,false);
        BookModel bm = getItem(i);
        TextView book = view.findViewById(R.id.bookName);
        book.setText(bm.getBook());
        return view;
    }
}
