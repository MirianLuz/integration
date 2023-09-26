package com.integration.demo.validator.application.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataRequestTest {

    @Test
    void testGetBirthDateLocalDateWithValidDate(){
        PersonDataRequest personDataRequest = new PersonDataRequest("1111111111", "Name","1990-01-14");
        LocalDate localDate = personDataRequest.getBirthDateLocalDate();
        assertNotNull(localDate);
        assertEquals(LocalDate.of(1990,1,14), localDate);
    }

    @Test
    void testGetBirthDateLocalDateWithInvalidDate(){
        PersonDataRequest personDataRequest = new PersonDataRequest("sameCPF", "same name", "19900114");
        LocalDate localDate = personDataRequest.getBirthDateLocalDate();
        assertNull(localDate);
    }
}