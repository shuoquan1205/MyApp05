package com.example.shuoquan1205.myapp05.SimpleNewsApp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shuoquan1205.myapp05.R;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment {

    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter newsAdapter;
    private boolean isTwoPane;

    private void showLog(String logMsg){
        String logTag = "NewsTitleFragment";
        Log.d(logTag,logMsg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        showLog("onAttach");
        initNewsList(10);
        newsAdapter = new NewsAdapter(context, R.layout.news_item,newsList);
    }

    private void initNewsList(int max) {
        if(newsList==null){
            newsList = new ArrayList<News>();
        }
        newsList.clear();
        for(int i=0;i<max;i++){
            News news = new News("title"+i,"author_"+i,"news content,"+i);
            newsList.add(news);
        }
        showLog("initNewsList,size:"+newsList.size());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(newsAdapter);
        newsTitleListView.setOnItemClickListener(newsListViewOnItemClickedListener);
        showLog("onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
        showLog("onActivityCreated,isTwoPane="+isTwoPane);
    }

    private AdapterView.OnItemClickListener newsListViewOnItemClickedListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            showLog("newsListView Item Clicked");
            News news = newsList.get(position);
            if(isTwoPane){
                NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                newsContentFragment.refresh(news);
            }else{
                NewsContentActivity.actionStart(getActivity(),news);
            }
        }
    };

}