package com.example.shuoquan1205.myapp05.SimpleNewsApp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shuoquan1205.myapp05.R;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,News news){
        Intent i = new Intent(context,NewsContentActivity.class);
        i.putExtra("news_title",news.getTitle());
        i.putExtra("news_content",news.getContent());
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        News news = new News();
        news.setTitle(getIntent().getStringExtra("news_title"));
        news.setContent(getIntent().getStringExtra("news_content"));
        FragmentManager manager = getFragmentManager();
        NewsContentFragment fragment = (NewsContentFragment) manager.findFragmentById(R.id.news_content_fragment);
        fragment.refresh(news);
    }
}
