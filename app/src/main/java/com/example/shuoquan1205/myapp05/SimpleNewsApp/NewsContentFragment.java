package com.example.shuoquan1205.myapp05.SimpleNewsApp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shuoquan1205.myapp05.R;

public class NewsContentFragment extends Fragment {

    private View view;

    private void showLog(String logMsg){
        String logTag = "NewsContentFragment";
        Log.d(logTag,logMsg);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,null);
        showLog("onCreate");
        return view;
    }

    public void refresh(News news){
        showLog("refresh");
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView titleText = (TextView) view.findViewById(R.id.news_title);
        TextView contentText = (TextView) view.findViewById(R.id.news_content);
        titleText.setText(news.getTitle());
        contentText.setText(news.getContent());
    }
}