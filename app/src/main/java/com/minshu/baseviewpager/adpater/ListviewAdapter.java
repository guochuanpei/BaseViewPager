package com.minshu.baseviewpager.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minshu.baseviewpager.R;

import java.util.List;

/**
 * 作者：郭传沛 on 2017/6/11 03:09
 * 邮箱：bestyourselfgcp@163.com
 * 类用途:
 */

public class ListviewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mStrings;

    public ListviewAdapter(Context context, List<String> strings) {
        mContext = context;
        mStrings = strings;
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int position) {
        return mStrings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = convertView.inflate(mContext, R.layout.listview_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextview.setText(mStrings.get(position));//绑定数据
        return convertView;
    }

    class ViewHolder {
        private TextView mTextview;

        public ViewHolder(View itemview) {
            mTextview = (TextView) itemview.findViewById(R.id.lv_text);
        }
    }
}
