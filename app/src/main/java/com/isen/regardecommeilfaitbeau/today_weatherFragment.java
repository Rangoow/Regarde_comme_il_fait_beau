package com.isen.regardecommeilfaitbeau;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class today_weatherFragment extends Fragment {
    static TextView temperature_id;
    static TextView city_id;
    static TextView weatherDescription_id;
    TextView tempUnit_id;
    static ImageView weatherDescriptionIcon_id;
    EditText cityInput_id;
    static today_weatherFragment instance;

    public static today_weatherFragment getInstance() {
        if(instance==null)
            instance=new today_weatherFragment();
        return instance;
    }

    public today_weatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView=inflater.inflate(R.layout.fragment_today_weather, container, false);
        weatherDescriptionIcon_id=(ImageView)itemView.findViewById(R.id.weatherDescriptionIcon_id);
        temperature_id=(TextView) itemView.findViewById(R.id.temperature_id);
        city_id=(TextView)itemView.findViewById(R.id.city_id);
        weatherDescription_id=(TextView)itemView.findViewById(R.id.weatherDescription_id);
        tempUnit_id=(TextView)itemView.findViewById(R.id.tempUnit_id);
        return itemView;
    }

}
