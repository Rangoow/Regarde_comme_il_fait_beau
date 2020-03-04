package com.isen.regardecommeilfaitbeau.widget;
import com.isen.regardecommeilfaitbeau.api.Prevision;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;

import com.isen.regardecommeilfaitbeau.R;
import com.isen.regardecommeilfaitbeau.exception.NumberHoursOfDayException;

import org.json.JSONException;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link WeatherWidgetConfigureActivity WeatherWidgetConfigureActivity}
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class WeatherWidget extends AppWidgetProvider {
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) throws JSONException, NumberHoursOfDayException {
        CharSequence widgetText = WeatherWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        Prevision prevision = new Prevision(50.6342719, 3.0487597);
            String CurrentTemp = Double.toString(prevision.getCurrently().getTemperature());
           /* views.setTextViewText(R.id.temperature,CurrentTemp);
            String minTemp = Double.toString(prevision.getMeteoDay().get(0).getTemperatureMin());
            views.setTextViewText(R.id.MinTemp,minTemp);
            String maxTemp = Double.toString(prevision.getMeteoDay().get(0).getTemperatureMax());
            views.setTextViewText(R.id.MaxTemp,maxTemp);
            String rainTemp = Double.toString(prevision.getMeteoDay().get(0).getPrecipProbability()*100)+"%";
            views.setTextViewText(R.id.mintemp,rainTemp);
            String Weather = prevision.getCurrently().getSummary();
            views.setTextViewText(R.id.weatherDescription,Weather);*/


        //Set the image view
        int sun = R.drawable.ic_wi_day_sunny;
        views.setImageViewResource(R.id.imageView, sun);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            try {
                updateAppWidget(context, appWidgetManager, appWidgetId);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (NumberHoursOfDayException f) {
                f.printStackTrace();
            }

        }}

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            WeatherWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

