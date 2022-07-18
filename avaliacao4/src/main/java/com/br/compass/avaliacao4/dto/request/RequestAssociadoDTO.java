package com.br.compass.avaliacao4.dto.request;

import com.br.compass.avaliacao4.enuns.Sexo;
import com.br.compass.avaliacao4.enuns.CargoPolitico;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Data
public class RequestAssociadoDTO {

    @NotBlank
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private CargoPolitico cargoPolitico;

    private String dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
