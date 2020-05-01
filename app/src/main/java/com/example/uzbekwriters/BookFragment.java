package com.example.uzbekwriters;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class BookFragment extends Fragment {
    private ListView list;
    private ArrayList<BookModel> data;
    private BookAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = view.findViewById(R.id.bookList);
        loadData();
        adapter = new BookAdapter(data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("asar", data.get(i).getBook());
                PdfFragment pdfFragment = new PdfFragment();
                pdfFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, pdfFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void loadData() {
        data = new ArrayList<>();
        int position = getArguments().getInt("number");
        switch (position){
            case 0:
                data.add(new BookModel("РУБАИ (часть I)"));
                data.add(new BookModel("РУБАИ (часть II)"));
                break;
            case 1:
                data.add(new BookModel("Сборник стихов"));
                break;
            case 2:
                data.add(new BookModel("Смятение праведных"));
                data.add(new BookModel("Фархад и Ширин"));
                data.add(new BookModel("Лейли и Межнун"));
                data.add(new BookModel("Семь планет"));
                data.add(new BookModel("Стена Искандера"));
                data.add(new BookModel("Пояснительный словарь"));
                data.add(new BookModel("Хадисы"));
                break;
            case 3:
                data.add(new BookModel("Бабур-намэ"));
                data.add(new BookModel("Высказывания и афоризмы"));
                data.add(new BookModel("Рубаи"));
                break;
            case 4:
                data.add(new BookModel("Избранная лирика Востока"));
                break;
            case 5:
                data.add(new BookModel("Abdulla Kadyri. Minuvshie dni (roman)"));
                data.add(new BookModel("Kadyri_Skorpion-iz-altarya"));
                break;
            case 6:
                data.add(new BookModel("Рассказы индийского путешественника(Фитрат)"));
                break;
            case 7:
                data.add(new BookModel("Рассказы"));
                data.add(new BookModel("Стихотворения"));
                break;
            case 8:
                data.add(new BookModel("Сборник стихов(Зульфия)"));
                break;
            case 9:
                data.add(new BookModel("Горизонт"));
                data.add(new BookModel("Рассказы(Саид Ахмад)"));
                break;
            case 10:
                data.add(new BookModel("Стихи"));
                break;
            case 11:
                data.add(new BookModel("Стихи (Эркин Вахидов)"));
                break;
        }
    }
}
