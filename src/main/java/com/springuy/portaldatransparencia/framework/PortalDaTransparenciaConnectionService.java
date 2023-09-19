package com.springuy.portaldatransparencia.framework;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

class PortalDaTransparenciaConnectionService implements ConnectionService {

    @Override
    public HttpsURLConnection connect(String urlParameter) {

        try {
            URL url = new URL("https://api.portaldatransparencia.gov.br/api-de-dados" + urlParameter);
            HttpsURLConnection connector = (HttpsURLConnection) url.openConnection();
            connector.setRequestMethod("GET");
            connector.setConnectTimeout(500);//TODO: set in a parameterizable way.
            connector.setRequestProperty("Content-Type", "application/json");
            connector.setRequestProperty("User-Agent", "api-jar");//TODO: set in a parameterizable way.
            connector.setRequestProperty("chave-api-dados", "");//TODO: set in a parameterizable way.
            return connector;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
