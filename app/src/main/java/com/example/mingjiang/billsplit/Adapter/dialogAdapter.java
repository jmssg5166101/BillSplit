package com.example.mingjiang.billsplit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mingjiang.billsplit.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mingjiang on 8/22/16.
 */
public class dialogAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    private ArrayList<String> list;
    // 用来控制CheckBox的选中状况
    private static HashMap<Integer,Boolean> isSelected;
    Context context;

    public dialogAdapter() {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list.size();

    }
    public dialogAdapter(ArrayList<String> list, Context context) {
        this.context = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
        isSelected = new HashMap<Integer, Boolean>();
        // 初始化数据
        initDate();
    }

    // 初始化isSelected的数据
    private void initDate(){
        for(int i=0; i<list.size();i++) {
            getIsSelected().put(i,false);
        }
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (convertView == null) {
            // 获得ViewHolder对象
            holder = new ViewHolder();
            // 导入布局并赋值给convertview
            convertView = mInflater.inflate(R.layout.usernamelistforbill, null);
            holder.tv = (TextView) convertView.findViewById(R.id.item_tv);
            holder.cb = (CheckBox) convertView.findViewById(R.id.item_cb);
            // 为view设置标签
            convertView.setTag(holder);
        } else {
            // 取出holder
            holder = (ViewHolder) convertView.getTag();
        }


        // 设置list中TextView的显示
        holder.tv.setText(list.get(position));
        // 根据isSelected来设置checkbox的选中状况
        holder.cb.setChecked(getIsSelected().get(position));
        return convertView;
    }

    public static HashMap<Integer,Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer,Boolean> isSelected) {
        dialogAdapter.isSelected = isSelected;
    }


    // return view;
}

