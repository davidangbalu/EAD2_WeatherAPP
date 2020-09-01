package com.x00122898.weatherapiclient;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    public static final String QUERY = "http://weatherx001228988.azurewebsites.net/api/weatherinformation/";

    Context context;

    public DataService(Context context) {
        this.context = context;
    }

    public interface WeatherByCityResponse {
        void onError(String message);

        void onResponse(WeatherInformation weatherInformation);
    }

    public void getWeatherByCity(String city, final WeatherByCityResponse weatherByCityResponse) {

        List<WeatherInformation> report = new ArrayList<>();

        String url = QUERY + city;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    WeatherInformation weather = new WeatherInformation();

                    JSONObject weatherInfo = response.getJSONObject(0);
                    weather.setId(weatherInfo.getInt("id"));
                    weather.setCity(weatherInfo.getString("city"));
                    weather.setConditions(weatherInfo.getString("condition"));
                    weather.setMinTemp(weatherInfo.getInt("minTemperature"));
                    weather.setMaxTemp(weatherInfo.getInt("maxTemperature"));
                    weather.setWindDirect(weatherInfo.getString("windDirection"));
                    weather.setWindSpeed(weatherInfo.getInt("windSpeed"));
                    weather.setOutlook(weatherInfo.getString("outlook"));

                    weatherByCityResponse.onResponse(weather);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getMessage();
            }
        });
        Singleton.getInstance(context).addToRequestQueue(request);
    }

}









