package com.x00122898.weatherapiclient;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class Singleton {
    private static Singleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private Singleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized Singleton getInstance(Context context) {
        if (instance == null) {
            instance = new Singleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}