package com.example.myapplication.activity;


import android.os.Bundle;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;


import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class dar_eljem extends AppCompatActivity {

    private SliderLayout sliderLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dar_eljem);


        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);
        setSliderViews();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 1; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.dar_eljem3);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.dar_eljem2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.dar_eljem3);
                    break;




            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(dar_eljem.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });


            sliderLayout.addSliderView(sliderView);
        }

    }
}
