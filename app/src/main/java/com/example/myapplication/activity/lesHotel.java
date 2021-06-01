package com.example.myapplication.activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class lesHotel extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;

    private RatingBar ratingbar;
    private RatingBar ratingbar1;
    private RatingBar ratingbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_hotel);
        init();

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lesHotel.this, Hotel_Julius.class);
                startActivity(i);

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lesHotel.this,Hotel_Club_Ksar_Eljem.class);
                startActivity(i);

            }
        });


        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(lesHotel.this, String.valueOf(rating), Toast.LENGTH_LONG).show();

            }
        });

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(lesHotel.this, String.valueOf(rating), Toast.LENGTH_LONG).show();
            }
        });








    }
    void init() {

        textView1 = findViewById(R.id.textView3);
        textView2 =findViewById(R.id.textView5);

    }

}

