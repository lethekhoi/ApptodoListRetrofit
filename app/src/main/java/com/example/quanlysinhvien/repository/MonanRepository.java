package com.example.quanlysinhvien.repository;

import com.example.quanlysinhvien.api.ApiRequest;
import com.example.quanlysinhvien.api.RetrofitInit;
import com.example.quanlysinhvien.model.Response;
import com.example.quanlysinhvien.model.Sinhvien;

import java.util.List;

import io.reactivex.Flowable;

public class MonanRepository<A> {

    private ApiRequest apiRequest;
    private static MonanRepository monanRepository = null;

    private MonanRepository() {
        apiRequest = RetrofitInit.getInStance();
        // khoi tao retrofit
        //goi apiRequesr để gọi chức năng ko cần test nữa
    }

    public static MonanRepository getInstance() {
        if (monanRepository == null) {
            monanRepository = new MonanRepository();
        }
        return monanRepository;
    }

    public Flowable<Response<List<Sinhvien>>> getSinhvien() {
        return apiRequest.getListSinhVien();
    }


}

