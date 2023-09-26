package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataOfficialTest {

    @Test
    void shouldValidateWhenAllFieldsAreValid(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .cpf("40442820135")
                .nome("Nome do CPF 404.428.201-35")
                .dataNascimento("01011999")
                .build();

        PersonDataRequest personDataRequest = PersonDataRequest.builder()
                .cpf("40442820135")
                .name("Nome do CPF 404.428.201-35")
                .birthDate("1999-01-01")
                .build();

        PersonDataValidationResponse response = personDataOfficial.valides(personDataRequest);

        assertEquals("VALID", response.getStatus());
    }

    @Test
    void shouldInvalidateWhenCpfIsDifferent(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .cpf("40442820135")
                .build();

        PersonDataRequest personDataRequest = PersonDataRequest.builder()
                .cpf("92827431017")
                .build();

        PersonDataValidationResponse response = personDataOfficial.valides(personDataRequest);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void shouldInvalidateWhenNameIsDifferent(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .nome("Nome do CPF 404.428.201-35")
                .build();

        PersonDataRequest personDataRequest = PersonDataRequest.builder()
                .name("Nome do CPF 928.274.310-17")
                .build();

        PersonDataValidationResponse response = personDataOfficial.valides(personDataRequest);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void shouldInvalidateWhenBirthDateIsDifferent(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .dataNascimento("01011999")
                .build();

        PersonDataRequest personDataRequest = PersonDataRequest.builder()
                .birthDate("2000-01-01")
                .build();

        PersonDataValidationResponse response = personDataOfficial.valides(personDataRequest);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void shouldConvertValidBirthDatetoLocalDate(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .dataNascimento("01011999")
                .build();

        assertEquals("1999-01-01", personDataOfficial.getDataNascimentoLocalDate().toString());
    }

    @Test
    void shouldReturnNullWhenBirthDateIsInvalid(){
        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .dataNascimento("200101")
                .build();

        assertNull(personDataOfficial.getDataNascimentoLocalDate());
    }
}