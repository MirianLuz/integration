package com.integration.demo.validator.application.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonDataOfficial {
    @JsonProperty("ni")
    private String cpf;
    private String nome;
    @JsonProperty("nascimento")
    private String dataNascimento;
    @JsonProperty("situacao")
    private SituacaoCPF situacao;

    public PersonDataValidationResponse valides(PersonDataRequest personDataRequest) {
        return null;
    }
}