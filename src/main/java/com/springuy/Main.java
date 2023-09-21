package com.springuy;

import com.google.gson.reflect.TypeToken;
import com.springuy.portaldatransparencia.domain.AuxilioBrasilSacado;
import com.springuy.portaldatransparencia.framework.ConnectionServiceInjector;
import com.springuy.portaldatransparencia.framework.Consumer;
import com.springuy.portaldatransparencia.framework.PortalDaTransparenciaConnectionServiceInjector;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConnectionServiceInjector injector = new PortalDaTransparenciaConnectionServiceInjector();
        Consumer app = injector.getConsumer();
        List<AuxilioBrasilSacado> data = app.retrieveData("/auxilio-brasil-sacado-beneficiario-por-municipio?codigoIbge=3144805&mesAno=202301&pagina=1", new TypeToken<ArrayList<AuxilioBrasilSacado>>() {
        }.getType());

        System.out.println(data);

    }

}
