package com.springuy.portaldatransparencia.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BeneficiarioAuxilioBrasil implements Serializable {

    private String cpfFormatado;

    private String nis;

    private String nome;

}
