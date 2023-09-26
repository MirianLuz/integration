package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PersonDataInfraIntegrator implements PersonDataIntegrator {
    @Override
    public PersonDataOfficial getPersonData(PersonDataRequest personDataRequest) {
        log.info("[start] PersonDataInfraIntegrator - getPersonData");
        log.info("[personDataRequest] {}", personDataRequest);

        log.info("[finish] PersonDataInfraIntegrator - getPersonData");
        return null;
    }
}
