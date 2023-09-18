package com.springuy;

import com.springuy.portaldatransparencia.service.ConnectionServiceInjector;
import com.springuy.portaldatransparencia.service.Consumer;
import com.springuy.portaldatransparencia.service.PortalDaTransparenciaConnectionServiceInjector;

public class Main {
    public static void main(String[] args) {

        ConnectionServiceInjector injector;
        Consumer app;

        injector = new PortalDaTransparenciaConnectionServiceInjector();
        app = injector.getConsumer();
        app.retrieveData("/bpc-por-municipio?codigoIbge=3144805&mesAno=202301&pagina=1");

    }
}