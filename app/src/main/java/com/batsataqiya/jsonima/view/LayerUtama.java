package com.batsataqiya.jsonima.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.batsataqiya.jsonima.R;
import com.batsataqiya.jsonima.model.ApiService;
import com.batsataqiya.jsonima.model.CONSTANT;
import com.batsataqiya.jsonima.model.ConfigRetrofit;
import com.batsataqiya.jsonima.model.ResponseMovie;
import com.batsataqiya.jsonima.model.ResultsItem;
import com.batsataqiya.jsonima.view.adapter.RecyclerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayerUtama extends AppCompatActivity {

    // deklarasi dong
    RecyclerView ryc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer_utama);

        // casting view dong / hub id nya
        ryc = findViewById(R.id.list_Mov);
        ryc.setLayoutManager(new GridLayoutManager(this,2));

        getDataku();
    }

    public void getDataku() {
        ApiService service = ConfigRetrofit.getClient().create(ApiService.class);
        Call<ResponseMovie> call = service.getUpComingMoviee(CONSTANT.APIKEY, CONSTANT.LANGUAGE);
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                List<ResultsItem> dataMovie = response.body().getResults();
                String data1 = response.body().getResults().toString();
                ResponseMovie responseMovie = response.body();
                Log.d(" ", "onResponse data: " + dataMovie);
                RecyclerAdapter adapterMovie = new RecyclerAdapter(getApplicationContext(), dataMovie);
                ryc.setAdapter(adapterMovie);

            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

            }
        });
    }
}
