package com.batsataqiya.jsonima.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.batsataqiya.jsonima.model.CONSTANT;
import com.batsataqiya.jsonima.model.ResultsItem;
import com.batsataqiya.jsonima.R;
import com.batsataqiya.jsonima.view.DetailMovie;
import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by batsataqiya on 15/10/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    Context context;
    List<ResultsItem> data;

    //
    public RecyclerAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.customview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        //TODO tampung data nya dalam variable string
        final ResultsItem item = data.get(position);
        final String title = item.getOriginalTitle();
        final String date = item.getReleaseDate();
        final String overview = item.getOverview();
        final String images = CONSTANT.IMAGE_URL + item.getPosterPath();

        //TODO show ke text view
        holder.txtJudul.setText(title);
        holder.txtTanggal.setText(date);
        holder.txtKeterangan.setText(overview);

        Glide.with(context)
                .load(images)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO instance class / buat object dari class
                ResultsItem object = new ResultsItem();
                object.setOriginalTitle(title);
                object.setReleaseDate(date);
                object.setOverview(overview);
                object.setPosterPath(images);

                Intent objectIntent = new Intent(context, DetailMovie.class);
                objectIntent.putExtra(DetailMovie.PENAMPUNG_OBJECT, object);
                context.startActivity(objectIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtJudul, txtKeterangan, txtTanggal;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_View);
            txtJudul = itemView.findViewById(R.id.txt_Judul);
            txtKeterangan = itemView.findViewById(R.id.txt_Keterangan);
            txtTanggal = itemView.findViewById(R.id.txt_Tanggal);
        }
    }
}
