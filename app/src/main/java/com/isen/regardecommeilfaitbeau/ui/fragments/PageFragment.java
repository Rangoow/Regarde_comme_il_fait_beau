package com.isen.regardecommeilfaitbeau.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.isen.regardecommeilfaitbeau.R;

public class PageFragment extends Fragment {

    public PageFragment() { }

    //Method that will create a new instance of PageFragment, and add data to its bundle.
    public static PageFragment newInstance() {

        //Create new fragment
        PageFragment frag = new PageFragment();
        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        return result;
    }

}