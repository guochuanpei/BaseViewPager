package com.minshu.baseviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.minshu.baseviewpager.adpater.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewPager mrecyclerViewPager;
    private List<String> mStrings = new ArrayList<>();
    private List<Integer> mIntegers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        initView();

    }

    private void initView() {
        mrecyclerViewPager = (RecyclerViewPager) findViewById(R.id.list);
        mrecyclerViewPager.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //mrecyclerViewPager.setTriggerOffset(0.15f);
        //mrecyclerViewPager.setFlingFactor(0.25f);
        MyAdapter myAdapter = new MyAdapter(mStrings, mIntegers, this);
        mrecyclerViewPager.setAdapter(myAdapter);
//        mrecyclerViewPager.setHasFixedSize(true);
//        mrecyclerViewPager.setLongClickable(true);
        mrecyclerViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
//                mPositionText.setText("First: " + mRecyclerViewPager.getFirstVisiblePosition());
                int childCount = mrecyclerViewPager.getChildCount();
                int width = mrecyclerViewPager.getChildAt(0).getWidth();
                int padding = (mrecyclerViewPager.getWidth() - width) / 2;

                for (int j = 0; j < childCount; j++) {
                    View v = recyclerView.getChildAt(j);
                    //往左 从 padding 到 -(v.getWidth()-padding) 的过程中，由大到小
                    float rate = 0;
                    if (v.getLeft() <= padding) {
                        if (v.getLeft() >= padding - v.getWidth()) {
                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
                        } else {
                            rate = 1;
                        }
                        v.setScaleY(1 - rate * 0.1f);
                    } else {
                        //往右 从 padding 到 recyclerView.getWidth()-padding 的过程中，由大到小
                        if (v.getLeft() <= recyclerView.getWidth() - padding) {
                            rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
                        }
                        v.setScaleY(0.9f + rate * 0.1f);
                    }
                }
            }
        });
    }

    public void getData() {
        //页数
        for (int i = 1; i <= 31; i++) {
            mIntegers.add(i);
        }
        //listview数据
        for (int i = 0; i < 20; i++) {
            mStrings.add("我是测试数据" + i);
        }
    }
}
