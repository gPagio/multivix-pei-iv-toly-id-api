package br.edu.multivix.pei.tolyid.domain.tatu.dto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotNull;

@Hidden
public record DadosCadastroTatuDTO (@NotNull(message = "A identificação do animal deve ser informada para realizar seu cadastro!")
                                    String identificacaoAnimal,
                                    Integer numeroMicrochip){ }
