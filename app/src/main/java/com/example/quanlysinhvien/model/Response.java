package com.example.quanlysinhvien.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T> {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private T data = null;

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }
}