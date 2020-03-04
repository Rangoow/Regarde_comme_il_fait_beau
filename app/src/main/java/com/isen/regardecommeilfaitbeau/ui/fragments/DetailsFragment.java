package com.isen.regardecommeilfaitbeau.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isen.regardecommeilfaitbeau.R;

public class DetailsFragment extends Fragment {

    public DetailsFragment() { }

    //Method that will create a new instance of PageFragment, and add data to its bundle.
    public static DetailsFragment newInstance() {

        //Create new fragment
        DetailsFragment frag = new DetailsFragment();
        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_details, container, false);

        return result;
    }

}