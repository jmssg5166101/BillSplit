package com.example.mingjiang.billsplit;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.example.mingjiang.billsplit.Bill.billView;
import com.example.mingjiang.billsplit.User.userView;


public class MainActivity extends TabActivity {
    Context context=this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//这里使用了上面创建的xml文件（Tab页面的布局）
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;
        MyDb myDb=new MyDb(context);
        myDb=new MyDb(getApplicationContext());
       // tabHost.getTabWidget().setBackgroundResource(R.drawable.bill);
        Intent intent;  // Reusable Intent for each tab
        Log.d("test","before first page");
        //第一个Tab
        intent = new Intent(this,billView.class);//新建一个Intent用作Tab1显示的内容
        Log.d("test","one");
        spec = tabHost.newTabSpec("tab02")
                .setIndicator("bill",res.getDrawable(android.R.drawable.ic_menu_add))
                .setContent(intent);
        Log.d("test","two");
        tabHost.addTab(spec);//添加进tabHost
        Log.d("test","add first page");

        //第二个Tab
        intent = new Intent(this,userView.class);//第二个Intent用作Tab1显示的内容
        spec = tabHost.newTabSpec("tab2")//新建一个 Tab
                .setIndicator("Users", res.getDrawable(R.drawable.user))//设置名称以及图标
                .setContent(intent);//设置显示的intent，这里的参数也可以是R.id.xxx
        tabHost.addTab(spec);//添加进tabHost
        Log.d("test","add second page");

        //第三个Tab
//        intent = new Intent(this,SecondActivity.class);//第二个Intent用作Tab1显示的内容
//        spec = tabHost.newTabSpec("tab2")//新建一个 Tab
//                .setIndicator("Internet", res.getDrawable(android.R.drawable.ic_menu_help))//设置名称以及图标
//                .setContent(intent);//设置显示的intent，这里的参数也可以是R.id.xxx
//        tabHost.addTab(spec);//添加进tabHost
//        Log.d("Ming","add third page");
//        tabHost.setCurrentTab(0);//设置当前的选项卡,这里为Tab1
    }
}