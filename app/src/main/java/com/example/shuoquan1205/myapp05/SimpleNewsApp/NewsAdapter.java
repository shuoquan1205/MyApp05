package com.example.shuoquan1205.myapp05.SimpleNewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shuoquan1205.myapp05.R;

import java.util.List;

public class NewsAdapter extends ArrayAdapter {

    private int resourceId;

    public NewsAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = (News) getItem(position);
        View view;
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = convertView;
        }
        TextView newsTitle = (TextView) view.findViewById(R.id.news_title);
        newsTitle.setText(news.getTitle());
        return view;
    }
}