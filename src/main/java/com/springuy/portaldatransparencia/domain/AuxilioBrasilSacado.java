package com.springuy.portaldatransparencia.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
public class AuxilioBrasilSacado implements Serializable {

    private BeneficiarioAuxilioBrasil beneficiarioAuxilioBrasil;

    private String dataMesCompetencia;

    private String dataMesReferencia;

    private String dataSaque;

    private Long id;

    private Municipio municipio;

    private BigDecimal valorSaque;

}
