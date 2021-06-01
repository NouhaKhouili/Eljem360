package com.example.myapplication.activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MangeretDormir extends AppCompatActivity {

    private SliderLayout sliderLayout;

    private Button btncafe;
    private Button btnrestau;
    private Button btnhotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangeret_dormir);


        init();

        btncafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MangeretDormir.this, lescafe.class);
                startActivity(i);
            }
        });

        btnrestau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MangeretDormir.this, lesRestaurant.class);
                startActivity(i);
            }
        });


        btnhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MangeretDormir.this, lesHotel.class);
                startActivity(i);
            }
        });

       sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);
        setSliderViews();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.dar_eljem3);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.juluis1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.bonheur1);
                    break;
               case 3:
                    sliderView.setImageDrawable(R.drawable.pregos_cafe_ph1);
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MangeretDormir.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });


            sliderLayout.addSliderView(sliderView);
        }

    }

    void init() {

        btncafe = findViewById(R.id.button10);
        btnrestau=findViewById(R.id.button9);
        btnhotel=findViewById(R.id.button11);

    }
}
