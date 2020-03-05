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
public class DetailsFragment extends Fragment {

    static TextView temperature_id,temperatureMax_id,date_id,temperatureMin_id,humidityTxt_id,pressureTxt_id,windTxt_id,sunriseTxt_id,sunsetTxt_id,humitidtyVal_id,PressureVal_id;
    static TextView city_id;
    static TextView weatherDescription_id;
    TextView tempUnit_id;
    static TextView windVal_id;
    static TextView sunriseVal_id;
    static TextView sunsetVal_id;
    static ImageView weatherDescriptionIcon_id;
    EditText cityInput_id;
    static DetailsFragment instance;

    public static DetailsFragment getInstance() {
        if(instance==null)
            instance=new DetailsFragment();
        return instance;
    }
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView=inflater.inflate(R.layout.fragment_details, container, false);
        weatherDescriptionIcon_id=(ImageView)itemView.findViewById(R.id.weatherDescriptionIcon_id);
        temperature_id=(TextView) itemView.findViewById(R.id.temperature_id);
        temperatureMax_id=(TextView) itemView.findViewById(R.id.temperatureMax_id);
        temperatureMin_id=(TextView) itemView.findViewById(R.id.temperatureMin_id);
        humidityTxt_id=(TextView) itemView.findViewById(R.id.humidityTxt_id);
        pressureTxt_id=(TextView) itemView.findViewById(R.id.pressureTxt_id);
        date_id=(TextView) itemView.findViewById(R.id.date_id);
        windTxt_id=(TextView) itemView.findViewById(R.id.windTxt_id);
        sunriseTxt_id=(TextView) itemView.findViewById(R.id.sunriseTxt_id);
        sunsetTxt_id=(TextView) itemView.findViewById(R.id.sunsetTxt_id);
        humitidtyVal_id=(TextView) itemView.findViewById(R.id.humitidtyVal_id);
        PressureVal_id=(TextView) itemView.findViewById(R.id.PressureVal_id);
        windVal_id=(TextView) itemView.findViewById(R.id.windVal_id);
        sunriseVal_id=(TextView) itemView.findViewById(R.id.sunriseVal_id);
        sunsetVal_id=(TextView) itemView.findViewById(R.id.sunsetVal_id);
        city_id=(TextView)itemView.findViewById(R.id.city_id);
        weatherDescription_id=(TextView)itemView.findViewById(R.id.weatherDescription_id);
        tempUnit_id=(TextView)itemView.findViewById(R.id.tempUnit_id);
        return itemView;
    }

}
