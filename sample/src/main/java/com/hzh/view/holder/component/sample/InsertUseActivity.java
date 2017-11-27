package com.hzh.view.holder.component.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.hzh.view.holder.component.sample.holder.InsertViewHolder;

public class InsertUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_use);
        ViewGroup rootLayout = (ViewGroup) findViewById(R.id.rootLayout);
        InsertViewHolder holder = new InsertViewHolder(this);
        rootLayout.addView(holder.getRoot());
    }
}
