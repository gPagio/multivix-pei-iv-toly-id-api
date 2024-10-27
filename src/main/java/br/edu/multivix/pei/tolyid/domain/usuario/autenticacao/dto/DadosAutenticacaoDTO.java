package br.edu.multivix.pei.tolyid.domain.usuario.autenticacao.dto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Hidden
public record DadosAutenticacaoDTO(@Email(message = "Email deve possuir o formato email@email.com")
                                   @NotNull(message = "Email não pode ficar vazio")
                                   String email,

                                   String senha) {
}
