package com.integration.demo.validator.application.api;

import com.integration.demo.validator.application.service.PersonDataValidatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PersonDataValidatorAPI {
    private final PersonDataValidatorService personDataValidatorService;
    @PostMapping(value = "/public/person-data-validation")
    @ResponseStatus(code = HttpStatus.OK)
    public PersonDataValidationResponse validesPersonData(@Valid @RequestBody PersonDataRequest personDataRequest){
        log.info("[start] PersonDataValidatorAPI - validesPersonData");
        log.info("[personDataRequest] {}", personDataRequest);
        var validation = personDataValidatorService.valides(personDataRequest);
        log.info("[finish] PersonDataValidatorAPI - validesPersonData");
        return validation;
    }
}
