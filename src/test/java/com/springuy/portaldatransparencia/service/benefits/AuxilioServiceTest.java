package com.springuy.portaldatransparencia.service.benefits;

import com.springuy.portaldatransparencia.domain.AuxilioBrasilSacado;
import com.springuy.portaldatransparencia.framework.Consumer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuxilioServiceTest {

    @Mock
    Consumer consumer;

    @Test
    void callAuxilioBrasilSacadoApi() {
        AuxilioService auxilioService = new AuxilioService(consumer);

        List<AuxilioBrasilSacado> auxilioBrasilSacadoList = new ArrayList<>();
        auxilioBrasilSacadoList.add(AuxilioBrasilSacado.builder().build());
        auxilioBrasilSacadoList.add(AuxilioBrasilSacado.builder().build());
        auxilioBrasilSacadoList.add(AuxilioBrasilSacado.builder().build());

        when(consumer.retrieveData(anyString(), any(Type.class))).thenReturn(auxilioBrasilSacadoList);

        List<AuxilioBrasilSacado> result = auxilioService.callAuxilioBrasilSacadoApi("3550308", "202004", "1");
        assertEquals(3, result.size());
    }
}