package com.example.shuoquan1205.myapp05.ListViewPart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shuoquan1205.myapp05.R;

import java.util.List;

public class ListViewItemAdapter extends ArrayAdapter {

    int resourceId;

    public ListViewItemAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    class ViewHolder{
        ImageView itemImg;
        TextView itemId;
        TextView itemMsg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewItem item = (ListViewItem) getItem(position);
        //Version01:converView
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            //version02:viewHolder
            viewHolder = new ViewHolder();
            viewHolder.itemImg = (ImageView) view.findViewById(R.id.list_view_item_img);
            viewHolder.itemId = (TextView) view.findViewById(R.id.list_view_item_id);
            viewHolder.itemMsg = (TextView) view.findViewById(R.id.list_view_item_msg);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
//        ImageView itemImg = (ImageView) view.findViewById(R.id.list_view_item_img);
//        TextView itemId = (TextView) view.findViewById(R.id.list_view_item_id);
//        TextView itemMsg = (TextView) view.findViewById(R.id.list_view_item_msg);
        viewHolder.itemImg.setImageResource(item.getImgId());
        viewHolder.itemId.setText("ItemID:"+item.getId());
        viewHolder.itemMsg.setText(item.getMsg());
        return view;
    }
}