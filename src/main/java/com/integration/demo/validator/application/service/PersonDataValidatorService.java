package com.integration.demo.validator.application.service;

import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.api.PersonDataValidationResponse;

public interface PersonDataValidatorService {
    PersonDataValidationResponse valides(PersonDataRequest personDataRequest);
}
