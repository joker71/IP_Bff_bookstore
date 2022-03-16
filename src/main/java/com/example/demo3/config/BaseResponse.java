package com.example.demo3.config;

import java.util.List;

public class BaseResponse<T> {
    private boolean success;
    private List<String> messages;
    private int statusCode;
    private T data;
    public  BaseResponse(boolean success, List<String> messages, int statusCode, T data)
    {
        this.data= data;
        this.messages= messages;
        this.statusCode= statusCode;
        this.success= success;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
