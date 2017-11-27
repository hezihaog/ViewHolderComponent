package com.hzh.view.holder.component.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hzh.view.holder.component.sample.holder.ListUseHeaderHolder;

import java.util.ArrayList;
import java.util.List;

public class ListUseActivity extends AppCompatActivity {
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_use);
        initData();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this, mDatas));
        ListUseHeaderHolder holder = new ListUseHeaderHolder(this);
        listView.addHeaderView(holder.getRoot());
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            mDatas.add(String.valueOf(i).concat(" :::  item "));
        }
    }

    private static class MyAdapter extends BaseAdapter {
        private List<String> dataList;
        private final LayoutInflater inflater;

        public MyAdapter(Context context, List<String> dataList) {
            this.dataList = dataList;
            inflater = LayoutInflater.from(context.getApplicationContext());
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = (ViewGroup) inflater.inflate(R.layout.item_list, null);
                holder = new ViewHolder((ViewGroup) convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(dataList.get(position));
            return convertView;
        }
    }

    private static class ViewHolder {
        public final TextView textView;

        public ViewHolder(ViewGroup viewGroup) {
            textView = viewGroup.findViewById(R.id.text);
        }
    }
}
