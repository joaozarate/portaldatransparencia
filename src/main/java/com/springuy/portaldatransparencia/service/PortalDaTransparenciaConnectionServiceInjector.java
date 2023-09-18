package com.springuy.portaldatransparencia.service;

import com.springuy.PortalDaTransparenciaConsumer;

public class PortalDaTransparenciaConnectionServiceInjector implements ConnectionServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new PortalDaTransparenciaConsumer(new PortalDaTransparenciaConnectionService());
    }

}
