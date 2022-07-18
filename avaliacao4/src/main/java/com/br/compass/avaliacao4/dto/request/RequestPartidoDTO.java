package com.br.compass.avaliacao4.dto.request;

import com.br.compass.avaliacao4.enuns.Ideologia;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class RequestPartidoDTO {

    @NotBlank
    private String nomeDoPartido;

    @NotBlank
    private String sigla;

    @Enumerated(value = EnumType.STRING)
    private String ideologia;

    private String dataDeFundacao;
}
