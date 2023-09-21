package com.springuy;

import com.springuy.portaldatransparencia.framework.ConnectionServiceInjector;
import com.springuy.portaldatransparencia.framework.Consumer;
import com.springuy.portaldatransparencia.framework.PortalDaTransparenciaConnectionServiceInjector;

public class Main {

    public static void main(String[] args) {
        ConnectionServiceInjector injector = new PortalDaTransparenciaConnectionServiceInjector();
        Consumer app = injector.getConsumer();
        String data = app.retrieveData("/bpc-por-municipio?codigoIbge=3144805&mesAno=202301&pagina=1");

        System.out.println(data);

    }

}
