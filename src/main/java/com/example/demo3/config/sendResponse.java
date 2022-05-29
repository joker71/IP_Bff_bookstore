package com.example.demo3.config;

public class sendResponse {
    private String status;
    private String data;
    private String description;

    public sendResponse(String status, String data, String description) {
        this.status = status;
        this.data = data;
        this.description = description;
    }

    public sendResponse() {
    }
}
