package com.example.uzbekwriters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        getSupportFragmentManager().
//                beginTransaction().
//                add(R.id.fragment_container, new FragmentWriter()).
//                commit();
//    }

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if (savedInstanceState == null) {//необходимо для сохранения состояния при смене ориентации экрана
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentWriter())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_library);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_library:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentWriter())
                        .commit();
                toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                break;
            case R.id.nav2_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment())
                        .commit();
                toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));

                break;
            case R.id.nav3_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment())
                        .commit();
                toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gold));
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

                break;

            case R.id.nav2_share:
                Toast.makeText(this, "Share2", Toast.LENGTH_SHORT).show();

                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
