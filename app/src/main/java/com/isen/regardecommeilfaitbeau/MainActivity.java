package com.isen.regardecommeilfaitbeau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.isen.regardecommeilfaitbeau.ui.adapters.ViewPagerAdapter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Dexter.withActivity(this).withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if(report.areAllPermissionsGranted()){
                    buildLocationRequest();
                    buildLocationCallBack();
                    if ((ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                        return;
                    }
                    fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(MainActivity.this);
                    fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper());
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Snackbar.make(coordinatorLayout,"Permission Denied",Snackbar.LENGTH_LONG).show();
            }
        }).check();
    }

    private void buildLocationRequest() {

        locationRequest=new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10.0f);
    }
    private void buildLocationCallBack() {
        locationCallback=new LocationCallback(){
            @Override
            public void onLocationResult(final LocationResult locationResult) {
                super.onLocationResult(locationResult);
                viewPager=(ViewPager)findViewById(R.id.viewPager_id);
                setupViewPager(viewPager);
                tabLayout=(TabLayout)findViewById(R.id.tabLayout_id);
                tabLayout.setupWithViewPager(viewPager);
                Log.d("Location",locationResult.getLastLocation().getLatitude()+"/"+locationResult.getLastLocation().getLongitude());
                String url= "https://api.darksky.net/forecast/347751702a8e07653944d37734b1f942/" + Double.parseDouble(String.valueOf(locationResult.getLastLocation().getLatitude()))
                        + "," + Double.parseDouble(String.valueOf(locationResult.getLastLocation().getLongitude())) + "?lang=fr&units=ca&exclude=minutely";
                JsonObjectRequest jor=new JsonObjectRequest(Request.Method.GET, url, (String) null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject main_object=response.getJSONObject("currently");
                            String temp=String.valueOf(main_object.getDouble("temperature"));
                            String description=(main_object.getString("summary"));
                            String wind=String.valueOf(main_object.getDouble("windSpeed"));
                            String humidity=String.valueOf(main_object.getDouble("humidity"));
                            String pressure=String.valueOf(main_object.getDouble("pressure"));
                            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                            List<Address> addresse = geocoder.getFromLocation(locationResult.getLastLocation().getLatitude(), locationResult.getLastLocation().getLongitude(), 1);
                            today_weatherFragment.city_id.setText(new StringBuilder(addresse.get(0).getLocality()).toString());
                            today_weatherFragment.temperature_id.setText(new StringBuilder(temp).toString());
                            today_weatherFragment.weatherDescription_id.setText(new StringBuilder(description));
                            DetailsFragment.humitidtyVal_id.setText(new StringBuilder("Humidity:  ").append((humidity)).append("").toString());
                            DetailsFragment.PressureVal_id.setText(new StringBuilder("Pressure:  ").append((pressure)).append("hpa").toString());
                            DetailsFragment.windVal_id.setText(new StringBuilder("WindSpeed:  ").append((wind)).append("km/h").toString());
                            Calendar calendar=Calendar.getInstance();
                            SimpleDateFormat sdf= new SimpleDateFormat("EEEE:  dd-MM-yyyy");
                            String formatted= sdf.format(calendar.getTime());
                            DetailsFragment.date_id.setText(formatted);
                            String descr=main_object.getString("icon");
                            //today
                            Picasso.get().load(new StringBuilder("https://darksky.net/images/weather-icons/").append(descr)
                            .append(".png").toString()).into(today_weatherFragment.weatherDescriptionIcon_id);
                            //detail
                            Picasso.get().load(new StringBuilder("https://darksky.net/images/weather-icons/").append(descr)
                                    .append(".png").toString()).into(DetailsFragment.weatherDescriptionIcon_id);
                            JSONObject mains_object=response.getJSONObject("daily");
                            JSONArray jArray = mains_object.getJSONArray("data");
                            for (int i=0; i < mains_object.length(); i++)
                            {
                                try {
                                    JSONObject oneObject = jArray.getJSONObject(0);
                                    String oneObjectsItem = oneObject.getString("sunriseTime");
                                    String oneObjectsItem2 = oneObject.getString("sunsetTime");
                                    long unixTimestamp = Long.parseLong(oneObjectsItem);
                                    long javaTimestamp = unixTimestamp * 1000L;
                                    Date date = new Date(javaTimestamp);
                                    SimpleDateFormat sd= new SimpleDateFormat("hh:mm");
                                    sd.setTimeZone(TimeZone.getTimeZone("GMT+1"));
                                    String sunrise = sd.format(date);
                                    long unixTimestamp1= Long.parseLong(oneObjectsItem2);
                                    long javaTimestamp1 = unixTimestamp1 * 1000L;
                                    Date date1 = new Date(javaTimestamp1);
                                    SimpleDateFormat sds= new SimpleDateFormat("hh:mm");
                                    sds.setTimeZone(TimeZone.getTimeZone("GMT+1"));
                                    String sunset = sds.format(date1);
                                    DetailsFragment.sunriseVal_id.setText(new StringBuilder("SunRise:  ").append((sunrise)).append("AM"));
                                    DetailsFragment.sunsetVal_id.setText(new StringBuilder("SunSet:  ").append((sunset)).append("PM"));
                                } catch (JSONException e) {
                                }
                                JSONObject oneObject = jArray.getJSONObject(0);
                                String temperaturemin = oneObject.getString("temperatureMin");
                                String temperaturemax = oneObject.getString("temperatureMax");
                                String descriptions=(oneObject.getString("summary"));
                                DetailsFragment.temperatureMax_id.setText(new StringBuilder(temperaturemax).append("°C").toString());
                                DetailsFragment.temperatureMin_id.setText(new StringBuilder(temperaturemin).append("°C").toString());
                                DetailsFragment.weatherDescription_id.setText(new StringBuilder(descriptions));

                                //forecast day1
                                JSONObject oneObjects1 = jArray.getJSONObject(0);
                                String tempmin1 = oneObjects1.getString("temperatureMin");
                                String tempmax1 = oneObjects1.getString("temperatureMax");
                                String descriptions1=(oneObject.getString("summary"));
                              /*  ForecastFragment.id_temp_max_day_1.setText(new StringBuilder(tempmax1).append("°C").toString());
                                ForecastFragment.id_temp_min_day_1.setText(new StringBuilder(tempmin1).append("°C").toString());*/
                               /* ForecastFragment.id_weather_desc_day_1.setText(new StringBuilder(descriptions1));*/
                                //forecast day2
                                JSONObject oneObjects2 = jArray.getJSONObject(1);
                                String tempmin2 = oneObjects2.getString("temperatureMin");
                                String tempmax2 = oneObjects2.getString("temperatureMax");
                                String descriptions2=(oneObject.getString("summary"));
                                /*ForecastFragment.id_temp_max_day_1.setText(new StringBuilder(tempmax2).append("°C").toString());
                                ForecastFragment.id_temp_min_day_1.setText(new StringBuilder(tempmin2).append("°C").toString());*/
                                /*ForecastFragment.id_weather_desc_day_1.setText(new StringBuilder(descriptions2));*/
                                //forecast day3
                                JSONObject oneObjects3 = jArray.getJSONObject(2);
                                String tempmin3 = oneObjects3.getString("temperatureMin");
                                String tempmax3 = oneObjects3.getString("temperatureMax");
                                String descriptions3=(oneObject.getString("summary"));
                                /*ForecastFragment.id_temp_max_day_1.setText(new StringBuilder(tempmax3).append("°C").toString());
                                ForecastFragment.id_temp_min_day_1.setText(new StringBuilder(tempmin3).append("°C").toString());*/
                                /*ForecastFragment.id_weather_desc_day_1.setText(new StringBuilder(descriptions3));*/



                            }

                        } catch (JSONException e) {

                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(jor);




            }
        };
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter((getSupportFragmentManager()));
        adapter.addFragment(today_weatherFragment.getInstance(),"TODAY");
        adapter.addFragment(DetailsFragment.getInstance(),"Details");
        adapter.addFragment(ForecastFragment.getInstance(),"Prevision");
        viewPager.setAdapter(adapter);

    }
}
