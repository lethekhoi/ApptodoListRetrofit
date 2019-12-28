package com.example.quanlysinhvien.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.api.RetrofitInit;
import com.example.quanlysinhvien.model.Response;
import com.example.quanlysinhvien.model.Sinhvien;
import com.example.quanlysinhvien.viewmodel.MonanViewModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    MonanViewModel monanViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monanViewModel = ViewModelProviders.of(this).get(MonanViewModel.class);
        getLifecycle().addObserver(monanViewModel);
        //danh cho việc Observer
        observer();
        // call api
        setListener();
    }

    private void observer() {
        monanViewModel.dataSinhVien.observe(this, new Observer<Response<List<Sinhvien>>>() {
            @Override
            public void onChanged(Response<List<Sinhvien>> listResponse) {
                Toast.makeText(MainActivity.this, listResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setListener() {
        monanViewModel.getDataSinhVien();
    }
}
