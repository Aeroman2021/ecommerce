package com.project.ecommerce.exception;

import java.sql.Timestamp;

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private Timestamp timestamp;

    public ApiResponse() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ApiResponse(boolean success, String message, T data) {
        this();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean success, String message) {
        this();
        this.success = success;
        this.message = message;

    }

    public static <T> ApiResponse<T> success(T data,String message){
        return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> failure(T data,String message){
        return new ApiResponse<>(false,message,data);
    }

    public static <T> ApiResponse<T> failure(String message){
        return new ApiResponse<>(false,message);
    }



}
