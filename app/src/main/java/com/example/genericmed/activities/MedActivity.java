package com.example.genericmed.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.genericmed.BuyActivity;
import com.example.genericmed.R;

public class MedActivity extends AppCompatActivity {

    Button buy_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);

        buy_now = (Button)findViewById(R.id.buy_now);

        // hide the default actionbar
        getSupportActionBar().hide();

        // Receive data

        String name  = getIntent().getExtras().getString("med_name");
        String description = getIntent().getExtras().getString("med_description");
        String price = getIntent().getExtras().getString("med_price") ;
        String company = getIntent().getExtras().getString("med_company");
        int nb_episode = getIntent().getExtras().getInt("med_nb_episode") ;
        String rating = getIntent().getExtras().getString("med_rating") ;
        String image_url = getIntent().getExtras().getString("med_img") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_med_name);
        TextView tv_price = findViewById(R.id.aa_price);
        TextView tv_company = findViewById(R.id.aa_company);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating  = findViewById(R.id.aa_rating);
        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(name);
        tv_company.setText(company);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_price.setText(price);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        // set image using Glide
        Glide.with(MedActivity.this).load(image_url).apply(requestOptions).into(img);


        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedActivity.this, BuyActivity.class);
                startActivity(intent);
            }
        });
    }
}