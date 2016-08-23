package com.example.mingjiang.billsplit.Bill;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mingjiang.billsplit.Adapter.ViewHolder;
import com.example.mingjiang.billsplit.Adapter.dialogAdapter;
import com.example.mingjiang.billsplit.R;
import com.example.mingjiang.billsplit.User.FavoriteList;
import com.example.mingjiang.billsplit.User.dbOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingjiang on 7/28/16.
 */

public class billMain extends Fragment {
    private ImageButton addBillButton;
    FavoriteList favList=new FavoriteList();
    Context context;
    Context dialogcontext;
    List<BillList> billListName;
    List<FavoriteList> UserNameList;
    billDbOption billdboption;
    dbOption dboption;
    ListView billListView;
    ImageButton addBillImageButton;
    billView billview;
    Button selectPaymentUserButton, selectSplitUsersButton;
    dialogAdapter dialogadapter;
    private ArrayList<String> list;
    private int checkNum;
    private TextView tv_show;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = this.getActivity();
        // boolean testtem=(billview.getBaseContext()==this.getContext());
        //  Log.d("test1","testhere:  "+testtem);//fragment在onAttach后才获取activity，所以你可以在onAttach里初始化，或者在其后的生命周期里初始化，在onAttach之前getActivity是肯定不行的

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.billmainpart, container, false);

        myAdapter adapter = new myAdapter();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        // setContentView(R.layout.mainbill);
        Log.d("test","After load the main bill page");

        addBillImageButton = (ImageButton) view.findViewById(R.id.image_addbill);
        addBillImageButton.setOnClickListener(addBillOnClick);

        billListView = (ListView) view.findViewById(R.id.listview);
        Log.d("test", "before doing the dbopition for bill page");
        billdboption = new billDbOption(context);
        Log.d("test", "fin");
        billListName = billdboption.getBillListName();
        Log.d("test", "before bill set Adapter");


        billListView.setAdapter(adapter);
       // ListView UserListViewDialog = (ListView)view.findViewById(R.id.choosePaymentuserdialog);

        return view;
    }


    View.OnClickListener addBillOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("test", "on click response");
            final Dialog dialog = new Dialog(context);
             dialogcontext=dialog.getContext();
            dialog.setContentView(R.layout.addbilldialog);

            Log.d("test", "add dialog");

            final EditText addbillNameEditText = (EditText) dialog.findViewById(R.id.AddBillNameText);
            final EditText addbillAmountEditText = (EditText) dialog.findViewById(R.id.AddBillAmountText);
            Button addBillButton = (Button) dialog.findViewById(R.id.AddBillButton);
            selectPaymentUserButton = (Button) dialog.findViewById(R.id.selectPaymentUser);
            selectPaymentUserButton.setOnClickListener(selectPaymentUserButtonOnClick);
            selectSplitUsersButton = (Button) dialog.findViewById(R.id.selectSplitUsers);
            selectSplitUsersButton.setOnClickListener(selectSplitUsersButtonOnClick);


            Log.d("onclick", "before add bill onclick response");

            addBillButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (addbillNameEditText.getText() != null && addbillNameEditText.getText().toString().length() > 0) {
                        Log.d("test", "excute add option to dialog");
                        billdboption.addDataToBill(context, addbillNameEditText.getText().toString(), addbillNameEditText.getText().toString());
                        Log.d("test", "excute add option to dialog");
                        billListName = billdboption.getBillListName();

                        billListView.setAdapter(new myAdapter());
                        dialog.dismiss();


                    } else {
                        Toast.makeText(getActivity(), "Please Enter the Name", Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.show();


        }
    };

    View.OnClickListener selectSplitUsersButtonOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.d("test","selectPaymentUserButtonOnClick reponse");
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.choosepaymentuser);

            UserNameList =billdboption.getUserNameList();
            //Log.d("test","return to select split user page");
            final Button comfirmButton = (Button) dialog.findViewById(R.id.confirmButton);
            final Button cancelButton=(Button)dialog.findViewById(R.id.cancelButton);
            final ListView UserNameListViewForBill=(ListView)dialog.findViewById(R.id.choosePaymentUserListView);
            //Log.d("test","add all button and listview to dialog");
            UserNameListViewForBill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ViewHolder holder = (ViewHolder) view.getTag();
                    // 改变CheckBox的状态
                    holder.cb.toggle();
                    // 将CheckBox的选中状况记录下来
                    dialogadapter.getIsSelected().put(i, holder.cb.isChecked());
                    // 调整选定条目
                    if (holder.cb.isChecked() == true) {
                        checkNum++;
                    } else {
                        checkNum--;
                    }

                }
            });

            list = new ArrayList<String>();
            // 为Adapter准备数据
            initDate();
            // 实例化自定义的MyAdapter
            dialogadapter = new dialogAdapter(list, context);
            // 绑定Adapter
            UserNameListViewForBill.setAdapter(dialogadapter);
            comfirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.d("test","usernamelistsize: "+UserNameList.get(0).getName());
                    Toast.makeText(context,"confirm click",Toast.LENGTH_LONG).show();

                    dialog.dismiss();
                }
            });
            dialog.show();
            //final Button cancelButton = (Button) dialog.findViewById(R.id.cancelButton);
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.d("test","usernamelistsize: "+UserNameList.get(0).getName());
                    Toast.makeText(context,"cancel click",Toast.LENGTH_LONG).show();

                    dialog.dismiss();
                }
            });

        }

    };


    View.OnClickListener  selectPaymentUserButtonOnClick  = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    public class myAdapter extends BaseAdapter {

        LayoutInflater mInflater;

        public myAdapter() {
            mInflater = LayoutInflater.from(context);
        }

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

            Log.d("test", "debug message: get view start");
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listbill, null);
            }
            final TextView nameList = (TextView) convertView.findViewById(R.id.billNameText);
            nameList.setText("Bill Name:" + billListName.get(position).getBillName());
            return convertView;
        }
        // return view;
    }


    private void initDate() {
        for (int i = 0; i < UserNameList.size(); i++) {
            list.add(UserNameList.get(i).getName());
        }
    }

    // 刷新listview和TextView的显示
    private void dataChanged() {
        // 通知listView刷新
        dialogadapter.notifyDataSetChanged();
        // TextView显示最新的选中数目
        //tv_show.setText("已选中" + checkNum + "项");
    }




}