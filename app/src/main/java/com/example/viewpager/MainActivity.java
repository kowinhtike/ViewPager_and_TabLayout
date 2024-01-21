package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vpMain;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tlMain);
        vpMain = findViewById(R.id.vPager);

        vpMain.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment = new FoodsFragment();
                switch (position) {
                    case 0: {
                        fragment = new FoodsFragment();
                        break;
                    }
                    case 1: {

                        fragment = new OrdersFragment();
                        break;
                    }

                    case 2: {

                        fragment = new ShopFragment();
                        break;
                    }
                }
                return fragment;
            }
            @Override
            public int getItemCount() {
                return 3;
            }
        });

//        connect tablayout and view pager
        String[] tabs = {"Foods","Orders","Shop"};
        int[] photo = {R.drawable.baseline_adjust_24,R.drawable.baseline_airport_shuttle_24,R.drawable.baseline_add_shopping_cart_24};
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vpMain, (myTabLayout, position) -> {
            myTabLayout.setText(tabs[position]);
            myTabLayout.setIcon(photo[position]);
        } );
        tabLayoutMediator.attach();


    }
}