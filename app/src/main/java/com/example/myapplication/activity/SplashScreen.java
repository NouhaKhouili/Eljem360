package com.example.myapplication.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import steelkiwi.com.library.DotsLoaderView;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 5000;
    DotsLoaderView dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

dots =(DotsLoaderView)findViewById(R.id.dotsLoaderView);
downloadDemo();
    }

    private void downloadDemo() {
        AsyncTask<String,String,String> demoAsync =new AsyncTask<String, String, String>() {

          @Override
          protected  void onPreExecute(){

              dots.show();
          }

            @Override
            protected String doInBackground(String... strings) {
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e){e.printStackTrace();}
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                if(s.equals("done"))
                    dots.hide();
            }
        };
   demoAsync.execute();
    }
}
