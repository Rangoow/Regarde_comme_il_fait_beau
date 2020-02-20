package com.isen.regardecommeilfaitbeau.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.isen.regardecommeilfaitbeau.ui.fragments.DetailsFragment;
import com.isen.regardecommeilfaitbeau.ui.fragments.ForecastFragment;
import com.isen.regardecommeilfaitbeau.ui.fragments.TodayWeatherFragment;

public class PageAdapter extends FragmentPagerAdapter {



    public PageAdapter(FragmentManager mgr){
        super(mgr);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return(DetailsFragment.newInstance());
            case 1:
                return(TodayWeatherFragment.newInstance());
            case 2:
                return(ForecastFragment.newInstance());
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return(3);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Details";
            case 1:
                return "Today";
            case 2:
                return "Forecast";
            default:
                return null;
        }
    }

}
