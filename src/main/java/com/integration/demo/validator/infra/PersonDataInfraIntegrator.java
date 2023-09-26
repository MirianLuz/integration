package com.integration.demo.validator.infra;

import com.integration.demo.validator.application.api.PersonDataRequest;
import com.integration.demo.validator.application.service.PersonDataIntegrator;
import com.integration.demo.validator.application.service.PersonDataOfficial;
import com.integration.demo.validator.application.service.SerproClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PersonDataInfraIntegrator implements PersonDataIntegrator {
    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
    private final SerproClientFeign serproClientFeign;

    @Override
    public PersonDataOfficial getPersonData(PersonDataRequest personDataRequest) {
        log.info("[start] PersonDataInfraIntegrator - getPersonData");
        log.debug("[personDataRequest] {}", personDataRequest);
        PersonDataOfficial personDataOfficial = serproClientFeign.getConsultaCPF(TOKEN,personDataRequest.getCpf());
        log.debug("[personDataOfficial] {}", personDataOfficial);
        log.info("[finish] PersonDataInfraIntegrator - getPersonData");
        return personDataOfficial;
    }
}
