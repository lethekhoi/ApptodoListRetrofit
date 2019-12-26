package com.example.quanlysinhvien.api;

import retrofit2.Retrofit;

public class RetrofitInit {
    private static Retrofit retrofit = null;
    private RetrofitInit(){


    }

    public static ApiRequest getInStance(){

        if(retrofit==null){
            retrofit =initRetro();

        }
    }

    private static Retrofit initRetro() {
    }

}
