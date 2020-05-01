package com.example.uzbekwriters;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BiographyFragment extends Fragment {
    ImageView image;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_biography, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = getArguments().getInt("number");
        textView = view.findViewById(R.id.textId);
        image = view.findViewById(R.id.picture);
        textView.setText(getResources().getStringArray(R.array.description)[position]);

        switch (position){
            case (0):
                image.setImageResource(R.drawable.pahlavon);
                break;
            case (1):
                image.setImageResource(R.drawable.mashrab);
                break;
            case (2):
                image.setImageResource(R.drawable.navoi);
                break;
            case (3):
                image.setImageResource(R.drawable.babur);
                break;
            case (4):
                image.setImageResource(R.drawable.nadira);
                break;
            case (5):
                image.setImageResource(R.drawable.qodiriy);
                break;
            case (6):
                image.setImageResource(R.drawable.fitrat);
                break;
            case (7):
                image.setImageResource(R.drawable.gulom);
                break;
            case (8):
                image.setImageResource(R.drawable.zulfiya);
                break;
            case (9):
                image.setImageResource(R.drawable.said_ahmad);
                break;
            case (10):
                image.setImageResource(R.drawable.aripov);
                break;
            case (11):
                image.setImageResource(R.drawable.vahidov);
                break;
        }
    }

}
