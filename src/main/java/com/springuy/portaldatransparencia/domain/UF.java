package com.springuy.portaldatransparencia.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class UF implements Serializable {

    private String nome;

    private String sigla;

}
