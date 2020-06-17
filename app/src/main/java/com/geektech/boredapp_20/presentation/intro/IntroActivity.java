package com.geektech.boredapp_20.presentation.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geektech.boredapp_20.R;
import com.geektech.boredapp_20.presentation.main.MainActivity;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button nextBtn, skipBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        nextBtn = findViewById(R.id.intro_next_btn);
        skipBtn = findViewById(R.id.intro_skip_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextClick();
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.start(IntroActivity.this);
                finish();
            }
        });

        viewPager = findViewById(R.id.intro_view_pager);
        viewPager.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == IntroPagerAdapter.PAGES_COUNT - 1) {
                    nextBtn.setText("Start");
                    skipBtn.setVisibility(View.GONE);
                } else {
                    nextBtn.setText("Next");
                    skipBtn.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void onNextClick() {
        if (viewPager.getCurrentItem() < IntroPagerAdapter.PAGES_COUNT - 1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        } else {
            MainActivity.start(IntroActivity.this);
            finish();
        }
    }

    public class IntroPagerAdapter extends FragmentPagerAdapter {
        public static final int PAGES_COUNT = 3;

        public IntroPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return IntroFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGES_COUNT;
        }
    }
}