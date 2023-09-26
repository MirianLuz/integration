package com.integration.demo.validator.application.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PersonDataOfficial {
    @JsonProperty("ni")
    private String cpf;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("nascimento")
    private String dataNascimento;
    @JsonProperty("situacao")
    private SituacaoCPF situacao;

    public PersonDataValidationResponse valides(PersonDataRequest personDataRequest) {

        if (cpf != null ? !cpf.equals(personDataRequest.getCpf()) : personDataRequest.getCpf() != null) return getInvalid();
        if (nome != null ? !nome.equals(personDataRequest.getName()) : personDataRequest.getName() != null) return getInvalid();
        if (getDataNascimentoLocalDate() != null ? !getDataNascimentoLocalDate().equals(personDataRequest.getBirthDateLocalDate()) : personDataRequest.getBirthDateLocalDate() != null) return getInvalid();
        return getValid();
    }

     LocalDate getDataNascimentoLocalDate(){
        try {
            return LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("ddMMyyyy"));
        } catch (Exception e){
            return null;
        }
    }

    private PersonDataValidationResponse getValid(){ return new PersonDataValidationResponse("VALID"); }
    private PersonDataValidationResponse getInvalid(){ return new PersonDataValidationResponse("INVALID"); }

}