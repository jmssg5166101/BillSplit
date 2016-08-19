package com.example.mingjiang.billsplit.Bill;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.mingjiang.billsplit.R;
import com.example.mingjiang.billsplit.User.FavoriteList;

import java.util.List;

/**
 * Created by mingjiang on 7/28/16.
 */

public class billMain extends Fragment
{
    private ImageButton addBillButton;
    Context context=this.getContext();

    List<BillList> billListName;
    List<FavoriteList>UserNameList;
    billDbOption billdboption;
    ListView billListView;
    ImageButton addBillImageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.billmainpart, container, false);

//        myAdapter adapter=new myAdapter();
//        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//       // setContentView(R.layout.mainbill);
//        addBillImageButton=(ImageButton)view.findViewById(R.id.image_addbill);
//        addBillImageButton.setOnClickListener(addBillOnClick);
//        billListView=(ListView)view.findViewById(R.id.listview);
//        Log.d("test","before doing the dbopition for bill page");
//        billdboption=new billDbOption(context);
//        Log.d("test","fin");
//        billListName = billdboption.getBillListName();
//        Log.d("test","before bill set Adapter");
//
//        billListView.setAdapter(adapter);
//
//        return view;
//    }
//
//
//    View.OnClickListener addBillOnClick=new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Log.d("test","on click response");
//            final Dialog dialog=new Dialog(context);
//            dialog.setContentView(R.layout.addbilldialog);
//
//            Log.d("test","add dialog");
//
//            final EditText addbillNameEditText=(EditText)dialog.findViewById(R.id.AddBillNameText) ;
//            final EditText addbillAmountEditText=(EditText)dialog.findViewById(R.id.AddBillAmountText);
//            Button addBillButton = (Button) dialog.findViewById(R.id.AddBillButton);
//
//            Log.d("onclick","before add bill onclick response");
//
//            addBillButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(addbillNameEditText.getText()!=null&&addbillNameEditText.getText().toString().length() > 0){
//                        Log.d("test","excute add option to dialog");
//                        billdboption.addDataToBill(context, addbillNameEditText.getText().toString(), addbillNameEditText.getText().toString());
//                        Log.d("test","excute add option to dialog");
//                        billListName = billdboption.getBillListName();
//
//                        billListView.setAdapter(new myAdapter());
//                        dialog.dismiss();
//
//
//                    }else{
//                        Toast.makeText(getActivity(), "Please Enter the Name", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//            dialog.show();
//
//
//        }
//    };
//
//
//
//    public class myAdapter extends BaseAdapter {
//
//        LayoutInflater mInflater;
//        public myAdapter(){mInflater = LayoutInflater.from(context);}
//
//        @Override
//        public int getCount() {
//
//            return billListName.size();
//
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup viewGroup) {
//
//            Log.d("test","debug message: get view start");
//            if (convertView == null) {
//                convertView = mInflater.inflate(R.layout.listbill,null);
//            }
//            final TextView nameList=(TextView)convertView.findViewById(R.id.billNameText);
//            nameList.setText("Bill Name:"+billListName.get(position).getBillName());
//            return convertView;
//        }
     return view;
    }
}