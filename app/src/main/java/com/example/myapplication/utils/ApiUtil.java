package com.example.myapplication.utils;


import com.example.myapplication.dao.IUser;

public class ApiUtil {

//3002

    private static final String BASE_URL = "http://192.168.56.1";
    public static IUser getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(IUser.class);
    }
}
