package com.example.deepak.mynoticeboard;

/**
 * Created by deepak on 27/3/17.
 */

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

public class TabFragment2 extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_fragment_2, container, false);
        CheckedTextView checkb1 = (CheckedTextView) v.findViewById(R.id.chk1);
        CheckedTextView checkb2 = (CheckedTextView) v.findViewById(R.id.chk2);
        CheckedTextView checkb3 = (CheckedTextView) v.findViewById(R.id.chk3);
        CheckedTextView checkb4 = (CheckedTextView) v.findViewById(R.id.chk4);
        CheckedTextView checkb5 = (CheckedTextView) v.findViewById(R.id.chk5);
        CheckedTextView checkb6 = (CheckedTextView) v.findViewById(R.id.chk6);
        CheckedTextView checkb7 = (CheckedTextView) v.findViewById(R.id.chk7);
        CheckedTextView checkb8 = (CheckedTextView) v.findViewById(R.id.chk8);
        CheckedTextView checkb9 = (CheckedTextView) v.findViewById(R.id.chk9);
        CheckedTextView checkb10 = (CheckedTextView) v.findViewById(R.id.chk10);
        CheckedTextView checkb11 = (CheckedTextView) v.findViewById(R.id.chk11);
        CheckedTextView checkb12 = (CheckedTextView) v.findViewById(R.id.chk12);
        CheckedTextView checkb13 = (CheckedTextView) v.findViewById(R.id.chk13);
        CheckedTextView checkb14 = (CheckedTextView) v.findViewById(R.id.chk14);
        CheckedTextView checkb15 = (CheckedTextView) v.findViewById(R.id.chk15);

        checkb1.setOnClickListener(this);
        checkb2.setOnClickListener(this);
        checkb3.setOnClickListener(this);
        checkb4.setOnClickListener(this);
        checkb5.setOnClickListener(this);
        checkb6.setOnClickListener(this);
        checkb7.setOnClickListener(this);
        checkb8.setOnClickListener(this);
        checkb9.setOnClickListener(this);
        checkb10.setOnClickListener(this);
        checkb11.setOnClickListener(this);
        checkb12.setOnClickListener(this);
        checkb13.setOnClickListener(this);
        checkb14.setOnClickListener(this);
        checkb15.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v) {

        CheckedTextView ctv=(CheckedTextView)v;
        boolean isChecked = ctv.isChecked();

        if(isChecked){
            ctv.setChecked(false);
            Snackbar.make(ctv, "Selected", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();}
        else{
            ctv.setChecked(true);
            Snackbar.make(ctv, "UnSelected", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();}
    }}

