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
    @Override
    public PersonDataValidationResponse valides(PersonDataRequest personDataRequest) {
        log.info("[start] PersonDataValidatorApplicationService - valides");
        log.info("[personDataRequest] {}", personDataRequest);

        log.info("[finish] PersonDataValidatorApplicationService - valides");
        return null;

    }
}
