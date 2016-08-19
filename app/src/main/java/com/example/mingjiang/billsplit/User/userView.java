package com.example.mingjiang.billsplit.User;

import android.app.Activity;
import android.app.Dialog;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mingjiang.billsplit.R;

import java.util.List;

/**
 * Created by mingjiang on 7/28/16.
 */
public class userView extends Activity {
    private int Item=-1;
    FavoriteList favList=new FavoriteList();
    ImageButton add;
    ImageButton delete;
    Context context=this;
    dbOption dboption;
    ViewAdapter myAdapter;
    ListView listview;
    List<FavoriteList> favoriteList;
    LinearLayout layout;
    int ItemPostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        Log.d("test git","test git");

        add=(ImageButton)findViewById(R.id.image_add);
        add.setOnClickListener(addOnClick);
        myAdapter=new ViewAdapter();
        delete=(ImageButton)findViewById(R.id.image_delete);
        delete.setOnClickListener(deleteOnClick);

        listview=(ListView)findViewById(R.id.listview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //view.setBackgroundResource(R.color.ListItemChosedColor);

                myAdapter.setSelectItem(i);
                ItemPostion=i;

                Log.d("test","ItemPosition is:"+ItemPostion);
//               ViewAdapter myAdapter=new ViewAdapter();
//
//                dboption.removeFav(favoriteList.get(i).getId());
//                //notifyDataSetChanged();
//                favoriteList = dboption.getFavList();
//                listview.setAdapter(new ViewAdapter());
            }
        });

        Log.d("test","add to datebase");

        dboption=new dbOption(context);
        favoriteList = dboption.getFavList();

        listview.setAdapter(new ViewAdapter());
    }
    /**********************   add new user to user page    *************************/
    View.OnClickListener addOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("test","on click response");
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add);
            dialog.setTitle("Add Data to Database");
            final EditText name = (EditText) dialog.findViewById(R.id.name);
            final EditText phoneNum = (EditText) dialog.findViewById(R.id.phoneNum);
            final EditText Email=(EditText)dialog.findViewById(R.id.Email);
            Button Add = (Button) dialog.findViewById(R.id.Add);
            Add.setText("Add");

            Log.d("test","Add all element to dialog");
            Add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(name.getText().toString() != null && name.getText().toString().length() >0 ){
                        Log.d("test","excute add option to dialog");
                        dboption.addDataToUser(context, name.getText().toString(), phoneNum.getText().toString(),Email.getText().toString());
                        Log.d("test","excute add option to dialog");
                        favoriteList = dboption.getFavList();

                        listview.setAdapter(new ViewAdapter());
                        dialog.dismiss();


                    }else{
                        Toast.makeText(getApplicationContext(), "Please Enter the Name", Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.show();
        }
    };
    View.OnClickListener deleteOnClick=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("test","recieved ItemPosition is:"+favoriteList.get(ItemPostion).getId());

                dboption.removeFav(favoriteList.get(ItemPostion).getId());
                myAdapter.notifyDataSetChanged();
                favoriteList = dboption.getFavList();
                listview.setAdapter(new ViewAdapter());
        }
    };


    public class ViewAdapter extends BaseAdapter {


        LayoutInflater mInflater;


        public ViewAdapter() {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return favoriteList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listitem,null);
            }

            final TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
            nameText.setText("Name : "+favoriteList.get(position).getName());
            final TextView phoneText = (TextView) convertView.findViewById(R.id.phoneText);
            phoneText.setText("Phone Number : "+favoriteList.get(position).getphoneNum());

            final TextView EmailText = (TextView) convertView.findViewById(R.id.EmailText);
            EmailText.setText("Email address : "+favoriteList.get(position).getEmail());
            final TextView UserIdText = (TextView) convertView.findViewById(R.id.UserIdText);
            UserIdText.setText("UserId : "+favoriteList.get(position).getId());
            Log.d("test","Postion is:"+position);
            Log.d("test","Item is:"+Item);


//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dboption.removeFav(favoriteList.get(position).getId());
//                    notifyDataSetChanged();
//                    favoriteList = dboption.getFavList();
//                    listview.setAdapter(new ViewAdapter());
//                }
//            });
            return convertView;
        }
        public  void setSelectItem(int selectItem) {
            Log.d("test","select Item :"+selectItem);
            Item = selectItem;
        }

    }


    /**********************   add new user to user page    *************************/
}


