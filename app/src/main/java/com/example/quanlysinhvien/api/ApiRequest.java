package com.example.quanlysinhvien.api;

import com.example.quanlysinhvien.model.Response;
import com.example.quanlysinhvien.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("sinhvien.php")
    Flowable<Response<List<Sinhvien>>> getListSinhVien();

}
