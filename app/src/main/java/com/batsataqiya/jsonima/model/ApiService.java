package com.batsataqiya.jsonima.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by batsataqiya on 15/10/18.
 */

public interface ApiService {
    @GET("movie/upcoming")
    Call<ResponseMovie> getUpComingMoviee(@Query("api_key") String apikey,
                                          @Query("language") String language);

}
