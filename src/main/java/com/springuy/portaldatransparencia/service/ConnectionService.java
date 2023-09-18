package com.springuy.portaldatransparencia.service;

import javax.net.ssl.HttpsURLConnection;

public interface ConnectionService {

    HttpsURLConnection connect(String urlParameter);

}
