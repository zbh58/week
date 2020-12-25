package com.example.week;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rcy = findViewById(R.id.rcy);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rcy.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        gridLayoutHelper.setItemCount(6);
        gridLayoutHelper.setPadding(0,0,0,0);
        gridLayoutHelper.setMargin(0,0,0,0);
        gridLayoutHelper.setBgColor(Color.GRAY);
        gridLayoutHelper.setAspectRatio(4);
        gridLayoutHelper.setWeights(new float[]{100,100});
        gridLayoutHelper.setGap(0);
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutHelper.setSpanCount(5);
        ArrayList<Object> strings = new ArrayList<>();

    }
}