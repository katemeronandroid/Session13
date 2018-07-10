package com.firstexample.emarkova.session13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final String BASE_URL = "https://api.darksky.net/forecast/939831d11127fa45dc1d812a64d53af2/";
    public MyServer getService() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        return  retrofit.create(MyServer.class);
    }
}
