package com.integration.demo.validator.application.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SituacaoCPF {
    private String codigo;
    private String descricao;
}

