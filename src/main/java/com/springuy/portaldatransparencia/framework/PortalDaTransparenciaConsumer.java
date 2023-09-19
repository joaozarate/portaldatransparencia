package com.springuy.portaldatransparencia.framework;

import lombok.Cleanup;
import lombok.RequiredArgsConstructor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RequiredArgsConstructor
class PortalDaTransparenciaConsumer implements Consumer {

    private final ConnectionService connectionService;

    @Override
    public String retrieveData(String urlParameter) {
        @Cleanup(value = "disconnect")
        HttpsURLConnection connector = connectionService.connect(urlParameter);

        StringBuilder response = new StringBuilder();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(connector.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.toString();
    }

}
