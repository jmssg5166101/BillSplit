package com.example.mingjiang.billsplit.Bill;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mingjiang.billsplit.R;
import com.example.mingjiang.billsplit.User.FavoriteList;

import java.util.List;

/**
 * Created by mingjiang on 7/28/16.
 */
public class billView extends Activity {
    private ImageButton addBillButton;
    Context context=this;

    List<BillList> billListName;
    List<FavoriteList>UserNameList;
    billDbOption billdboption;
    ListView billListView;
    ImageButton addBillImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test","bill oncreate");
        super.onCreate(savedInstanceState);
        myAdapter adapter=new myAdapter();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mainbill);
        addBillImageButton=(ImageButton)findViewById(R.id.image_addbill);
        addBillImageButton.setOnClickListener(addBillOnClick);
        billListView=(ListView)findViewById(R.id.listview);
        Log.d("test","before doing the dbopition for bill page");
        billdboption=new billDbOption(context);
        Log.d("test","fin");
        billListName = billdboption.getBillListName();
        Log.d("test","before bill set Adapter");

        billListView.setAdapter(adapter);
        Log.d("test","finish bill set Adapter");
    }

    View.OnClickListener addBillOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("test","on click response");
            final Dialog dialog=new Dialog(context);
            dialog.setContentView(R.layout.addbilldialog);

            Log.d("test","add dialog");

            final EditText addbillNameEditText=(EditText)dialog.findViewById(R.id.AddBillNameText) ;
            final EditText addbillAmountEditText=(EditText)dialog.findViewById(R.id.AddBillAmountText);
            Button addBillButton = (Button) dialog.findViewById(R.id.AddBillButton);

            Log.d("onclick","before add bill onclick response");

            addBillButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(addbillNameEditText.getText()!=null&&addbillNameEditText.getText().toString().length() > 0){
                        Log.d("test","excute add option to dialog");
                        billdboption.addDataToBill(context, addbillNameEditText.getText().toString(), addbillNameEditText.getText().toString());
                        Log.d("test","excute add option to dialog");
                        billListName = billdboption.getBillListName();

                        billListView.setAdapter(new myAdapter());
                        dialog.dismiss();


                    }else{
                        Toast.makeText(getApplicationContext(), "Please Enter the Name", Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.show();


        }
    };




    public class myAdapter extends BaseAdapter {

        LayoutInflater mInflater;
        public myAdapter(){mInflater = LayoutInflater.from(context);}

        @Override
        public int getCount() {

            return billListName.size();

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

            Log.d("test","debug message: get view start");
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listbill,null);
            }
            final TextView nameList=(TextView)convertView.findViewById(R.id.billNameText);
            nameList.setText("Bill Name:"+billListName.get(position).getBillName());
            return convertView;
        }
    }
    public class dialogViewAdapter extends BaseAdapter{
        LayoutInflater mInflater;
        public dialogViewAdapter(){mInflater = LayoutInflater.from(context);}

        @Override
        public int getCount() {
            return UserNameList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listitem,null);
            }
            final TextView nameList=(TextView)convertView.findViewById(R.id.billNameText);
            nameList.setText("Bill Name:"+UserNameList.get(position).getName());
            return convertView;
        }
    }


}


