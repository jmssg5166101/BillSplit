package com.example.mingjiang.billsplit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mingjiang.billsplit.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mingjiang on 8/23/16.
 */
public class RadioButtonGroupAdapter extends BaseAdapter {
    LayoutInflater mInflater;

    private ArrayList<String> list;
    // 用来控制CheckBox的选中状况
    private static HashMap<String, Boolean> isSelected;
    Context context;

    public RadioButtonGroupAdapter() {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list.size();

    }

    public RadioButtonGroupAdapter(ArrayList<String> list, Context context) {
        this.context = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
        isSelected = new HashMap<String, Boolean>();

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
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        ViewHolderForRadio holder = null;
        if (convertView == null) {
            // 获得ViewHolder对象
            holder = new ViewHolderForRadio();
            // 导入布局并赋值给convertview
            convertView = mInflater.inflate(R.layout.choosepaymoneyuserdialog, null);
            holder.tx = (TextView) convertView.findViewById(R.id.choosePayMoneyUserTextView);
            //holder.rb = (RadioButton) convertView.findViewById(R.id.choosePayMoneyUserRadioButton);
            // 为view设置标签
            convertView.setTag(holder);
        } else {
            // 取出holder
            holder = (ViewHolderForRadio) convertView.getTag();
        }
        final RadioButton radio = (RadioButton) convertView.findViewById(R.id.choosePayMoneyUserRadioButton);

        holder.rb = radio;
        // 设置list中TextView的显示
        holder.tx.setText(list.get(position));
        // 根据isSelected来设置checkbox的选中状况
        holder.rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String key : isSelected.keySet()) {
                    isSelected.put(key, false);
                }
                isSelected.put(String.valueOf(String.valueOf(position)), radio.isChecked());
                RadioButtonGroupAdapter.this.notifyDataSetChanged();
            }

        });

        boolean res=false;
        if(isSelected.get(String.valueOf(position)) == null || isSelected.get(String.valueOf(position))== false){
            res=false;
            isSelected.put(String.valueOf(position), false);
        }
        else
            res = true;

        holder.rb.setChecked(res);
        return convertView;

        // return view;
    }
}


