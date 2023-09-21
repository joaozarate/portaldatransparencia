package com.springuy.portaldatransparencia.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AuxilioBrasilSacado {

    private BeneficiarioAuxilioBrasil beneficiarioAuxilioBrasil;

    private String dataMesCompetencia;

    private String dataMesReferencia;

    private String dataSaque;

    private Long id;

    private Municipio municipio;

    private BigDecimal valorSaque;

}
