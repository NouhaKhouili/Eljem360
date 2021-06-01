package com.example.myapplication.activity;

import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.HashMap;

public class Home extends AppCompatActivity {



    private EditText editTextRecherche;
    private Button btnmange ;
    private Button  btnTransportetparking ;
    private Button  btnSortieetloisir ;
    private Button  btnInfoPratique ;
    private Button  btnMonguide ;
    private Button  btnVisiteVirtuelle ;

    private SliderLayout sliderLayout;



    // Google Map
    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextRecherche = findViewById(R.id.editText7);
        btnmange = findViewById(R.id.button5);
        btnTransportetparking = findViewById(R.id.button6);
        btnSortieetloisir = findViewById(R.id.button7);
        btnInfoPratique = findViewById(R.id.button8);
        btnMonguide = findViewById(R.id.button12);
        btnVisiteVirtuelle = findViewById(R.id.button13);


        if(isServicesOK()){
            init();
        }




        btnmange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, MangeretDormir.class);
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

        for (int i = 0; i <= 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.dar_eljem3);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.bonheur1);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.pregos_cafe_ph1);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.juluis1);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.hotel_club_kssar_eljem1);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("The quick brown fox jumps over the lazy dog.\n" + "Jackdaws love my big sphinx of quartz. " + (i + 1));
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //Toast.makeText(Home.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    private void init(){
        btnMonguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Home.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Home.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}

//hethi fel manifest ki tabda t7eb tna7i el bar el fou9aniya: android:theme="@style/AppTheme.NoActionBar"
