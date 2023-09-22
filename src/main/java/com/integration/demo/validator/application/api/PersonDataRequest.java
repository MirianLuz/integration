package com.integration.demo.validator.application.api;

import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}", message = "Data de nascimento deve estar no formato: yyyy-MM-dd")
    private String brithDate;
}
