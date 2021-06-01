package com.example.myapplication;


import android.os.Bundle;
import android.widget.RatingBar;

public class EditModel {

    private String editTextValue;
    private RatingBar ratingBar;



    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(RatingBar ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getEditTextValue() {
        return editTextValue;
    }



    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }
}