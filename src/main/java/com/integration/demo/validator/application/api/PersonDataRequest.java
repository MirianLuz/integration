package com.integration.demo.validator.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PersonDataRequest {
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    private String name;
    @NotBlank
    private String brithDate;
}
