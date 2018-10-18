package com.batsataqiya.jsonima.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by batsataqiya on 15/10/18.
 */

public class ConfigRetrofit {
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(CONSTANT.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
