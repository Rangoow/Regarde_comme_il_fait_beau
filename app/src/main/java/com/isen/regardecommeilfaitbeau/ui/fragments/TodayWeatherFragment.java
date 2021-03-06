package com.isen.regardecommeilfaitbeau.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isen.regardecommeilfaitbeau.R;

public class TodayWeatherFragment extends Fragment {

    public TodayWeatherFragment() { }

    //Method that will create a new instance of PageFragment, and add data to its bundle.
    public static TodayWeatherFragment newInstance() {

        //Create new fragment
        TodayWeatherFragment frag = new TodayWeatherFragment();
        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_today_weather, container, false);

        return result;
    }

}