package com.magad.restapitb.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfitRetrofit {

    public static String url = "https://www.thesportsdb.com/api/v1/json/1/";
    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiTeam getInstance(){
        return setInit().create(ApiTeam.class);
    }
}
