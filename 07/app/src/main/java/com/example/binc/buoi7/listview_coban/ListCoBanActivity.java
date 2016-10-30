package com.example.binc.buoi7.listview_coban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.binc.buoi7.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by Binc on 25/10/2016.
 */
public class ListCoBanActivity extends AppCompatActivity {
    private ListView mLvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coban);
        mLvList = (ListView) findViewById(R.id.lvList);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(String.format("%s%d", "Phan tu thu:", i));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        mLvList.setAdapter(arrayAdapter);
    }
}
