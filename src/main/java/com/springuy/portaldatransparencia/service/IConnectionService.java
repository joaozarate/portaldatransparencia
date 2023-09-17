package com.springuy.portaldatransparencia.service;

import javax.net.ssl.HttpsURLConnection;

public interface IConnectionService {
    HttpsURLConnection connect(String urlParameter);
}
