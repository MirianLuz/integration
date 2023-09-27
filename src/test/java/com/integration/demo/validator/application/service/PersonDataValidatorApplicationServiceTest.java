package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonDataValidatorApplicationServiceTest {

    @Mock
    private PersonDataIntegrator personDataIntegrator;

    @InjectMocks
    private PersonDataValidatorApplicationService personDataValidatorApplicationService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnValidWhenOfficialDataMatches(){
        PersonDataRequest request = PersonDataRequest.builder()
                .cpf("40442820135")
                .name("Nome do CPF 404.428.201-35")
                .birthDate("1999-01-01")
                .build();

        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .cpf("40442820135")
                .nome("Nome do CPF 404.428.201-35")
                .dataNascimento("01011999")
                .build();

        when(personDataIntegrator.getPersonData(request)).thenReturn(personDataOfficial);

        PersonDataValidationResponse response = personDataValidatorApplicationService.valides(request);

        assertEquals("VALID", response.getStatus());
    }

    @Test
    void shouldReturnInvalidWhenOfficialDataDiffers(){
        PersonDataRequest request = PersonDataRequest.builder()
                .cpf("40442820135")
                .name("Nome do CPF 404.428.201-35")
                .birthDate("1999-01-01")
                .build();

        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .cpf("92827431017")
                .nome("Nome do CPF 928.274.310-17")
                .dataNascimento("02021999")
                .build();

        when(personDataIntegrator.getPersonData(request)).thenReturn(personDataOfficial);

        PersonDataValidationResponse response = personDataValidatorApplicationService.valides(request);

        assertEquals("INVALID", response.getStatus());
    }

    @Test
    void shouldCallIntegratorToFetchOfficialData(){
        PersonDataRequest request = PersonDataRequest.builder()
                .cpf("40442820135")
                .name("Nome do CPF 404.428.201-35")
                .birthDate("1999-01-01")
                .build();

        PersonDataOfficial personDataOfficial = PersonDataOfficial.builder()
                .cpf("40442820135")
                .nome("Nome do CPF 404.428.201-35")
                .dataNascimento("01011999")
                .build();

        when(personDataIntegrator.getPersonData(request)).thenReturn(personDataOfficial);

        personDataValidatorApplicationService.valides(request);

        verify(personDataIntegrator, times(1)).getPersonData(request);
    }

}