package com.example.quanlysinhvien.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {

    private static Retrofit retrofit = null;

    private RetrofitInit() {

    }

    public static ApiRequest getInStance() {
        if (retrofit == null) {
            retrofit = initRetro();
        }
        return retrofit.create(ApiRequest.class);

    }

    private static Retrofit initRetro() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://perissodactyl-gallo.000webhostapp.com/apiSinhvien/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
