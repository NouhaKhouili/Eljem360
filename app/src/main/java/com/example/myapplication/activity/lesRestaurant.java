package com.example.myapplication.activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class lesRestaurant extends AppCompatActivity {

   private RatingBar ratingbar;
    private RatingBar ratingbar1;


    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesrestaurant);

        init();
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lesRestaurant.this, Restaurant_Le_Bonheur1.class);
                startActivity(i);

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(lesRestaurant.this, Restaurant_Chahia.class);
                startActivity(i);

            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(lesRestaurant.this, String.valueOf(rating), Toast.LENGTH_LONG).show();
            }
        });

        RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingBar2);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(lesRestaurant.this, String.valueOf(rating), Toast.LENGTH_LONG).show();
            }
        });


    }
    void init() {

        textView1 = findViewById(R.id.textView3);
        textView2 =findViewById(R.id.textView5);

    }
}
