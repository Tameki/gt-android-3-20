package com.geektech.boredapp_20.presentation.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.geektech.boredapp_20.R;
import com.geektech.boredapp_20.presentation.favorites.FavoritesFragment;
import com.geektech.boredapp_20.presentation.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.main_view_pager);
        mBottomNavigationView = findViewById(R.id.main_bottom_nav);

        mViewPager.setAdapter(
                new MainPagerAdapter(getSupportFragmentManager())
        );
        mViewPager.setOffscreenPageLimit(2);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_main:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_favorites:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_settings:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    public class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;

            switch (position) {
                case 0: fragment = MainFragment.newInstance();
                    break;
                case 1: fragment = FavoritesFragment.newInstance();
                    break;
                default: fragment = SettingsFragment.newInstance();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}