package br.edu.multivix.pei.tolyid.domain.tatu;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTatuDTO (@NotNull(message = "A identificação do animal deve ser informada para realizar seu cadastro!")
                                    String identificacaoAnimal,
                                    Integer numeroMicrochip){ }
