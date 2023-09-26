package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PersonDataValidatorApplicationService implements PersonDataValidatorService {
    private final PersonDataIntegrator personDataIntegrator;
    @Override
    public PersonDataValidationResponse valides(PersonDataRequest personDataRequest) {
        log.info("[start] PersonDataValidatorApplicationService - valides");
        log.info("[personDataRequest] {}", personDataRequest);
        PersonDataOfficial personDataOfficial = personDataIntegrator.getPersonData(personDataRequest);
        PersonDataValidationResponse personDataValidationResponse = personDataOfficial.valides(personDataRequest);
        log.info("[finish] PersonDataValidatorApplicationService - valides");
        return personDataValidationResponse;
    }
}
