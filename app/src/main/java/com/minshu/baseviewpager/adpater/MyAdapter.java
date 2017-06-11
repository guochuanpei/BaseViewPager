package com.minshu.baseviewpager.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.minshu.baseviewpager.R;

import java.util.List;

/**
 * 作者：郭传沛 on 2017/6/11 01:28
 * 邮箱：bestyourselfgcp@163.com
 * 类用途:
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mStrings;//listview所用数据
    private List<Integer> mIntegers;//viewpager所用数据
    private Context mContext;
    private BaseViewHolder mBaseViewHolder;

    public MyAdapter(List<String> strings, List<Integer> integers, Context context) {
        mStrings = strings;
        mIntegers = integers;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_base, parent, false);
        mBaseViewHolder = new BaseViewHolder(view);
        return mBaseViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        ListviewAdapter listviewAdapter = new ListviewAdapter(mContext, mStrings);
        baseViewHolder.mListview.setAdapter(listviewAdapter);
    }

    @Override
    public int getItemCount() {
        return mIntegers.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private final ListView mListview;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mListview = (ListView) itemView.findViewById(R.id.base_item_listview);
        }
    }
}
