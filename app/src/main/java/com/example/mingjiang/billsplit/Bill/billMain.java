package com.example.mingjiang.billsplit.Bill;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mingjiang.billsplit.R;
/**
 * Created by mingjiang on 7/28/16.
 */

public class billMain extends Fragment
{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.billmainpart, container, false);

        return view;
    }
}