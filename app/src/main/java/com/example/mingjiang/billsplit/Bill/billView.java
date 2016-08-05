package com.example.mingjiang.billsplit.Bill;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mingjiang.billsplit.R;

/**
 * Created by mingjiang on 7/28/16.
 */
public class billView extends Activity {
    private ImageButton addBillButton;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mainbill);
        addBillButton=(ImageButton)findViewById(R.id.image_addbill);
        addBillButton.setOnClickListener(addBillOnClick);
    }

    View.OnClickListener addBillOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("Ming","on click response");
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add);
            dialog.setTitle("Add Data to Database");
            final EditText name = (EditText) dialog.findViewById(R.id.name);
            final EditText phoneNum = (EditText) dialog.findViewById(R.id.phoneNum);
            final EditText Email=(EditText)dialog.findViewById(R.id.Email);
            Button Add = (Button) dialog.findViewById(R.id.Add);
            Add.setText("Add");
            Log.d("Ming","Add all element to dialog");
//            Add.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(name.getText().toString() != null && name.getText().toString().length() >0 ){
//
//                        db.adddata(context, name.getText().toString(), phoneNum.getText().toString(),Email.getText().toString());
//                        favoriteList = db.getFavList();
//                        listview.setAdapter(new ViewAdapter());
//                        dialog.dismiss();
//
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Please Enter the Name", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//            dialog.show();
//        }
        }
    };
}
