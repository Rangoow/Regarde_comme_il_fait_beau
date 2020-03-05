package com.isen.regardecommeilfaitbeau;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    static TextView id_date_day_1,id_date_day_2,id_date_day_3,id_date_day_4,id_date_day_5,id_date_day_6,id_date_day_7;
    static TextView id_weather_desc_day_1,id_weather_desc_day_2,id_weather_desc_day_3,id_weather_desc_day_4,id_weather_desc_day_5,id_weather_desc_day_6,id_weather_desc_day_7;
    static TextView id_temp_max_day_1,id_temp_max_day_2,id_temp_max_day_3,id_temp_max_day_4,id_temp_max_day_5,id_temp_max_day_6,id_temp_max_day_7;
    static TextView id_temp_min_day_1,id_temp_min_day_2,id_temp_min_day_3,id_temp_min_day_4,id_temp_min_day_5,id_temp_min_day_6,id_temp_min_day_7;
    ImageView id_ico_weather_day_1,id_ico_weather_day_2,id_ico_weather_day_3,id_ico_weather_day_4,id_ico_weather_day_5,id_ico_weather_day_6,id_ico_weather_day_7;
    static ForecastFragment instance;
   static ConstraintLayout id_container_day_1,id_container_day_2,id_container_day_3,id_container_day_4,id_container_day_5,id_container_day_6,id_container_day_7;

    public static ForecastFragment getInstance() {
        if(instance==null)
            instance=new ForecastFragment();
        return instance;
    }

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_forecast, container, false);
        id_temp_max_day_1 = (TextView) itemView.findViewById(R.id.id_temp_max_day_1);
        id_temp_max_day_2 = (TextView) itemView.findViewById(R.id.id_temp_max_day_2);
        id_temp_max_day_3 = (TextView) itemView.findViewById(R.id.id_temp_max_day_3);
        id_temp_max_day_4 = (TextView) itemView.findViewById(R.id.id_temp_max_day_4);
        id_temp_max_day_5 = (TextView) itemView.findViewById(R.id.id_temp_max_day_5);
        id_temp_max_day_6 = (TextView) itemView.findViewById(R.id.id_temp_max_day_6);
        id_temp_max_day_7 = (TextView) itemView.findViewById(R.id.id_temp_max_day_7);
        id_temp_min_day_1 = (TextView) itemView.findViewById(R.id.id_temp_min_day_1);
        id_temp_min_day_2 = (TextView) itemView.findViewById(R.id.id_temp_min_day_2);
        id_temp_min_day_3 = (TextView) itemView.findViewById(R.id.id_temp_min_day_3);
        id_temp_min_day_4 = (TextView) itemView.findViewById(R.id.id_temp_min_day_4);
        id_temp_min_day_5 = (TextView) itemView.findViewById(R.id.id_temp_min_day_5);
        id_temp_min_day_6 = (TextView) itemView.findViewById(R.id.id_temp_min_day_6);
        id_temp_min_day_7 = (TextView) itemView.findViewById(R.id.id_temp_min_day_7);
        id_date_day_1 = (TextView) itemView.findViewById(R.id.id_date_day_1);
        id_date_day_2 = (TextView) itemView.findViewById(R.id.id_date_day_2);
        id_date_day_3= (TextView) itemView.findViewById(R.id.id_date_day_3);
        id_date_day_4 = (TextView) itemView.findViewById(R.id.id_date_day_4);
        id_date_day_5 = (TextView) itemView.findViewById(R.id.id_date_day_5);
        id_date_day_6 = (TextView) itemView.findViewById(R.id.id_date_day_6);
        id_date_day_7 = (TextView) itemView.findViewById(R.id.id_date_day_7);
        id_weather_desc_day_1 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_1);
        id_weather_desc_day_2 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_2);
        id_weather_desc_day_3= (TextView) itemView.findViewById(R.id.id_weather_desc_day_3);
        id_weather_desc_day_4 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_4);
        id_weather_desc_day_5 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_5);
        id_weather_desc_day_6 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_6);
        id_weather_desc_day_7 = (TextView) itemView.findViewById(R.id.id_weather_desc_day_7);
        id_container_day_1 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_1);
        id_container_day_2 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_2);
        id_container_day_3= (ConstraintLayout) itemView.findViewById(R.id.id_container_day_3);
        id_container_day_4 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_4);
        id_container_day_5 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_5);
        id_container_day_6 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_6);
        id_container_day_7 = (ConstraintLayout) itemView.findViewById(R.id.id_container_day_7);

        return itemView;
    }

}
