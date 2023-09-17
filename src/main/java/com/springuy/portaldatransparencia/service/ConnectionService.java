package com.springuy.portaldatransparencia.service;

import lombok.Getter;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

@Getter
public class ConnectionService implements IConnectionService {

    private HttpsURLConnection connector;

    @Override
    public HttpsURLConnection connect(String urlParameter) {

        try {
            URL url = new URL("https://api.portaldatransparencia.gov.br" + urlParameter);
            return (HttpsURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
