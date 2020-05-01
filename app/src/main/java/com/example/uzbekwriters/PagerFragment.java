package com.example.uzbekwriters;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerFragment extends Fragment {
    TextView textView;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    String string;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        string = getResources().getStringArray(R.array.writer_name)[getArguments().getInt("name")];
        return inflater.inflate(R.layout.fragment_pager, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity mainActivity = new MainActivity();
//        toolbar = view.findViewById(R.id.toolbar);
//        mainActivity.getSupportActionBar().setTitle(getArguments().getString("name"));
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getArguments().getString("name"));
        textView = view.findViewById(R.id.lib_name);
        textView.setText(string);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.viewPager);
        Bundle bundle = new Bundle();
        bundle.putString("nameID", string);
        bundle.putInt("number", getArguments().getInt("name"));
        BiographyFragment biographyFragment = new BiographyFragment();
        BookFragment bookFragment = new BookFragment();
        biographyFragment.setArguments(bundle);
        bookFragment.setArguments(bundle);
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragments(biographyFragment, "Биография");
        viewPagerAdapter.addFragments(bookFragment, "Труды");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
