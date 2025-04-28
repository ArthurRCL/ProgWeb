package com.progWeb.spring.progWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity

public class JogadorDeBasquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Posição é obrigatória")
    private String posicao;

    @Past(message = "Data de nascimento deve ser no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "Nacionalidade é obrigatória")
    private String nacionalidade;

    private Boolean ativo;

    @NotBlank(message = "Altura é obrigatória")
    private String altura;

    @NotNull(message = "Número do uniforme é obrigatório")
    private Long numero;
}
