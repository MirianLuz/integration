package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;

public interface PersonDataIntegrator {
    PersonDataOfficial getPersonData(PersonDataRequest personDataRequest);
}
