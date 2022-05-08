package com.example.demo3.service;

import java.util.Date;

public class UtilService {
    public UtilService(){}
    public Date getToDay()
    {
        long millis=System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        return date;
    }

}
