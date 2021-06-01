package com.example.myapplication;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv = (TextView) findViewById(R.id.tv);

        for (int i = 0; i < CustomAdapter.editModelArrayList.size(); i++){

            tv.setText(tv.getText() + " " + CustomAdapter.editModelArrayList.get(i).getEditTextValue() +System.getProperty("line.separator"));

        }


    }
}
