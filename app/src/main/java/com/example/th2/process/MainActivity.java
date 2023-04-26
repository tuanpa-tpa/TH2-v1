package com.example.th2.process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.th2.R;
import com.example.th2.data.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnAdd;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_list).setText("Danh sách");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_info).setText("Thông tin");
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search).setText("Tìm kiếm");
        btnAdd = findViewById(R.id.bt_add);
        initListener();

    }

    private void initListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            Item book = (Item) data.getSerializableExtra("item");
        }
    }
}