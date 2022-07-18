package com.br.compass.avaliacao4.dto.response;

import lombok.Data;

@Data
public class ResponsePartidoDTO {

    private Long id;

    private String nomeDoPartido;

    private String sigla;

    private String ideologia;

    private String dataDeFundacao;
}
