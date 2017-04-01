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

public class TabFragment3 extends Fragment implements View.OnClickListener {
    CheckedTextView checkb[] = new CheckedTextView[15];
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_3, container, false);
        checkb[0] = (CheckedTextView) v.findViewById(R.id.chk1);
        checkb[1] = (CheckedTextView) v.findViewById(R.id.chk2);
        checkb[2] = (CheckedTextView) v.findViewById(R.id.chk3);
        checkb[3] = (CheckedTextView) v.findViewById(R.id.chk4);
        checkb[4] = (CheckedTextView) v.findViewById(R.id.chk5);
        checkb[5] = (CheckedTextView) v.findViewById(R.id.chk6);
        checkb[6] = (CheckedTextView) v.findViewById(R.id.chk7);
        checkb[7] = (CheckedTextView) v.findViewById(R.id.chk8);
        checkb[8] = (CheckedTextView) v.findViewById(R.id.chk9);
        checkb[9] = (CheckedTextView) v.findViewById(R.id.chk10);
        checkb[10] = (CheckedTextView) v.findViewById(R.id.chk11);
        checkb[11] = (CheckedTextView) v.findViewById(R.id.chk12);
        checkb[12] = (CheckedTextView) v.findViewById(R.id.chk13);
        checkb[13] = (CheckedTextView) v.findViewById(R.id.chk14);
        checkb[14] = (CheckedTextView) v.findViewById(R.id.chk15);


        for (int i = 0; i < checkb.length; i++) {
            checkb[i].setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {

        CheckedTextView ctv = (CheckedTextView) v;
        boolean isChecked = ctv.isChecked();

        if (isChecked) {
            ctv.setChecked(false);
            Snackbar.make(ctv, "Selected", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            ctv.setChecked(true);
            Snackbar.make(ctv, "UnSelected", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < 15; i++) {
            outState.putBoolean(Integer.toString(i), checkb[i].isChecked());
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            boolean b[] = new boolean[15];
            for (int i = 0; i < 15; i++) {
                b[i] = savedInstanceState.getBoolean(String.valueOf(i));
                if (b[i]) {
                    checkb[i].setChecked(true);
                } else {
                    checkb[i].setChecked(false);
                }
            }

        }
    }

    public void onPause() {
        super.onPause();


    }
}