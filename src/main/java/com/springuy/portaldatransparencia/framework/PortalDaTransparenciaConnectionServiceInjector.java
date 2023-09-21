package com.springuy.portaldatransparencia.framework;

public class PortalDaTransparenciaConnectionServiceInjector implements ConnectionServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new PortalDaTransparenciaConsumer(new PortalDaTransparenciaConnectionService());
    }

}
