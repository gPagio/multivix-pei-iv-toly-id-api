package br.edu.multivix.pei.tolyid.infra.security.autenticacao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAutenticacaoDTO(@Email(message = "Email deve possuir o formato email@email.com")
                                   @NotNull(message = "Email não pode ficar vazio")
                                   String email,

                                   String senha) {
}
