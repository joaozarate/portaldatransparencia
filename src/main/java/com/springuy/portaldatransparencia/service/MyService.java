package com.springuy.portaldatransparencia.service;

public class MyService {

    private IConnectionService connection;

    public MyService(IConnectionService connection) {
        this.connection = connection;
    }

}
