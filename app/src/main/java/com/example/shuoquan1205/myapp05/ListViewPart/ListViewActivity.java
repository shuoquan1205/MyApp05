package com.example.shuoquan1205.myapp05.ListViewPart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.shuoquan1205.myapp05.R;

public class ListViewActivity extends AppCompatActivity {

    private String LogTag = "ListViewActivity";
    private String LogMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        addListView01(1000000);
//        addListView02(1000000);
        addListView03(1000000);
    }

    private void addListView03(int i) {
        //this version modify adpater
        addListView02(i);
    }

    private void addListView02(int max) {
        LogMsg = "addListView02";
        Log.d(LogTag,LogMsg);
        List<ListViewItem> data = new ArrayList<ListViewItem>();
        for(int i=0;i<max;i++){
            ListViewItem item;
            switch (i%10){
                case 0:
                    item = new ListViewItem(i,"yanji_png_01", R.drawable.yj01);
                    break;
                case 1:
                    item = new ListViewItem(i,"yanji_png_02", R.drawable.yj02);
                    break;
                case 2:
                    item = new ListViewItem(i,"yanji_png_03", R.drawable.yj03);
                    break;
                case 3:
                    item = new ListViewItem(i,"yanji_png_04", R.drawable.yj04);
                    break;
                case 4:
                    item = new ListViewItem(i,"yanji_png_05", R.drawable.yj05);
                    break;
                case 5:
                    item = new ListViewItem(i,"yanji_png_06", R.drawable.yj06);
                    break;
                case 6:
                    item = new ListViewItem(i,"yanji_png_07", R.drawable.yj07);
                    break;
                case 7:
                    item = new ListViewItem(i,"yanji_png_08", R.drawable.yj08);
                    break;
                case 8:
                    item = new ListViewItem(i,"yanji_png_09", R.drawable.yj09);
                    break;
                case 9:
                    item = new ListViewItem(i,"yanji_png_10", R.drawable.yj10);
                    break;
                default:
                    item = new ListViewItem(i,"yanji_png_01", R.drawable.yj01);
                    break;
            }
            if(item.isNull()){
                item = new ListViewItem(i,"yanji_png_01", R.drawable.yj01);
            }
            data.add(item);
        }
        ListViewItemAdapter adpater = new ListViewItemAdapter(ListViewActivity.this, R.layout.list_view_item,data);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adpater);
    }

    private void addListView01(int max) {
        List<String> data = new ArrayList<String>();
        for(int i=0;i<max;i++){
            data.add("ListView ID: "+i);
        }
        ListView listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter(ListViewActivity.this, android.R.layout.simple_list_item_1,data);
        listview.setAdapter(adapter);
    }
}
