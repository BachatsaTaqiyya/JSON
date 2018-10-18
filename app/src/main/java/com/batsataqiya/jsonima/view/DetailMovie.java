package com.batsataqiya.jsonima.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.batsataqiya.jsonima.R;
import com.batsataqiya.jsonima.model.CONSTANT;
import com.batsataqiya.jsonima.model.ResultsItem;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovie extends AppCompatActivity {

    //TODO varibale sebagai key atau penampung data nya
    public static final String PENAMPUNG_OBJECT = "OBJECT";



    @BindView(R.id.img_Detail)
    ImageView imgDetail;
    @BindView(R.id.txt_Judul)
    TextView txtJudul;
    @BindView(R.id.txt_Tanggal)
    TextView txtTanggal;
    @BindView(R.id.txt_Deskripsi)
    TextView txtDeskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);


        getData();

    }

   public void getData() {
        ResultsItem get = getIntent().getParcelableExtra(PENAMPUNG_OBJECT);
        String title = get.getOriginalTitle();
        String date = get.getReleaseDate();
        String over = get.getOverview();
        String images = get.getPosterPath();

        txtJudul.setText(title);
        txtTanggal.setText(date);
        txtDeskripsi.setText(over);

       Glide.with(DetailMovie.this).load(images).into(imgDetail);




    }
}
