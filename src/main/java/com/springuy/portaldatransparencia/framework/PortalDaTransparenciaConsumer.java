package com.springuy.portaldatransparencia.framework;

import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

@Log
@RequiredArgsConstructor
class PortalDaTransparenciaConsumer implements Consumer {

    private final ConnectionService connectionService;

    @Override
    public String retrieveData(String urlParameter) {
        @Cleanup(value = "disconnect")
        HttpsURLConnection connector = connectionService.connect(urlParameter);

        // Even when the server returns an error, the status code is 200, but the Content-Type is text/html.
        if (!"application/json".equals(connector.getHeaderField("Content-Type"))) {
            log.log(Level.INFO, "ERROR. Error receiving the content from " + urlParameter);
            return null; //TODO: return a error object.
        }

        StringBuilder response = new StringBuilder();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(connector.getInputStream(), StandardCharsets.UTF_8))) {
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
