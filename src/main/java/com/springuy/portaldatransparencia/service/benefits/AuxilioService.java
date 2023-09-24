package com.springuy.portaldatransparencia.service.benefits;

import com.google.gson.reflect.TypeToken;
import com.springuy.portaldatransparencia.domain.AuxilioBrasilSacado;
import com.springuy.portaldatransparencia.framework.ConnectionServiceInjector;
import com.springuy.portaldatransparencia.framework.Consumer;
import com.springuy.portaldatransparencia.framework.PortalDaTransparenciaConnectionServiceInjector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AuxilioService {

    private final Consumer consumer;

    public AuxilioService() {
        ConnectionServiceInjector injector = new PortalDaTransparenciaConnectionServiceInjector();
        consumer = injector.getConsumer();
    }

    AuxilioService(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<AuxilioBrasilSacado> callAuxilioBrasilSacadoApi(String codigoIbge, String mesAno, String pagina) {
        validate(codigoIbge, mesAno, pagina);
        String urlParameter = buildUrlParameter(codigoIbge, mesAno, pagina);
        return consumer.retrieveData(urlParameter, new TypeToken<ArrayList<AuxilioBrasilSacado>>() {}.getType());
    }

    String buildUrlParameter(String codigoIbge, String mesAno, String pagina) {
        return String.format("/auxilio-brasil-sacado-beneficiario-por-municipio?codigoIbge=%s&mesAno=%s&pagina=%s", codigoIbge, mesAno, pagina);
    }

    private void validate(String codigoIbge, String mesAno, String pagina) {
        StringBuilder errors = new StringBuilder();
        if (Objects.isNull(codigoIbge) || codigoIbge.trim().isEmpty()) {
            errors.append("\n\tcodigoIbge is required.");
        }
        if (Objects.isNull(mesAno) || mesAno.trim().isEmpty()) {
            errors.append("\n\tmesAno is required.");
        }
        if (Objects.isNull(pagina) || pagina.trim().isEmpty()) {
            errors.append("\n\tpagina is required.");
        }
        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
    }

}
