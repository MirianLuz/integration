package com.integration.demo.validator.application.api;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PersonDataRequest {
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Data de nascimento deve estar no formato: yyyy-MM-dd")
    private String birthDate;

    public LocalDate getBirthDateLocalDate(){
        try {
            return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyy-MM-dd"));
        } catch (Exception e){
            return null;
        }
    }
}