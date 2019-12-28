package com.example.quanlysinhvien.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.quanlysinhvien.model.Response;
import com.example.quanlysinhvien.model.Sinhvien;
import com.example.quanlysinhvien.repository.MonanRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MonanViewModel extends ViewModel implements LifecycleObserver {
    private CompositeDisposable disposable = new CompositeDisposable();
    private MonanRepository monanRepository = MonanRepository.getInstance();
    public MutableLiveData<Response<List<Sinhvien>>> dataSinhVien = new MutableLiveData<>();

    public void getDataSinhVien() {
        disposable.add(monanRepository
                .getSinhvien()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<List<Sinhvien>>>() {
                    @Override
                    public void accept(Response<List<Sinhvien>> listResponse) throws Exception {
                        dataSinhVien.setValue(listResponse);
                    }
                })
        );
//        return dataSinhVien;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clearSubscription() {


    }
}
