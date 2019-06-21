package com.example.genericmed.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.genericmed.R;
import com.example.genericmed.activities.MedActivity;
import com.example.genericmed.model.Med;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Med> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Med> mData) {

        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.med_row_item, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, MedActivity.class);
                i.putExtra("med_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("med_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("med_price",mData.get(viewHolder.getAdapterPosition()).getPrice());
                i.putExtra("med_company",mData.get(viewHolder.getAdapterPosition()).getCompany());
                i.putExtra("med_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("med_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("med_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_price.setText(mData.get(position).getPrice());
        holder.tv_company.setText(mData.get(position).getCompany());

        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_price ;
        TextView tv_company;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.med_name);
            tv_company = itemView.findViewById(R.id.company);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_price = itemView.findViewById(R.id.price);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}