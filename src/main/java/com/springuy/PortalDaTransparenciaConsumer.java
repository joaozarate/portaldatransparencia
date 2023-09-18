package com.springuy;

import com.springuy.portaldatransparencia.service.ConnectionService;
import com.springuy.portaldatransparencia.service.Consumer;
import lombok.Cleanup;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PortalDaTransparenciaConsumer implements Consumer {

    private ConnectionService connectionService;

    public PortalDaTransparenciaConsumer(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public void retrieveData(String urlParameter) {
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

        System.out.println(response);
    }
}
