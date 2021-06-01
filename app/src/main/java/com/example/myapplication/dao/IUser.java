package com.example.myapplication.dao;



import com.example.myapplication.models.ApiObject;
import com.example.myapplication.models.ApiReponse;
import com.example.myapplication.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUser {
    @POST("/user/auth")
    Call<ApiObject> login(@Body User user);

    @POST("/user/create")
    Call<ApiReponse> register(@Body User user);

}
