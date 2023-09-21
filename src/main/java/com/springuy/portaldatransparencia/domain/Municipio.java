package com.springuy.portaldatransparencia.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Municipio implements Serializable {

    private String codigoIBGE;

    private String codigoRegiao;

    private String nomeIBGE;

    private String nomeRegiao;

    private String pais;

    private UF uf;

}
