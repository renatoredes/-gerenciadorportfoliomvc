package com.br.gerenciadorportfolio.util;

import com.br.gerenciadorportfolio.entity.Gerente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MockProvider {

    public static final Long ID = 1L;

    public static Gerente generateMockGerente(){
        return Gerente.builder()
                .id(ID)
                .nome("nomeTest")
                .build();
    }
}
